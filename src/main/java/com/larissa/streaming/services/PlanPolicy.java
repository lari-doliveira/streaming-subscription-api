package com.larissa.streaming.services;

import com.larissa.streaming.entities.Subscription;
import com.larissa.streaming.enums.PlanType;

public interface PlanPolicy {

    double calculateFinalAmount(Subscription subscription);

    PlanType getPlanType();
}
