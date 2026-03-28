package com.larissa.streaming.dto;

public class SubscriptionResponse {

    private String customerName;
    private String planType;
    private double finalAmount;
    private String message;

    public SubscriptionResponse() {
    }

    public SubscriptionResponse(String customerName, String planType, double finalAmount, String message) {
        this.customerName = customerName;
        this.planType = planType;
        this.finalAmount = finalAmount;
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
