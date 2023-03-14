package com.revature.repository;

import com.revature.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    //For finding complaints by status

    @Query(value = "SELECT * FROM complaint_table WHERE complaint_status = 'ADDRESSED'", nativeQuery = true)
    List<Complaint> findAddressed();

    @Query(value = "SELECT * FROM complaint_table WHERE complaint_status = 'UNREVIEWED'", nativeQuery = true)
    List<Complaint> findUnreviewed();

    @Query(value = "SELECT * FROM complaint_table WHERE complaint_status = 'HIGH PRIORITY'", nativeQuery = true)
    List<Complaint> findHighPriority();

    @Query(value = "SELECT * FROM complaint_table WHERE complaint_status = 'LOW PRIORITY'", nativeQuery = true)
    List<Complaint> findLowPriority();

    @Query(value = "SELECT * FROM complaint_table WHERE complaint_status = 'IGNORED'", nativeQuery = true)
    List<Complaint> findIgnored();

}
