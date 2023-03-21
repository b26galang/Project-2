package com.revature.controller;

import com.revature.entity.Complaint;
import com.revature.service.complaint.ComplaintService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaints")
@CrossOrigin(origins = "http://localhost:3000")

public class ComplaintController {
    @Autowired
    ComplaintService complaintService;

    Logger logger1 = LoggerFactory.getLogger(ComplaintController.class);

    @PostMapping()
    public Complaint insert(@RequestBody Complaint complaint) {
        logger1.info("Inserting: {}", complaint);
        return complaintService.insert(complaint);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Complaint> getAll(@RequestParam(required = false, value = "flag") String flag) {

        List<Complaint> complaints;

        if (flag == null) {
            complaints = complaintService.getAll();
            logger1.info("Retrieved all complaints: {}", complaints.size());
            for (Complaint complaint : complaints) {
                logger1.info("Complaints: {}", complaint);
            }
        } else {
            complaints = complaintService.getAll(flag);
            logger1.info("Retrieved complaints with flag {}: {}", flag, complaints.size());
            for (Complaint complaint : complaints) {
                logger1.info("Complaints: {}", complaint);
            }
        }

        return complaints;
    }

    @GetMapping("/{id}")
    public Complaint getById(@PathVariable("id") Long id) {
        logger1.info("Getting complaint by ID: {}", id);
        return complaintService.getById(id);
    }

    @PutMapping("/{id}")
    public Complaint update(@RequestBody Complaint complaint) {
        logger1.info("Updating complaint by id to: {}", complaint);
        return complaintService.update(complaint);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        logger1.info("Deleting the complaint with id {}", id);
        return complaintService.delete(id);
    }
}
