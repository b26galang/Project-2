package com.revature.service;

import com.revature.entity.Complaint;
import com.revature.exceptions.IdDoesNotExistException;
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

    @MockBean(ComplaintRepository.class)
    ComplaintRepository complaintRepository;

    @Autowired
    ComplaintService complaintService;

    @Test
    public void testInsert(){
        Complaint complaint = new Complaint("potion stock is too little");
        Complaint newComplaint = new Complaint(1l, "potion stock is too little", "UNREVIEWED", -1);

        Mockito.when(complaintRepository.save(complaint)).thenReturn(newComplaint);
        Assertions.assertEquals(newComplaint, complaintService.insert(complaint));
    }

    @Test
    public void testUpdate() throws IdDoesNotExistException {
        Complaint complaint = new Complaint("potion stock is too little");
        Complaint updatedComplaint = new Complaint(1l, "potions are always sold out", "REVIEWED", -1);

        Mockito.when(complaintRepository.save(complaint)).thenReturn(updatedComplaint);
        Assertions.assertEquals(updatedComplaint, complaintService.update(complaint));
    }

    @Test
    public void testDelete() throws IdDoesNotExistException {
        Complaint complaint = new Complaint(1l, "potion stock is too little", "REVIEWED", -1);

        Mockito.when(complaintRepository.existsById(1l)).thenReturn(true);
        Mockito.when(complaintRepository.existsById(2l)).thenReturn(false);

        Assertions.assertTrue(complaintService.delete(1l));
        Assertions.assertFalse(complaintService.delete(2l));
    }

    @Test
    public void testGetById() throws IdDoesNotExistException {
        Complaint expectedComplaint = new Complaint(1l, "potion stock is too little", "UNREVIEWED", -1);
        Mockito.when(complaintRepository.findById(1l)).thenReturn(Optional.of(expectedComplaint));
        Assertions.assertEquals(expectedComplaint, complaintService.getById(1l));
    }

    @Test
    public void testGetAll() {
        List<Complaint> expectedComplaints = new ArrayList<>();
        expectedComplaints.add(new Complaint(1l, "item stock for potions is not enough", "UNREVIEWED", -1));
        expectedComplaints.add(new Complaint(2l, "maximum purchases aren't high enough", "UNREVIEWED", -1));
        expectedComplaints.add(new Complaint(3l,"monsters keep stealing my keys", "UNREVIEWED", -1));

        Mockito.when(complaintRepository.findAll()).thenReturn(expectedComplaints);
        Assertions.assertEquals(expectedComplaints, complaintService.getAll());
    }
}
