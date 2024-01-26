package com.homework.paymentsapi.service.dto;

import java.util.List;

public class PaymentGroupedDto {

	private List<PaymentDto> pendingPayments;
	private List<PaymentDto> paidPayments;

	public PaymentGroupedDto(List<PaymentDto> pendingPayments, List<PaymentDto> paidPayments) {
		this.pendingPayments = pendingPayments;
		this.paidPayments = paidPayments;
	}

	public PaymentGroupedDto() {
	}

	public List<PaymentDto> getPendingPayments() {
		return pendingPayments;
	}

	public void setPendingPayments(List<PaymentDto> pendingPayments) {
		this.pendingPayments = pendingPayments;
	}

	public List<PaymentDto> getPaidPayments() {
		return paidPayments;
	}

	public void setPaidPayments(List<PaymentDto> paidPayments) {
		this.paidPayments = paidPayments;
	}
}
