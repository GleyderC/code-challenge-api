package com.umusic.trackfinder.dto;

import com.umusic.trackfinder.domain.Track;
import com.umusic.trackfinder.dto.spotify.TrackSpotifyDTO;

public class TrackDTO {

    private String isrc;
    private String name;

    private Integer duration_ms;

    private Boolean explicit;

    public TrackDTO(String isrc, String name) {
        this.isrc = isrc;
        this.name = name;
    }

    public Integer getDuration_ms() {
        return duration_ms;
    }

    public TrackDTO setDuration_ms(Integer duration_ms) {
        this.duration_ms = duration_ms;
        return this;
    }

    public Boolean getExplicit() {
        return explicit;
    }

    public TrackDTO setExplicit(Boolean explicit) {
        this.explicit = explicit;
        return this;
    }

    public TrackDTO(Track track) {
        this.isrc = track.getIsrc();
        this.name = track.getName();
        this.duration_ms = track.getDuration_ms();
        this.explicit = track.getExplicit();
    }
    public TrackDTO(TrackSpotifyDTO track) {
        this.isrc = track.getExternal_ids().get("isrc");
        this.name = track.getName();
        this.duration_ms = track.getDuration_ms();
        this.explicit = track.getExplicit();
    }

    public String getIsrc() {
        return isrc;
    }

    public TrackDTO setIsrc(String isrc) {
        this.isrc = isrc;
        return this;
    }

    public String getName() {
        return name;
    }

    public TrackDTO setName(String name) {
        this.name = name;
        return this;
    }


}
