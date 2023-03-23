package com.revature.service.meeting;

import com.revature.entity.Meeting;
import com.revature.exceptions.IdDoesNotExistException;

import java.util.List;

public interface MeetingService {
    Meeting insert(Meeting meeting);
    Meeting update(Meeting meeting) throws IdDoesNotExistException;
    Meeting getById(Long id) throws IdDoesNotExistException;
    List<Meeting> getAll();
    boolean delete(Long id) throws IdDoesNotExistException;
}
