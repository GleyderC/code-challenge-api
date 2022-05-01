package com.umusic.trackfinder.dto.spotify;

import java.util.Map;


public class ArtistSpotifyDTO {

    private Map<String, String> external_urls;
    private String href;
    private String id;
    private String name;
    private String type;
    private String uri;


    public Map<String, String> getExternal_urls() {
        return external_urls;
    }

    public ArtistSpotifyDTO setExternal_urls(Map<String, String> external_urls) {
        this.external_urls = external_urls;
        return this;
    }

    public String getHref() {
        return href;
    }

    public ArtistSpotifyDTO setHref(String href) {
        this.href = href;
        return this;
    }

    public String getId() {
        return id;
    }

    public ArtistSpotifyDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ArtistSpotifyDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public ArtistSpotifyDTO setType(String type) {
        this.type = type;
        return this;
    }

    public String getUri() {
        return uri;
    }

    public ArtistSpotifyDTO setUri(String uri) {
        this.uri = uri;
        return this;
    }
}
