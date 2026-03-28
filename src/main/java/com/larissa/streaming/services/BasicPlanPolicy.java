package com.larissa.streaming.services;

import org.springframework.stereotype.Component;

import com.larissa.streaming.entities.Subscription;
import com.larissa.streaming.enums.PlanType;

@Component
public class BasicPlanPolicy implements PlanPolicy {

    @Override
    public double calculateFinalAmount(Subscription subscription) {
        return subscription.getMonthlyPrice() * subscription.getMonths();
    }
    
    @Override
    public PlanType getPlanType() {
        return PlanType.BASIC;
    }
}
