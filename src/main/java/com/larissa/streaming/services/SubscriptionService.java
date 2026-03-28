package com.larissa.streaming.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.larissa.streaming.entities.Invoice;
import com.larissa.streaming.entities.Subscription;
import com.larissa.streaming.enums.PlanType;

@Service
public class SubscriptionService {

    private final Map<PlanType, PlanPolicy> policyMap = new HashMap<>();

    public SubscriptionService(List<PlanPolicy> policies) {
        for (PlanPolicy policy : policies) {
            policyMap.put(policy.getPlanType(), policy);
        }
    }

    public Invoice processSubscription(Subscription subscription) {

        PlanPolicy policy = policyMap.get(subscription.getPlanType());

        double finalAmount = policy.calculateFinalAmount(subscription);

        return new Invoice(
                subscription.getCustomerName(),
                subscription.getPlanType().name(),
                finalAmount
        );
    }
}