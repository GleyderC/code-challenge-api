package com.umusic.trackfinder.dto.spotify;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthResponseDTO {

    private String access_token;
    private String token_type;
    private Integer expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public AuthResponseDTO setAccess_token(String access_token) {
        this.access_token = access_token;
        return this;
    }

    public String getToken_type() {
        return token_type;
    }

    public AuthResponseDTO setToken_type(String token_type) {
        this.token_type = token_type;
        return this;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public AuthResponseDTO setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
        return this;
    }
}
