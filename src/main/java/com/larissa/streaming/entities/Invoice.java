package com.larissa.streaming.entities;

public class Invoice {

    private String customerName;
    private String planType;
    private double finalAmount;

    public Invoice() {
    }

    public Invoice(String customerName, String planType, double finalAmount) {
        this.customerName = customerName;
        this.planType = planType;
        this.finalAmount = finalAmount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }
}