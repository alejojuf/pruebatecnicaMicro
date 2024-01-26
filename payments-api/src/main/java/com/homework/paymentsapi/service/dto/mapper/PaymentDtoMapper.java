package com.homework.paymentsapi.service.dto.mapper;

import com.homework.paymentsapi.persistence.model.Payment;
import com.homework.paymentsapi.service.dto.PaymentDto;

public class PaymentDtoMapper {
	public static PaymentDto mapFromPayment(Payment payment) {
		return new PaymentDto(
				payment.getId(),
				payment.getName(),
				payment.getLastName(),
				payment.getPhone(),
				payment.getEmail(),
				payment.getCurp(),
				payment.getRfc(),
				payment.getPaymentName(),
				payment.getPaymentDescription(),
				payment.getStartDate(),
				payment.getEndDate(),
				payment.getAmount(),
				payment.getStatus()
		);
	}
}
