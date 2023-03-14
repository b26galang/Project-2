package com.revature.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "meeting_table")

public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(name = "meeting_address")
    private String address;

    @Column(name = "meeting_time")
    private int time;

    @Column(name="meeting_summary")
    private String summary;
}
