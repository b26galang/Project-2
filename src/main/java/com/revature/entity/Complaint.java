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
@Table(name = "complaints")

public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status = "UNREVIEWED";

    @Column(name = "meeting_id")
    private int meetingId;

    // constructor that unregistered constituent will use in the complaint form
    // because they will not need to assign an ID, status, or meeting ID
    public Complaint (String description) {
        this.description = description;
    }

}
