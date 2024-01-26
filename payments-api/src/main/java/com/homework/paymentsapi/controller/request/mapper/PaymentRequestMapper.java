package com.homework.paymentsapi.controller.request.mapper;

import com.homework.paymentsapi.controller.request.PaymentRequest;
import com.homework.paymentsapi.persistence.model.Payment;

public class PaymentRequestMapper {
	public static Payment mapToPayment(PaymentRequest paymentRequest) {
		return new Payment(
				paymentRequest.getName(),
				paymentRequest.getLastName(),
				paymentRequest.getPhone(),
				paymentRequest.getEmail(),
				paymentRequest.getCurp(),
				paymentRequest.getRfc(),
				paymentRequest.getPaymentName(),
				paymentRequest.getPaymentDescription(),
				paymentRequest.getStartDate(),
				paymentRequest.getEndDate(),
				paymentRequest.getAmount(),
				paymentRequest.getStatus()
		);
	}
}
