package com.revature.service.meeting;

import com.revature.entity.Meeting;
import com.revature.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary

public class MeetingServiceImpl implements MeetingService {

    @Autowired
    MeetingRepository meetingRepository;
    @Override
    public Meeting insert(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @Override
    public Meeting update(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @Override
    public Meeting getById(Long id) {
        return meetingRepository.findById(id).get();
    }

    @Override
    public List<Meeting> getAll() {
        return meetingRepository.findAll();
    }

    @Override
    public boolean delete(Long id) {
        boolean found = meetingRepository.existsById(id);
        if (found) meetingRepository.deleteById(id);
        return found;
    }
}
