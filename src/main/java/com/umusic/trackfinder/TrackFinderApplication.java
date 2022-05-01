package com.umusic.trackfinder;

import com.umusic.trackfinder.exceptions.SpotifyAuthenticationException;
import com.umusic.trackfinder.exceptions.SpotifyApiConnectionException;
import com.umusic.trackfinder.service.SpotifyConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class TrackFinderApplication {

    private static final Logger LOG = LoggerFactory.getLogger(TrackFinderApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TrackFinderApplication.class, args);
    }


    @Value("${spotify.auth.client_id}")
    private String clientId;
    @Value("${spotify.auth.client_secret}")
    private String clientSecret;
    @Bean
    public SpotifyConnector spotifyConnectorBean() {
        SpotifyConnector connector = new SpotifyConnector(clientId, clientSecret);
        try {
            connector.authenticate();
            return connector;
        } catch (SpotifyAuthenticationException ex) {
            LOG.error("error Trying to authenticate with spotify api", ex);

        } catch (SpotifyApiConnectionException ex) {
            LOG.error("error Trying to connect with spotify api", ex);
        }
        return connector;
    }


}
