package com.revature.service.complaint;

import com.revature.entity.Complaint;

import java.util.List;

public interface ComplaintService {

    Complaint getById(Long id);
    List<Complaint> getAll();
    List<Complaint>getAll(String flag);
    Complaint insert(Complaint complaint);
    Complaint update(Complaint complaint);
}
