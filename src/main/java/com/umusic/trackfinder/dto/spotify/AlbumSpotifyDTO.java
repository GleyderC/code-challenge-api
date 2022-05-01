package com.umusic.trackfinder.dto.spotify;

import java.util.List;
import java.util.Map;


public class AlbumSpotifyDTO {

    private Map<String, String> external_urls;
    private List<Map<String, String>> images;
    private List<String> available_markets;
    private String href;
    private String id;
    private String name;
    private String type;
    private String album_type;
    private String uri;
    private String release_date;
    private String release_date_precision;
    private Integer total_tracks;
    private List<ArtistSpotifyDTO> artists;

    public List<ArtistSpotifyDTO> getArtists() {
        return artists;
    }

    public String getAlbum_type() {
        return album_type;
    }

    public AlbumSpotifyDTO setAlbum_type(String album_type) {
        this.album_type = album_type;
        return this;
    }

    public AlbumSpotifyDTO setArtists(List<ArtistSpotifyDTO> artists) {
        this.artists = artists;
        return this;
    }

    public List<String> getAvailable_markets() {
        return available_markets;
    }

    public AlbumSpotifyDTO setAvailable_markets(List<String> available_markets) {
        this.available_markets = available_markets;
        return this;
    }

    public Map<String, String> getExternal_urls() {
        return external_urls;
    }

    public AlbumSpotifyDTO setExternal_urls(Map<String, String> external_urls) {
        this.external_urls = external_urls;
        return this;
    }

    public List<Map<String, String>> getImages() {
        return images;
    }

    public AlbumSpotifyDTO setImages(List<Map<String, String>> images) {
        this.images = images;
        return this;
    }

    public String getHref() {
        return href;
    }

    public AlbumSpotifyDTO setHref(String href) {
        this.href = href;
        return this;
    }

    public String getId() {
        return id;
    }

    public AlbumSpotifyDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AlbumSpotifyDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public AlbumSpotifyDTO setType(String type) {
        this.type = type;
        return this;
    }

    public String getUri() {
        return uri;
    }

    public AlbumSpotifyDTO setUri(String uri) {
        this.uri = uri;
        return this;
    }

    public String getRelease_date() {
        return release_date;
    }

    public AlbumSpotifyDTO setRelease_date(String release_date) {
        this.release_date = release_date;
        return this;
    }

    public String getRelease_date_precision() {
        return release_date_precision;
    }

    public AlbumSpotifyDTO setRelease_date_precision(String release_date_precision) {
        this.release_date_precision = release_date_precision;
        return this;
    }

    public Integer getTotal_tracks() {
        return total_tracks;
    }

    public AlbumSpotifyDTO setTotal_tracks(Integer total_tracks) {
        this.total_tracks = total_tracks;
        return this;
    }
}

