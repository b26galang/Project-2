package com.revature.service.complaint;

import com.revature.entity.Complaint;
import com.revature.exceptions.IdDoesNotExistException;

import java.util.List;

public interface ComplaintService {

    Complaint getById(Long id) throws IdDoesNotExistException;
    List<Complaint> getAll();
    List<Complaint>getAll(String flag);
    Complaint insert(Complaint complaint);
    Complaint update(Complaint complaint) throws IdDoesNotExistException;
    boolean delete(Long id) throws IdDoesNotExistException;
}
