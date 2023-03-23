package com.revature.controller;


import com.revature.entity.Meeting;
import com.revature.exceptions.IdDoesNotExistException;
import com.revature.service.meeting.MeetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/meetings")
@CrossOrigin(origins = "*")


public class MeetingController {
    @Autowired
    MeetingService meetingService;

    Logger logger1 = LoggerFactory.getLogger(MeetingController.class);

    @PostMapping()
    public ResponseEntity<Meeting> insert(@RequestBody Meeting meeting) {
        logger1.info("Inserting: {}", meeting);
        return new ResponseEntity<>(meetingService.insert(meeting), HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity <List<Meeting>> getAll(){
        List<Meeting> meetings;
        meetings = meetingService.getAll();
        logger1.info("Getting all meetings: {}", meetings.size());
        for (Meeting meeting: meetings) {
            logger1.info("Meetings: {}", meeting);
        }
        return new ResponseEntity<>(meetingService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Meeting> getById(@PathVariable("id")Long id) throws IdDoesNotExistException {
        logger1.info("Getting meeting by ID: {}", id);
        return new ResponseEntity<>(meetingService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity <Meeting> update(@RequestBody Meeting meeting) throws IdDoesNotExistException {
        logger1.info("Updating a meeting by ID: {}", meeting);
        return new ResponseEntity<>(meetingService.update(meeting), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Boolean> delete(@PathVariable("id") Long id) throws IdDoesNotExistException{
        logger1.info("Deleting the meeting with id: {}", id);
        return new ResponseEntity<>(meetingService.delete(id), HttpStatus.OK);
    }
}
