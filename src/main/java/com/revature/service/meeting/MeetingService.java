package com.revature.service.meeting;

import com.revature.entity.Meeting;

import java.util.List;

public interface MeetingService {
    Meeting insert(Meeting meeting);
    Meeting update(Meeting meeting);
    Meeting getById(Long id);
    List<Meeting> getAll();
    boolean delete(Long id);
}
