package com.umusic.trackfinder.dto.spotify;

import java.util.List;
import java.util.Map;


public class TrackSpotifyDTO {

    private List<ArtistSpotifyDTO> artists;
    private List<String> available_markets;
    private Map<String, String> external_urls;
    private Map<String, String> external_ids;
    private Integer disc_number;
    private Integer duration_ms;
    private Boolean explicit;
    private String href;
    private String id;
    private String is_local;
    private String name;
    private Integer popularity;
    private String preview_url;
    private Integer track_number;
    private String type;
    private String uri;
    private AlbumSpotifyDTO  album;

    public AlbumSpotifyDTO getAlbum() {
        return album;
    }

    public TrackSpotifyDTO setAlbum(AlbumSpotifyDTO album) {
        this.album = album;
        return this;
    }

    public List<ArtistSpotifyDTO> getArtists() {
        return artists;
    }

    public TrackSpotifyDTO setArtists(List<ArtistSpotifyDTO> artists) {
        this.artists = artists;
        return this;
    }

    public Map<String, String> getExternal_urls() {
        return external_urls;
    }

    public TrackSpotifyDTO setExternal_urls(Map<String, String> external_urls) {
        this.external_urls = external_urls;
        return this;
    }

    public Map<String, String> getExternal_ids() {
        return external_ids;
    }

    public TrackSpotifyDTO setExternal_ids(Map<String, String> external_ids) {
        this.external_ids = external_ids;
        return this;
    }

    public Integer getDisc_number() {
        return disc_number;
    }

    public TrackSpotifyDTO setDisc_number(Integer disc_number) {
        this.disc_number = disc_number;
        return this;
    }

    public Integer getDuration_ms() {
        return duration_ms;
    }

    public TrackSpotifyDTO setDuration_ms(Integer duration_ms) {
        this.duration_ms = duration_ms;
        return this;
    }

    public Boolean getExplicit() {
        return explicit;
    }

    public TrackSpotifyDTO setExplicit(Boolean explicit) {
        this.explicit = explicit;
        return this;
    }

    public String getHref() {
        return href;
    }

    public TrackSpotifyDTO setHref(String href) {
        this.href = href;
        return this;
    }

    public String getId() {
        return id;
    }

    public TrackSpotifyDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getIs_local() {
        return is_local;
    }

    public TrackSpotifyDTO setIs_local(String is_local) {
        this.is_local = is_local;
        return this;
    }

    public String getName() {
        return name;
    }

    public TrackSpotifyDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public TrackSpotifyDTO setPopularity(Integer popularity) {
        this.popularity = popularity;
        return this;
    }

    public String getPreview_url() {
        return preview_url;
    }

    public TrackSpotifyDTO setPreview_url(String preview_url) {
        this.preview_url = preview_url;
        return this;
    }

    public Integer getTrack_number() {
        return track_number;
    }

    public TrackSpotifyDTO setTrack_number(Integer track_number) {
        this.track_number = track_number;
        return this;
    }

    public String getType() {
        return type;
    }

    public TrackSpotifyDTO setType(String type) {
        this.type = type;
        return this;
    }

    public String getUri() {
        return uri;
    }

    public TrackSpotifyDTO setUri(String uri) {
        this.uri = uri;
        return this;
    }

    public List<String> getAvailable_markets() {
        return available_markets;
    }

    public TrackSpotifyDTO setAvailable_markets(List<String> available_markets) {
        this.available_markets = available_markets;
        return this;
    }
}
