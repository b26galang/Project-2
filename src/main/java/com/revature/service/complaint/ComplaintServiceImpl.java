package com.revature.service.complaint;

import com.revature.entity.Complaint;
import com.revature.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary

public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    ComplaintRepository complaintRepository;

    @Override
    public Complaint getById(Long id) {
        return complaintRepository.findById(id).get();
    }

    @Override
    public List<Complaint> getAll() {
        return complaintRepository.findAll();
    }

    @Override
    public List<Complaint> getAll(String flag) {
        switch(flag) {
            case "UNREVIEWED":
                return complaintRepository.findUnreviewed();
            case "ADDRESSED":
                return complaintRepository.findAddressed();
            case "HIGH PRIORITY":
                return complaintRepository.findHighPriority();
            case "LOW PRIORITY":
                return complaintRepository.findLowPriority();
            case "IGNORED":
                return complaintRepository.findIgnored();
            default:
                return complaintRepository.findAll();
        }
    }

    @Override
    public Complaint insert(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public Complaint update(Complaint complaint) {
        return complaintRepository.save(complaint);
    }
}
