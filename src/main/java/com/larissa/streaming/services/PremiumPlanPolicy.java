package com.larissa.streaming.services;

import org.springframework.stereotype.Component;

import com.larissa.streaming.entities.Subscription;
import com.larissa.streaming.enums.PlanType;

@Component
public class PremiumPlanPolicy implements PlanPolicy {

    @Override
    public double calculateFinalAmount(Subscription subscription) {
        double total = subscription.getMonthlyPrice() * subscription.getMonths();
        return total * 0.90;
    }
    
    @Override
    public PlanType getPlanType() {
        return PlanType.PREMIUM;
    }
}