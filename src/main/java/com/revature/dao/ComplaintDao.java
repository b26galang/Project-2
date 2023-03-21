package com.revature.dao;

import com.revature.entity.Complaint;

import java.util.List;

public interface ComplaintDao {
    List<Complaint> findAddressed();
    List<Complaint> findUnreviewed();
    List<Complaint> findHighPriority();
    List<Complaint> findLowPriority();
    List<Complaint> findIgnored();
}
