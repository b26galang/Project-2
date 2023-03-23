package com.revature.controller;

import com.revature.entity.Complaint;
import com.revature.exceptions.IdDoesNotExistException;
import com.revature.service.complaint.ComplaintService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity <Complaint> insert(@RequestBody Complaint complaint) {
        logger1.info("Inserting: {}", complaint);
        return new ResponseEntity<>(complaintService.insert(complaint), HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity <List<Complaint>> getAll(@RequestParam(required = false, value = "flag") String flag) {

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
        return new ResponseEntity<>(complaints, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Complaint> getById(@PathVariable("id") Long id) throws IdDoesNotExistException {
        logger1.info("Getting complaint by ID: {}", id);
        return new ResponseEntity<>(complaintService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity <Complaint> update(@RequestBody Complaint complaint) throws IdDoesNotExistException {
        logger1.info("Updating complaint by id to: {}", complaint);
        return new ResponseEntity<>(complaintService.update(complaint), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Boolean> delete(@PathVariable("id") Long id) throws IdDoesNotExistException {
        logger1.info("Deleting the complaint with id {}", id);
        return new ResponseEntity<>(complaintService.delete(id), HttpStatus.OK);
    }
}
