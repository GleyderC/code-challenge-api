package com.umusic.trackfinder.domain;


import com.umusic.trackfinder.dto.TrackDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Track {

    public Track() {
    }

    @Id
    @Column(name = "ISRC")
    private String isrc;

    @Column
    private String name;
    @Column
    private Integer duration_ms;
    @Column
    private Boolean explicit;

    public String getIsrc() {
        return isrc;
    }

    public Integer getDuration_ms() {
        return duration_ms;
    }

    public Track setDuration_ms(Integer duration_ms) {
        this.duration_ms = duration_ms;
        return this;
    }

    public Boolean getExplicit() {
        return explicit;
    }

    public Track setExplicit(Boolean explicit) {
        this.explicit = explicit;
        return this;
    }

    public Track setIsrc(String isrc) {
        this.isrc = isrc;
        return this;
    }

    public String getName() {
        return name;
    }

    public Track setName(String name) {
        this.name = name;
        return this;
    }

    public Track(TrackDTO trackDTO) {
        this.isrc =  trackDTO.getIsrc();
        this.name =  trackDTO.getName();
        this.duration_ms =  trackDTO.getDuration_ms();
        this.explicit =  trackDTO.getExplicit();
    }
}
