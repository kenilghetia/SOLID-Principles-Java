package com.example.solidprinciples.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.solidprinciples.controller.ReportController;

@Service
public class ReportScheduler {
    private static final Logger logger = LoggerFactory.getLogger(ReportScheduler.class);

    private final ReportController reportController;

    public ReportScheduler(ReportController reportController) {
        this.reportController = reportController;
    }

    // This method will be called every day at midnight
    @Scheduled(cron = "0 0 0 * * ?")
    public void scheduleReportGeneration() {
        try {
            logger.info("Starting report generation...");
            reportController.generateAndSendReport();
            logger.info("Report generated and sent successfully.");
        } catch (Exception e) {
            logger.error("Error occurred while generating and sending the report: ", e);
        }
    }
}
