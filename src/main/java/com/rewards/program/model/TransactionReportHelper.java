package com.rewards.program.model;

import java.time.LocalDateTime;


public class TransactionReportHelper {

    private Integer id;
    private String customerId;

    private String monthAndYear;


    private Integer monthlyPoints;

    private Integer totalPoints;

    public Integer getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getMonthAndYear() {
        return monthAndYear;
    }

    public Integer getMonthlyPoints() {
        return monthlyPoints;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }
    public TransactionReportHelper(String customerId, String monthAndYear, Integer monthlyPoints) {
        this.customerId = customerId;
        this.monthAndYear = monthAndYear;
        this.monthlyPoints = monthlyPoints;
    }
}

