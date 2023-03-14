package com.revature.data.complaint;

import com.revature.entity.Complaint;

import java.util.List;

public interface ComplaintDao {
    Complaint insert(Complaint complaint);
    Complaint getById(Long id);
    List<Complaint> getAll();
    Complaint update(Complaint complaint);

}
