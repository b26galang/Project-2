package com.revature.repository;

import com.revature.entity.Complaint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ComplaintRepositoryTest {

    @Autowired
    ComplaintRepository complaintRepository;

//    @BeforeAll
//    public void setUp() {
//        Complaint complaint1 = new Complaint(1l, "item stock for potions is not enough", "UNREVIEWED", -1);
//        Complaint complaint2 = new Complaint(1l, "item stock for potions is not enough", "UNREVIEWED", -1);
//
//
//        complaintRepository.save(complaint1);
//        // create and save objects
//    }

    @Test
    public void testGetAllAddressed() {
        complaintRepository.save(new Complaint(1l, "item stock for potions is not enough", "UNREVIEWED", -1));
        complaintRepository.save(new Complaint(2l, "maximum purchases aren't high enough", "UNREVIEWED", -1));
        complaintRepository.save(new Complaint(3l,"monsters keep stealing my keys", "UNREVIEWED", -1));
        complaintRepository.save(new Complaint(5l, "not enough events", "ADDRESSED", -1));
        complaintRepository.save(new Complaint(6l,"stores close too early", "ADDRESSED", -1));

        Assertions.assertEquals(2, complaintRepository.findAddressed().size());
    }

    @Test
    public void testGetAllUnreviewed() {
        complaintRepository.save(new Complaint(1l, "item stock for potions is not enough", "UNREVIEWED", -1));
        complaintRepository.save(new Complaint(2l, "maximum purchases aren't high enough", "UNREVIEWED", -1));
        complaintRepository.save(new Complaint(3l,"monsters keep stealing my keys", "UNREVIEWED", -1));
        complaintRepository.save(new Complaint(5l, "not enough events", "ADDRESSED", -1));
        complaintRepository.save(new Complaint(6l,"stores close too early", "ADDRESSED", -1));

        Assertions.assertEquals(3, complaintRepository.findUnreviewed().size());
    }

    @Test
    public void testGetAllHighPriority() {
        complaintRepository.save(new Complaint(1l, "item stock for potions is not enough", "HIGH PRIORITY", -1));
        complaintRepository.save(new Complaint(2l, "maximum purchases aren't high enough", "HIGH PRIORITY", -1));
        complaintRepository.save(new Complaint(3l,"monsters keep stealing my keys", "HIGH PRIORITY", -1));
        complaintRepository.save(new Complaint(5l, "not enough events", "ADDRESSED", -1));
        complaintRepository.save(new Complaint(6l,"stores close too early", "ADDRESSED", -1));

        Assertions.assertEquals(3, complaintRepository.findHighPriority().size());
    }

    @Test
    public void testGetAllLowPriority() {
        complaintRepository.save(new Complaint(1l, "item stock for potions is not enough", "HIGH PRIORITY", -1));
        complaintRepository.save(new Complaint(2l, "maximum purchases aren't high enough", "HIGH PRIORITY", -1));
        complaintRepository.save(new Complaint(3l,"monsters keep stealing my keys", "HIGH PRIORITY", -1));
        complaintRepository.save(new Complaint(5l, "not enough events", "LOW PRIORITY", -1));
        complaintRepository.save(new Complaint(6l,"stores close too early", "LOW PRIORITY", -1));

        Assertions.assertEquals(2, complaintRepository.findLowPriority().size());
    }

    @Test
    public void testGetIgnored() {
        complaintRepository.save(new Complaint(1l, "item stock for potions is not enough", "IGNORED", -1));
        complaintRepository.save(new Complaint(2l, "maximum purchases aren't high enough", "IGNORED", -1));
        complaintRepository.save(new Complaint(3l,"monsters keep stealing my keys", "IGNORED", -1));
        complaintRepository.save(new Complaint(5l, "not enough events", "LOW PRIORITY", -1));
        complaintRepository.save(new Complaint(6l,"stores close too early", "LOW PRIORITY", -1));

        Assertions.assertEquals(3, complaintRepository.findIgnored().size());
    }

}
