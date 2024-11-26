package com.example.solidprinciples.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.solidprinciples.dto.ReportData;

@Service
public class ReportService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String generateWeeklyReport() {
        String sql = "SELECT u.user_id, SUM(u.usage_time) AS total_usage_time, u.usage_date " +
                     "FROM mindspark_usage u " +
                     "WHERE u.usage_date BETWEEN current_date - INTERVAL '7 days' AND current_date " +
                     "GROUP BY u.user_id, u.usage_date";
                     
        List<ReportData> reportDataList = jdbcTemplate.query(sql, (rs, rowNum) -> {
            return new ReportData(
                rs.getInt("user_id"),
                rs.getInt("total_usage_time"),
                rs.getDate("usage_date").toString()
            );
        });
        
        StringBuilder report = new StringBuilder("Weekly Usage Report:\n");
        for (ReportData data : reportDataList) {
            report.append("User ID: ").append(data.getUserId())
                  .append(", Total Usage Time: ").append(data.getTotalUsageTime())
                  .append(" mins, Date: ").append(data.getUsageDate()).append("\n");
        }
        
        return report.toString();
    }
}
