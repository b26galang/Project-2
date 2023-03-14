package com.revature.service;

import com.revature.entity.Complaint;
import com.revature.repository.ComplaintRepository;
import com.revature.service.complaint.ComplaintService;
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
public class ComplaintServiceTest {
    // mock the complaint repository bean:
    @MockBean(ComplaintRepository.class)
    private ComplaintRepository complaintRepository;

    // Autowire the ComplaintService:
    @Autowired
    ComplaintService complaintService;

    @Test
    public void testInsert(){
        Complaint complaint = new Complaint("potion stock is too little");
        Complaint newComplaint = new Complaint(1l, "potion stock is too little", "UNREVIEWED", -1);

        // mock the save method of the repository, so the repository doesn't actually access the database
        Mockito.when(complaintRepository.save(complaint)).thenReturn(newComplaint);

        // ensure that the service returns the new complaint
        Assertions.assertEquals(newComplaint, complaintService.insert(complaint));
    }

    @Test
    public void testUpdate() {
        Complaint complaint = new Complaint("potion stock is too little");
        Complaint updatedComplaint = new Complaint(1l, "potion stock is too little", "REVIEWED", -1);

        // mock the save method of the repository, so the repository doesn't actually access the database
        Mockito.when(complaintRepository.save(complaint)).thenReturn(updatedComplaint);

        // ensure that the service returns the new complaint
        Assertions.assertEquals(updatedComplaint, complaintService.update(complaint));
    }

    @Test
    public void testGetById() {
        Complaint expectedComplaint = new Complaint(1l, "potion stock is too little", "UNREVIEWED", -1);

        // mock the findById method of the repository, so the repository doesn't actually access the database
        Mockito.when(complaintRepository.findById(1l)).thenReturn(Optional.of(expectedComplaint));

        // ensure that a complaint with that id exists
        Assertions.assertNotNull(complaintService.getById(1l));

        // ensure that the service returns the complaint of the correct id
        Assertions.assertEquals(expectedComplaint, complaintService.getById(1l));
    }

    @Test
    public void testGetAll() {
        List<Complaint> expectedComplaints = new ArrayList<>();
        expectedComplaints.add(new Complaint(1l, "item stock for potions is not enough", "UNREVIEWED", -1));
        expectedComplaints.add(new Complaint(2l, "maximum purchases aren't high enough", "UNREVIEWED", -1));
        expectedComplaints.add(new Complaint(3l,"monsters keep stealing my keys", "UNREVIEWED", -1));

        // mock the findAll method of the repository, so that the repository doesn't actually access the database
        Mockito.when(complaintRepository.findAll()).thenReturn(expectedComplaints);

        // ensure that the service returns the list of complaints
        Assertions.assertEquals(expectedComplaints, complaintService.getAll());
    }

    @Test
    public void testGetAllAddressed() {
        List<Complaint> expectedComplaints = new ArrayList<>();
        expectedComplaints.add(new Complaint(1l, "item stock for potions is not enough", "UNREVIEWED", -1));
        expectedComplaints.add(new Complaint(2l, "maximum purchases aren't high enough", "UNREVIEWED", -1));
        expectedComplaints.add(new Complaint(3l,"monsters keep stealing my keys", "UNREVIEWED", -1));
        expectedComplaints.add(new Complaint(5l, "not enough events", "ADDRESSED", -1));
        expectedComplaints.add(new Complaint(6l,"stores close too early", "ADDRESSED", -1));

        // mock the findAddressed method of the repository, so that the repository doesn't actually access the database
        Mockito.when(complaintRepository.findAddressed()).thenReturn(expectedComplaints);

        // ensure that the service only returns the complaints of status "ADDRESSED":
        Assertions.assertEquals(expectedComplaints, complaintService.getAll("ADDRESSED"));
    }

    @Test
    public void testGetAllUnreviewed() {
        List<Complaint> expectedComplaints = new ArrayList<>();
        expectedComplaints.add(new Complaint(1l, "item stock for potions is not enough", "UNREVIEWED", -1));
        expectedComplaints.add(new Complaint(2l, "maximum purchases aren't high enough", "UNREVIEWED", -1));
        expectedComplaints.add(new Complaint(3l,"monsters keep stealing my keys", "UNREVIEWED", -1));
        expectedComplaints.add(new Complaint(5l, "not enough events", "ADDRESSED", -1));
        expectedComplaints.add(new Complaint(6l,"stores close too early", "ADDRESSED", -1));

        // mock the findUnreviewed method of the repository, so that the repository doesn't actually access the database
        Mockito.when(complaintRepository.findUnreviewed()).thenReturn(expectedComplaints);

        // ensure that the service only returns the complaints of status "UNREVIEWED":
        Assertions.assertEquals(expectedComplaints, complaintService.getAll("UNREVIEWED"));
    }

    @Test
    public void testGetAllHighPriority() {
        List<Complaint> expectedComplaints = new ArrayList<>();
        expectedComplaints.add(new Complaint(1l, "item stock for potions is not enough", "HIGH PRIORITY", -1));
        expectedComplaints.add(new Complaint(2l, "maximum purchases aren't high enough", "HIGH PRIORITY", -1));
        expectedComplaints.add(new Complaint(3l,"monsters keep stealing my keys", "HIGH PRIORITY", -1));
        expectedComplaints.add(new Complaint(5l, "not enough events", "ADDRESSED", -1));
        expectedComplaints.add(new Complaint(6l,"stores close too early", "ADDRESSED", -1));

        // mock the findHighPriority method of the repository, so that the repository doesn't actually access the database
        Mockito.when(complaintRepository.findHighPriority()).thenReturn(expectedComplaints);

        // ensure that the service only returns the complaints of status "HIGH PRIORITY":
        Assertions.assertEquals(expectedComplaints, complaintService.getAll("HIGH PRIORITY"));
    }

    @Test
    public void testGetAllLowPriority() {
        List<Complaint> expectedComplaints = new ArrayList<>();
        expectedComplaints.add(new Complaint(1l, "item stock for potions is not enough", "HIGH PRIORITY", -1));
        expectedComplaints.add(new Complaint(2l, "maximum purchases aren't high enough", "HIGH PRIORITY", -1));
        expectedComplaints.add(new Complaint(3l,"monsters keep stealing my keys", "HIGH PRIORITY", -1));
        expectedComplaints.add(new Complaint(5l, "not enough events", "LOW PRIORITY", -1));
        expectedComplaints.add(new Complaint(6l,"stores close too early", "LOW PRIORITY", -1));

        // mock the findLowPriority method of the repository, so that the repository doesn't actually access the database
        Mockito.when(complaintRepository.findLowPriority()).thenReturn(expectedComplaints);

        // ensure that the service only returns the complaints of status "LOW PRIORITY":
        Assertions.assertEquals(expectedComplaints, complaintService.getAll("LOW PRIORITY"));
    }

    @Test
    public void testGetIgnored() {
        List<Complaint> expectedComplaints = new ArrayList<>();
        expectedComplaints.add(new Complaint(1l, "item stock for potions is not enough", "IGNORED", -1));
        expectedComplaints.add(new Complaint(2l, "maximum purchases aren't high enough", "IGNORED", -1));
        expectedComplaints.add(new Complaint(3l,"monsters keep stealing my keys", "IGNORED", -1));
        expectedComplaints.add(new Complaint(5l, "not enough events", "LOW PRIORITY", -1));
        expectedComplaints.add(new Complaint(6l,"stores close too early", "LOW PRIORITY", -1));

        // mock the findIgnored method of the repository, so that the repository doesn't actually access the database
        Mockito.when(complaintRepository.findIgnored()).thenReturn(expectedComplaints);

        // ensure that the service only returns the complaints of status "IGNORED":
        Assertions.assertEquals(expectedComplaints, complaintService.getAll("IGNORED"));
    }


}
