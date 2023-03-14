package com.revature.controller;

import com.revature.entity.Complaint;
import com.revature.service.complaint.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// every single method in this class should be prefixed with /pets
@RequestMapping("/complaints")
@CrossOrigin(origins = "http://localhost:3000")

//Logger logger 1 = LoggerFactory.getLogger(ComplaintController.class;

public class ComplaintController {
    @Autowired
    ComplaintService complaintService;
//    @PostMapping()
//    public Complaint(insert@RequestBodyComplaint complaint) {
//        // initialize Logger
//        Logger logger1 = LoggerFactory.getLogger(ComplaintController.class);
//        logger1.info("Inserting; " + complaint.toString());
//    }

    // we do a post mapping for inserting new data
    @PostMapping()
    public Complaint insert(@RequestBody Complaint complaint) {
        return complaintService.insert(complaint);
    }

    // configuring this method to run when we send a get request to the end point /complaints
    // http://localhost:8081/characters => [list of complaints]
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Complaint> getAll(@RequestParam(required = false, value = "flag") String flag) {
        // if we don't pass in a request parameter flag, we should just get all complaints
        if (flag == null) return complaintService.getAll();
            // Otherwise, call the overloaded method:
        else return complaintService.getAll(flag);
    }

    // Get a complaint by ID
    @GetMapping("/{id}")
    public Complaint getById(@PathVariable("id") Long id) {
        return complaintService.getById(id);
    }

    @PutMapping("/{id}")
    public Complaint update(@RequestBody Complaint complaint) {
        return complaintService.update(complaint);
    }
}
