package com.umusic.trackfinder.rest;

import com.umusic.trackfinder.dto.ResponseDTO;
import com.umusic.trackfinder.dto.TrackDTO;
import com.umusic.trackfinder.exceptions.TrackAlreadyExistsException;
import com.umusic.trackfinder.exceptions.TrackIsrcNotExistException;
import com.umusic.trackfinder.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/codechallenge/tracks")
public class TrackController {

    private TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> tracksList() {
        ResponseDTO responseDTO = new ResponseDTO<List<TrackDTO>>().setStatus(HttpStatus.OK.value());
        try {
            List<TrackDTO> trackList = trackService.findAll();

            return ResponseEntity.status(HttpStatus.OK)
                    .body(responseDTO.setStatus(HttpStatus.OK.value())
                            .setData(trackList)
                    );
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .setMessage("Error trying to get tracks from database" + ex.getMessage()));
        }
    }
 @GetMapping(value = "/{isrc}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> getTrack(@PathVariable("isrc") String isrc) {
        ResponseDTO responseDTO = new ResponseDTO<List<TrackDTO>>().setStatus(HttpStatus.OK.value());

        try {
            List<TrackDTO> trackList = trackService.findTrackByIsrc(isrc);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(responseDTO.setStatus(HttpStatus.OK.value())
                            .setData(trackList)
                    );
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .setMessage("Error trying to find track " + isrc + ", " + ex.getMessage()));
        }
    }


    @PostMapping("/{isrc}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity createTrack(@PathVariable("isrc") String isrc) {
        ResponseDTO responseDTO = new ResponseDTO<TrackDTO>().setStatus(HttpStatus.OK.value());
        try {
            TrackDTO track = trackService.createTrackByIsrc(isrc);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(responseDTO.setData(track));
        } catch (TrackAlreadyExistsException trackExistsException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(responseDTO
                            .setStatus(HttpStatus.BAD_REQUEST.value())
                            .setMessage("Track ".concat(isrc).concat(" Already exists")));
        } catch (TrackIsrcNotExistException trackExistsException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(responseDTO
                            .setStatus(HttpStatus.NOT_FOUND.value())
                            .setMessage("Track ".concat(isrc).concat(" Does not exist")));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseDTO
                            .setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .setMessage("Internal error: ".concat(e.getMessage())));
        }

    }

}
