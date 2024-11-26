package com.example.solidprinciples.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.solidprinciples.interfaces.INotification;

@Service
public class WhatsappNotificationService implements INotification {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void sendReportToStakeholders(String report) {
        String sql = "SELECT phone FROM stakeholders";
        
        List<String> phoneNumbers = jdbcTemplate.queryForList(sql, String.class);
        
        for (String phone : phoneNumbers) {
            sendWhatsAppMessage(phone, report);
        }
    }

    private void sendWhatsAppMessage(String phoneNumber, String reportContent) {
        // Implement the API call for WhatsApp (e.g., using Twilio)
        System.out.println("Sending WhatsApp to " + phoneNumber + ": " + reportContent);
    }
}
