package com.umusic.trackfinder.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.umusic.trackfinder.domain.Track;
import com.umusic.trackfinder.dto.TrackDTO;
import com.umusic.trackfinder.dto.spotify.TrackSpotifyDTO;
import com.umusic.trackfinder.exceptions.SpotifyApiConnectionException;
import com.umusic.trackfinder.exceptions.SpotifyFormatResponseException;
import com.umusic.trackfinder.exceptions.TrackAlreadyExistsException;
import com.umusic.trackfinder.exceptions.TrackIsrcNotExistException;
import com.umusic.trackfinder.repository.TrackRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrackService {
    private static final Logger LOG = LoggerFactory.getLogger(TrackService.class);

    private TrackRepository trackRepository;
    private SpotifyConnector spotifyConnector;

    @Autowired
    public TrackService(TrackRepository trackRepository, SpotifyConnector connector) {
        this.trackRepository = trackRepository;
        this.spotifyConnector = connector;
    }

    public TrackDTO createTrackByIsrc(String isrc) throws TrackAlreadyExistsException, TrackIsrcNotExistException, Exception {
        try {
            List<Track> trackList = trackRepository.findByIsrc(isrc);
            if (trackList.size() > 0) {
                throw new TrackAlreadyExistsException();
            }
            String jsonStrResponse = spotifyConnector.findTrackByIsrc(isrc);
            List<TrackSpotifyDTO> spotifyDTOList = convertSpotifyResponseToDTO(jsonStrResponse);
            List<TrackDTO> trackDTOS = spotifyDTOList.stream().map(TrackDTO::new).collect(Collectors.toList());
            if (trackDTOS.size() > 0) {
                Track track = new Track(trackDTOS.get(0));
                trackRepository.save(track);
                return trackDTOS.get(0);
            } else {
                throw new TrackIsrcNotExistException();
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    public List<TrackDTO> findAll() {
        List<Track> tracks = trackRepository.findAll();
        return tracks.stream().map(TrackDTO::new).collect(Collectors.toList());
    }

    public List<TrackDTO> findTrackByIsrc(String isrc) throws SpotifyFormatResponseException, SpotifyApiConnectionException {
        // Look for the track in DB
        List<TrackDTO> trackDTOS = new ArrayList<>();
        try {
            List<Track> trackList = trackRepository.findByIsrc(isrc);
            if (trackList.size() > 0) {
                trackDTOS = trackList.stream().map(TrackDTO::new).collect(Collectors.toList());
                return trackDTOS;
            }
            String jsonStrResponse = spotifyConnector.findTrackByIsrc(isrc);
            List<TrackSpotifyDTO> spotifyDTOList = convertSpotifyResponseToDTO(jsonStrResponse);
            trackDTOS = spotifyDTOList.stream().map(TrackDTO::new).collect(Collectors.toList());
            if (trackDTOS.size() > 0) {
                Track track = new Track(trackDTOS.get(0));
                trackRepository.save(track);
            }
            return trackDTOS;
        } catch (SpotifyApiConnectionException e) {
            LOG.error("Error connecting with spotify api", e);
            throw e;
        } catch (SpotifyFormatResponseException e) {
            throw e;
        }
    }

    private List<TrackSpotifyDTO> convertSpotifyResponseToDTO(String jsonString) throws SpotifyFormatResponseException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray items = jsonObject.getJSONObject("tracks").getJSONArray("items");
            TypeReference<List<TrackSpotifyDTO>> typeRef = new TypeReference<>() {
            };
            return objectMapper.readValue(items.toString(), typeRef);
        } catch (JsonProcessingException e) {
            LOG.error("Error reading and formatting response schema from spotify", e);
            throw new SpotifyFormatResponseException("Error reading and formatting response schema from spotify", e);
        }
    }


}
