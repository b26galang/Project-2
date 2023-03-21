package com.revature.dao;

import com.revature.entity.Complaint;
import com.revature.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComplaintDaoImpl implements ComplaintDao {

    // connection to the database
    Connection connection;

    public ComplaintDaoImpl() {
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public List<Complaint> findUnreviewed() {
        String sql = "select * from complaints where status = 'UNREVIEWED';";

        // create an empty list to store all the addressed complaints
        List <Complaint> complaints = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");
                int meetingId = resultSet.getInt("meeting_id");

                Complaint complaint = new Complaint(id, description, status, meetingId);

                complaints.add(complaint);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong when querying for complaints with the status of 'UNREVIEWED'");
        }
        return complaints;
    }

    @Override
    public List<Complaint> findHighPriority() {
        String sql = "select * from complaints where status = 'HIGH PRIORITY';";

        // create an empty list to store all the high priority complaints
        List <Complaint> complaints = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");
                int meetingId = resultSet.getInt("meeting_id");

                Complaint complaint = new Complaint(id, description, status, meetingId);

                complaints.add(complaint);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong when querying for complaints with the status of 'HIGH PRIORITY'");
        }
        return complaints;
    }

    @Override
    public List<Complaint> findLowPriority() {
        String sql = "select * from complaints where status = 'LOW PRIORITY';";

        // create an empty list to store all the addressed complaints
        List <Complaint> complaints = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");
                int meetingId = resultSet.getInt("meeting_id");

                Complaint complaint = new Complaint(id, description, status, meetingId);

                complaints.add(complaint);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong when querying for complaints with the status of 'LOW PRIORITY'");
        }
        return complaints;
    }

    @Override
    public List<Complaint> findIgnored() {
        String sql = "select * from complaints where status = 'IGNORED';";

        // create an empty list to store all the addressed complaints
        List<Complaint> complaints = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");
                int meetingId = resultSet.getInt("meeting_id");

                Complaint complaint = new Complaint(id, description, status, meetingId);

                complaints.add(complaint);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong when querying for complaints with the status of 'IGNORED'");
        }
        return complaints;
    }

    @Override
    public List<Complaint> findAddressed() {
        String sql ="select * from complaints where status = 'ADDRESSED';";

        // create an empty list to store all the addressed complaints
        List <Complaint> complaints = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");
                int meetingId = resultSet.getInt("meeting_id");


                Complaint complaint = new Complaint(id, description, status, meetingId);

                complaints.add(complaint);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong when querying for complaints with the status of 'ADDRESSED'");
        }
        return complaints;
    }

}
