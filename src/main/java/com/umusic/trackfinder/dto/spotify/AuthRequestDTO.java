package com.umusic.trackfinder.dto.spotify;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthRequestDTO {

    @JsonProperty("grant_type")
    private String grant_type;

    public String getGrant_type() {
        return grant_type;
    }

    public AuthRequestDTO setGrant_type(String grant_type) {
        this.grant_type = grant_type;
        return this;
    }
}
