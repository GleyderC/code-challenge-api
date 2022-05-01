package com.umusic.trackfinder.repository;


import com.umusic.trackfinder.domain.Track;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends CrudRepository<Track, String> {

    List<Track> findByIsrc(String isrc);
    List<Track> findAll();
}
