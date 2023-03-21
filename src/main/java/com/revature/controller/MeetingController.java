package com.revature.controller;


import com.revature.entity.Meeting;
import com.revature.service.meeting.MeetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/meetings")
@CrossOrigin(origins = "http://localhost:3000")


public class MeetingController {
    @Autowired
    MeetingService meetingService;

    Logger logger1 = LoggerFactory.getLogger(MeetingController.class);

    @PostMapping()
    public Meeting insert(@RequestBody Meeting meeting) {
        logger1.info("Inserting: {}", meeting);
        return meetingService.insert(meeting);
    }


    @GetMapping
    public List<Meeting> getAll(){
        List<Meeting> meetings;
        meetings = meetingService.getAll();
        logger1.info("Getting all meetings: {}", meetings.size());
        for (Meeting meeting: meetings) {
            logger1.info("Meetings: {}", meeting);
        }
        return meetingService.getAll();
    }

    @GetMapping("/{id}")
    public Meeting getById(@PathVariable("id")Long id) {
        logger1.info("Getting meeting by ID: {}", id);
        return meetingService.getById(id);
    }

    @PutMapping("/{id}")
    public Meeting update(@RequestBody Meeting meeting) {
        logger1.info("Updating a meeting by ID: {}", meeting);
        return meetingService.update(meeting);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        logger1.info("Deleting the meeting with id: {}", id);
        return meetingService.delete(id);
    }
}
