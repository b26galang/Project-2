package com.revature.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "meetings")

public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long meetingId;

    @Column(name = "address")
    private String address;

    @Column(name = "time")
    private int time;

    @Column(name="summary")
    private String summary;

    public Meeting(String address, int time, String summary) {
        this.address = address;
        this.time = time;
        this.summary = summary;
    }
}
