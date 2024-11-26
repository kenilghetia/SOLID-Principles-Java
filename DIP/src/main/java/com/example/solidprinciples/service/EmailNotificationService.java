package com.example.solidprinciples.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.mail.SimpleMailMessage;
// import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.solidprinciples.interfaces.INotification;

@Service
public class EmailNotificationService implements INotification {

    // @Autowired
    // private JavaMailSender mailSender;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void sendReportToStakeholders(String report) {
        String sql = "SELECT email FROM stakeholders";
        
        List<String> emails = jdbcTemplate.queryForList(sql, String.class);
        
        for (String email : emails) {
            sendEmail(email, report);
        }
    }

    private void sendEmail(String toEmail, String reportContent) {
        // SimpleMailMessage message = new SimpleMailMessage();
        // message.setTo(toEmail);
        // message.setSubject("Weekly Mindspark Usage Report");
        // message.setText(reportContent);
        // mailSender.send(message);

        System.out.println("Sending Weekly Mindspark Usage Report Email to " + toEmail + ": " + reportContent);

    }
}
