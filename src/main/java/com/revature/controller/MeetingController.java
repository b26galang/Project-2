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

    // We use the Logger Factory to get a Logger for a particular class
    Logger logger1 = LoggerFactory.getLogger(MeetingController.class);

    // we do a post mapping for inserting new data
    @PostMapping()
    public Meeting insert(@RequestBody Meeting meeting) {
        logger1.info("Inserting: " + meeting.toString());
        return meetingService.insert(meeting);
    }


    // configuring this method to run when we send a get request to the end point /meetings
    // http://localhost:8080/meetings => [list of meetings]
    @RequestMapping(method = RequestMethod.GET)
    public List<Meeting> getAll(){
        logger1.info("Getting all meetings: " + meetingService.getAll().toString());
        return meetingService.getAll();
    }

    // Get a meeting by ID
    @GetMapping("/{id")
    public Meeting getById(@PathVariable("id")Long id) {
        logger1.info("Getting meeting by ID: " + id);
        return meetingService.getById(id);
    }

    // Update/replace a complaint
    @PutMapping("/{id}")
    public Meeting update(@RequestBody Meeting meeting) {
        logger1.info("Updating a meeting by id to: " + meeting.toString());
        return meetingService.update(meeting);
    }

    // Delete a meeting
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        logger1.info("Deleting the meeting with id" + id + " : " + meetingService.delete(id));
        return meetingService.delete(id);
    }
}
