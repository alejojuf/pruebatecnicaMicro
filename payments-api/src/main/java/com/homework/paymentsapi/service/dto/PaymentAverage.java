package com.homework.paymentsapi.service.dto;

import com.homework.paymentsapi.persistence.model.PaymentStatus;

import java.math.BigDecimal;
import java.time.Instant;

public class PaymentAverage {

	private BigDecimal average;

	public PaymentAverage() {
	}

	public PaymentAverage(BigDecimal average) {
		this.average = average;
	}

	public BigDecimal getAverage() {
		return average;
	}

	public void setAverage(BigDecimal average) {
		this.average = average;
	}
}
