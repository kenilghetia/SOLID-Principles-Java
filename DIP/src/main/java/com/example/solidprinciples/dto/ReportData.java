package com.example.solidprinciples.dto;

public class ReportData {
    private int userId;
    private int totalUsageTime;
    private String usageDate;

    // Constructor, getters, and setters
    public ReportData(int userId, int totalUsageTime, String usageDate) {
        this.userId = userId;
        this.totalUsageTime = totalUsageTime;
        this.usageDate = usageDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTotalUsageTime() {
        return totalUsageTime;
    }

    public void setTotalUsageTime(int totalUsageTime) {
        this.totalUsageTime = totalUsageTime;
    }

    public String getUsageDate() {
        return usageDate;
    }

    public void setUsageDate(String usageDate) {
        this.usageDate = usageDate;
    }
}
