package com.revature.controller;


import com.revature.entity.Meeting;
import com.revature.service.meeting.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


//@RestController
//@RequestMapping("/meetings")
//@CrossOrigin(origins = "http://localhost:3000")


public class MeetingController {
//    @Autowired
//    MeetingService meetingService;
//
//
//    // we do a post mapping for inserting new data
//    @PostMapping()
//    public Meeting insert(@RequestBody Meeting meeting) {
//        return meetingService.insert(meeting);
//    }
//
//
//    // configuring this method to run when we send a get request to the end point /meetings
//    // http://localhost:8080/meetings => [list of meetings]
//    @RequestMapping(method = RequestMethod.GET)
//    public List<Meeting> getAll(){
//        return meetingService.getAll();
//    }
//
//
//    @GetMapping("/{id")
//    public Meeting getById(@PathVariable("id")Long id) {
//        return meetingService.getById(id);
//    }
//
//
//    @PutMapping()
//    public Meeting update(@RequestBody Meeting meeting) {
//        return meetingService.update(meeting);
//    }
//
//
//    @DeleteMapping("/{id}")
//    public boolean delete(@PathVariable("id") Long id) {
//        return meetingService.delete(id);
//    }
}
