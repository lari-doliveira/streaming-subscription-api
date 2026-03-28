package com.larissa.streaming.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import com.larissa.streaming.dto.SubscriptionRequest;
import com.larissa.streaming.dto.SubscriptionResponse;
import com.larissa.streaming.entities.Invoice;
import com.larissa.streaming.entities.Subscription;
import com.larissa.streaming.enums.PlanType;
import com.larissa.streaming.services.SubscriptionService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/process")
    public SubscriptionResponse process(@RequestBody @Valid SubscriptionRequest request) {
    	
    	PlanType planType;

    	try {
    	    planType = PlanType.valueOf(request.getPlanType().toUpperCase());
    	} catch (IllegalArgumentException e) {
    	    throw new IllegalArgumentException("planType inválido. Use BASIC ou PREMIUM.");
    	}

    	Subscription subscription = new Subscription(
    	        request.getCustomerName(),
    	        planType,
    	        request.getMonthlyPrice(),
    	        request.getMonths()
    	);

        Invoice invoice = subscriptionService.processSubscription(subscription);

        return new SubscriptionResponse(
                invoice.getCustomerName(),
                invoice.getPlanType(),
                invoice.getFinalAmount(),
                "Assinatura processada com sucesso"
        );
    }
}