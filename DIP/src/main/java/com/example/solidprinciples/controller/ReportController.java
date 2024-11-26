package com.example.solidprinciples.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.solidprinciples.interfaces.INotification;
import com.example.solidprinciples.service.ReportService;

@RestController
@RequestMapping("/api/mindspark")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private INotification emailNotificationService;

    @Autowired
    private INotification whatsappNotificationService;

    @GetMapping("/generate-report")
    public String generateAndSendReport() {
        String report = reportService.generateWeeklyReport();
        
        emailNotificationService.sendReportToStakeholders(report);
        whatsappNotificationService.sendReportToStakeholders(report);
        
        return "Report generated and sent to stakeholders.";
    }
}
