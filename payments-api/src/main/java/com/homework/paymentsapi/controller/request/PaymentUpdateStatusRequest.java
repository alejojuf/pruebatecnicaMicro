package com.homework.paymentsapi.controller.request;

import com.homework.paymentsapi.persistence.model.PaymentStatus;

import java.math.BigDecimal;
import java.time.Instant;

public class PaymentUpdateStatusRequest {
	private PaymentStatus status;

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}
}
