package com.revature.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "complaint_table")

public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "complaint_description")
    private String description;

    @Column(name = "complaint_status")
    private String status = "UNREVIEWED";

    @Column(name = "meeting_id")
    private int meetingId;

    public Complaint (String description) {
        this.description = description;
    }
}
