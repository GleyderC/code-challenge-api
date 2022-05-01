package com.umusic.trackfinder.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.umusic.trackfinder.dto.spotify.AuthResponseDTO;
import com.umusic.trackfinder.exceptions.SpotifyApiConnectionException;
import com.umusic.trackfinder.exceptions.SpotifyAuthenticationException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;

public class SpotifyConnector {
    private static final Logger LOG = LoggerFactory.getLogger(SpotifyConnector.class);
    private final String API_URL = "https://api.spotify.com/v1/";
    private final String AUTH_URL = "https://accounts.spotify.com/api/token";
    private String accessToken = null;
    protected String tokenType = null;
    private OkHttpClient httpClient = null;

    private String clientId;
    private String clientSecret;

    public SpotifyConnector(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    private String basicAuthTokenBase64(String clientId, String clientSecret) {
        final String accessToken = clientId + ':' + clientSecret;
        return Base64.getEncoder().encodeToString(accessToken.getBytes());
    }

    public void authenticate() throws SpotifyAuthenticationException, SpotifyApiConnectionException {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder().build();
            MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
            RequestBody body = RequestBody.create(mediaType, "grant_type=client_credentials");
            Request request = new Request.Builder()
                    .url(AUTH_URL)
                    .method("POST", body)
                    .addHeader("Authorization", "Basic " + basicAuthTokenBase64(clientId, clientSecret))
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .build();
            Response response = client.newCall(request).execute();
            ResponseBody responseBody = response.body();

            LOG.trace("Spotify authentication response, status: {}, body: {} ", response.code());
            if (response.code() == 400 || response.code() == 401) {
                StringBuilder stringBuilder = new StringBuilder("Invalid credentials: ").append(responseBody != null ? responseBody.string() : response);
                throw new SpotifyAuthenticationException(stringBuilder.toString());
            }
            if (responseBody != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                AuthResponseDTO authResponseDTO = objectMapper.readValue(responseBody.string(), AuthResponseDTO.class);
                this.accessToken = authResponseDTO.getAccess_token();
                this.tokenType = authResponseDTO.getToken_type();
                this.httpClient = this.buildHttpClient();
            }
        } catch (SpotifyAuthenticationException spauthEx) {
            throw spauthEx;
        } catch (Exception ex) {
            throw new SpotifyApiConnectionException(ex);
        }
    }

    /**
     * @param isrc
     * @return String with json response
     * @throws SpotifyAuthenticationException
     * @throws SpotifyApiConnectionException
     */
    public String findTrackByIsrc(String isrc) throws SpotifyApiConnectionException {
        try {
            Request request = new Request.Builder()
                    .url(API_URL.concat("search?q=isrc:" + isrc + "&type=track"))
                    .method("GET", null)
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .build();
            Response resp = httpClient.newCall(request).execute();

            if (resp.code() == 401) {
                throw new SpotifyAuthenticationException("Token expired");
            }
            return resp.body().string();
        } catch (SpotifyAuthenticationException ex) {
            throw new SpotifyApiConnectionException(ex);
        } catch (Exception ex) {
            throw new SpotifyApiConnectionException(ex);
        }
    }


    private OkHttpClient buildHttpClient() throws SpotifyAuthenticationException {
        OkHttpClient client = new OkHttpClient();
        return client.newBuilder()
                .addInterceptor(chain -> {
                    Request requestInter = chain.request();
                    Request newRequest = requestInter.newBuilder()
                            .addHeader("Authorization", tokenType.concat(" ").concat(accessToken))
                            .build();
                    Response response = chain.proceed(newRequest);
                    if (response.code() == 400 || response.code() == 401) {
                        LOG.warn("Spotify token expired response, Authenticating again");
                        response.close();
                        try {

                            this.authenticate();
                            response = chain.proceed(
                                    requestInter.newBuilder()
                                            .addHeader("Authorization", tokenType.concat(" ").concat(accessToken))
                                            .build()
                            );
                        } catch (SpotifyAuthenticationException | SpotifyApiConnectionException ex){
                            LOG.error("Could not retry spotify authentication ", ex);
                        }
                    }
                    return response;
                }).build();
    }

}
