package com.revature.service;

import com.revature.entity.Meeting;
import com.revature.exceptions.IdDoesNotExistException;
import com.revature.repository.MeetingRepository;
import com.revature.service.meeting.MeetingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class MeetingServiceTest {

    @MockBean(MeetingRepository.class)
    MeetingRepository meetingRepository;

    @Autowired
    MeetingService meetingService;

    @Test
    public void testInsert() {
        Meeting meeting = new Meeting("MEETING ADDRESS", 1268611200, "NOT A REAL MEETING");
        Meeting newMeeting = new Meeting(1l,"MEETING ADDRESS", 1268611200, "NOT A REAL MEETING");
        Mockito.when(meetingRepository.save(meeting)).thenReturn(newMeeting);
        Assertions.assertEquals(newMeeting, meetingService.insert(meeting));
    }

    @Test
    public void testUpdate() throws IdDoesNotExistException {
        Meeting meeting = new Meeting("MEETING ADDRESS", 1268611200, "NOT A REAL MEETING");
        Meeting updatedMeeting = new Meeting(1l,"NOT A REAL ADDRESS", 1269522200, "A REAL MEETING");
        Mockito.when(meetingRepository.save(meeting)).thenReturn(updatedMeeting);
        Assertions.assertEquals(updatedMeeting, meetingService.update(meeting));
    }

    @Test
    public void testDelete() throws IdDoesNotExistException {
        Meeting meeting = new Meeting(1l,"NOT A REAL ADDRESS", 1269522200, "A REAL MEETING");
        Mockito.when(meetingRepository.existsById(1l)).thenReturn(true);
        Mockito.when(meetingRepository.existsById(2l)).thenReturn(false);
        Assertions.assertTrue(meetingService.delete(1l));
        Assertions.assertFalse(meetingService.delete(2l));
    }

    @Test
    public void testGetById() throws IdDoesNotExistException {
        Meeting expectedMeeting = new Meeting(1l,"NOT A REAL ADDRESS", 1269522200, "A REAL MEETING");
        Mockito.when(meetingRepository.findById(1l)).thenReturn(Optional.of(expectedMeeting));
        Assertions.assertEquals(expectedMeeting, meetingService.getById(1l));
    }

    @Test
    public void testGetAll() {
        List<Meeting> expectedMeetings = new ArrayList<>();
        expectedMeetings.add(new Meeting(1l,"ADDRESS", 1269522200, "MEETING"));
        expectedMeetings.add(new Meeting(2l,"ANOTHER ADDRESS", 1269523300, "ANOTHER MEETING"));
        expectedMeetings.add(new Meeting(3l,"NOT A REAL ADDRESS", 1269524400, "A REAL MEETING"));
        Mockito.when(meetingRepository.findAll()).thenReturn(expectedMeetings);
        Assertions.assertEquals(expectedMeetings, meetingService.getAll());
    }
}
