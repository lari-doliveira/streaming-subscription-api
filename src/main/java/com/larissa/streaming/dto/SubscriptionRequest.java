package com.larissa.streaming.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class SubscriptionRequest {

    @NotBlank(message = "customerName é obrigatório.")
    private String customerName;

    @NotBlank(message = "planType é obrigatório.")
    private String planType;

    @NotNull(message = "monthlyPrice é obrigatório.")
    @Positive(message = "monthlyPrice deve ser maior que zero.")
    private Double monthlyPrice;

    @NotNull(message = "months é obrigatório.")
    @Positive(message = "months deve ser maior que zero.")
    private Integer months;

    public SubscriptionRequest() {
    }

    public SubscriptionRequest(String customerName, String planType, Double monthlyPrice, Integer months) {
        this.customerName = customerName;
        this.planType = planType;
        this.monthlyPrice = monthlyPrice;
        this.months = months;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPlanType() {
        return planType;
    }

    public Double getMonthlyPrice() {
        return monthlyPrice;
    }

    public Integer getMonths() {
        return months;
    }
}
