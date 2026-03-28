package com.larissa.streaming.entities;

import com.larissa.streaming.enums.PlanType;

public class Subscription {

    private String customerName;
    private PlanType planType;
    private double monthlyPrice;
    private int months;

    public Subscription() {
    }

    public Subscription(String customerName, PlanType planType, double monthlyPrice, int months) {
        this.customerName = customerName;
        this.planType = planType;
        this.monthlyPrice = monthlyPrice;
        this.months = months;
    }

    public String getCustomerName() {
        return customerName;
    }

    public PlanType getPlanType() {
        return planType;
    }

    public double getMonthlyPrice() {
        return monthlyPrice;
    }

    public int getMonths() {
        return months;
    }
}
