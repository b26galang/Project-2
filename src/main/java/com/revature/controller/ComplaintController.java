package com.revature.controller;

import com.revature.entity.Complaint;
import com.revature.service.complaint.ComplaintService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// every single method in this class should be prefixed with /pets
@RequestMapping("/complaints")
@CrossOrigin(origins = "http://localhost:3000")

public class ComplaintController {
    @Autowired
    ComplaintService complaintService;

    // We use the Logger Factory to get a Logger for a particular class
    Logger logger1 = LoggerFactory.getLogger(ComplaintController.class);

    // we do a post mapping for inserting new data
    @PostMapping()
    public Complaint insert(@RequestBody Complaint complaint) {
        logger1.info("Inserting: " + complaint.toString());
        return complaintService.insert(complaint);
    }

    // configuring this method to run when we send a get request to the end point /complaints
    // http://localhost:8081/characters => [list of complaints]
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Complaint> getAll(@RequestParam(required = false, value = "flag") String flag) {

        if (flag == null) {
            logger1.info("Getting all complaints: " + complaintService.getAll().toString());
            return complaintService.getAll();

        } else {
            logger1.info("Getting all complaints by the status " + flag + ": " + complaintService.getAll(flag).toString());
            return complaintService.getAll(flag);
        }
    }

    // Get a complaint by ID
    @GetMapping("/{id}")
    public Complaint getById(@PathVariable("id") Long id) {
        logger1.info("Getting complaint by ID: " + id);
        return complaintService.getById(id);
    }

    @PutMapping("/{id}")
    public Complaint update(@RequestBody Complaint complaint) {
        logger1.info("Updating complaint by id to: " + complaint.toString());
        return complaintService.update(complaint);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        logger1.info("Deleting the complaint with id " + id + " : " + complaintService.delete(id));
        return complaintService.delete(id);
    }
}
