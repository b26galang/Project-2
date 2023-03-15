package com.revature.service;

import com.revature.entity.Meeting;
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

    // mock the meeting repository bean:
    @MockBean(MeetingRepository.class)
    private MeetingRepository meetingRepository;

    // Autowire the MeetingService
    @Autowired
    MeetingService meetingService;

    @Test
    public void testInsert() {
        Meeting meeting = new Meeting("MEETING ADDRESS", 1268611200, "NOT A REAL MEETING");
        Meeting newMeeting = new Meeting(1l,"MEETING ADDRESS", 1268611200, "NOT A REAL MEETING");

        // mock the save method of the repository, so repository doesn't actually access the database
        Mockito.when(meetingRepository.save(meeting)).thenReturn(newMeeting);

        // ensure that the service returns the new meeting
        Assertions.assertEquals(newMeeting, meetingService.insert(meeting));
    }

    @Test
    public void testUpdate() {
        Meeting meeting = new Meeting("MEETING ADDRESS", 1268611200, "NOT A REAL MEETING");
        Meeting updatedMeeting = new Meeting(1l,"NOT A REAL ADDRESS", 1269522200, "A REAL MEETING");

        // mock the save method of the repository, so the repository doesn't actually access the database
        Mockito.when(meetingRepository.save(meeting)).thenReturn(updatedMeeting);

        // ensure that the service returns the updated meeting
        Assertions.assertEquals(updatedMeeting, meetingService.update(meeting));
    }

    @Test
    public void testDelete() {
        Meeting meeting = new Meeting(1l,"NOT A REAL ADDRESS", 1269522200, "A REAL MEETING");

        // mock the existsById method of the repository, so the repository doesn't actually access the database
        Mockito.when(meetingRepository.existsById(1l)).thenReturn(true);
        Mockito.when(meetingRepository.existsById(2l)).thenReturn(false);

        Assertions.assertTrue(meetingService.delete(1l));
        Assertions.assertFalse(meetingService.delete(2l));
    }

    @Test
    public void testGetById() {
        Meeting expectedMeeting = new Meeting(1l,"NOT A REAL ADDRESS", 1269522200, "A REAL MEETING");

        // mock the findById method of the repository, so the repository doesn't actually access the database
        Mockito.when(meetingRepository.findById(1l)).thenReturn(Optional.of(expectedMeeting));

        // ensure that the service returns the meeting of the correct id
        Assertions.assertEquals(expectedMeeting, meetingService.getById(1l));
    }

    @Test
    public void testGetAll() {
        List<Meeting> expectedMeetings = new ArrayList<>();
        expectedMeetings.add(new Meeting(1l,"ADDRESS", 1269522200, "MEETING"));
        expectedMeetings.add(new Meeting(2l,"ANOTHER ADDRESS", 1269523300, "ANOTHER MEETING"));
        expectedMeetings.add(new Meeting(3l,"NOT A REAL ADDRESS", 1269524400, "A REAL MEETING"));

        // mock the findAll method of the repository, so that the repository doesn't actually access the database
        Mockito.when(meetingRepository.findAll()).thenReturn(expectedMeetings);

        // ensure that the service returns the list of meetings
        Assertions.assertEquals(expectedMeetings, meetingService.getAll());
    }
}
