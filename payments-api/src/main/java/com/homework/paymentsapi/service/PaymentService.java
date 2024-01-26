package com.homework.paymentsapi.service;

import com.homework.paymentsapi.controller.request.AveragePeriod;
import com.homework.paymentsapi.controller.request.PaymentRequest;
import com.homework.paymentsapi.controller.request.mapper.PaymentRequestMapper;
import com.homework.paymentsapi.persistence.model.Payment;
import com.homework.paymentsapi.persistence.model.PaymentStatus;
import com.homework.paymentsapi.persistence.repository.PaymentRepository;
import com.homework.paymentsapi.service.dto.PaymentAverage;
import com.homework.paymentsapi.service.dto.PaymentDto;
import com.homework.paymentsapi.service.dto.PaymentGroupedDto;
import com.homework.paymentsapi.service.dto.mapper.PaymentDtoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PaymentService {

	private final PaymentRepository paymentRepository;

	public PaymentService(PaymentRepository repository) {
		this.paymentRepository = repository;
	}

	@Transactional
	public PaymentDto createPayment(PaymentRequest request) {
		Payment payment = PaymentRequestMapper.mapToPayment(request);
		Payment createdPayment = paymentRepository.save(payment);
		return PaymentDtoMapper.mapFromPayment(createdPayment);
	}


	public List<PaymentDto> getAllMonthlyPayments() {
		Instant today = Instant.now();
		Instant oneMonthAgo = today.minus(30, ChronoUnit.DAYS);
		return paymentRepository.getMonthlyPayments(oneMonthAgo, today)
				.stream()
				.map(PaymentDtoMapper::mapFromPayment)
				.toList();
	}

	public void markPaymentAsPaid(long paymentId, PaymentStatus status) throws Exception {
		Optional<Payment> result = paymentRepository.findById(paymentId);
		if (result.isPresent()) {
			Payment payment = result.get();
			payment.setStatus(status);
			paymentRepository.save(payment);
		} else {
			throw new Exception("Not found");
		}
	}

	public PaymentGroupedDto getAllMonthlyPaymentsGrouped() {
		List<PaymentDto> payments = getAllMonthlyPayments();
		List<PaymentDto> pendingPayments = payments.stream().filter(it -> it.getStatus() == PaymentStatus.PENDING).toList();
		List<PaymentDto> paidPayments = payments.stream().filter(it -> it.getStatus() == PaymentStatus.PAID).toList();

		return new PaymentGroupedDto(pendingPayments, paidPayments);
	}

	public PaymentAverage getAverageCostByPeriod(AveragePeriod period) {
		long daysToSubtract = period == AveragePeriod.DAILY ? 1L : period == AveragePeriod.WEEKLY ? 7L : 15L;
		Instant today = Instant.now();
		Instant daysAgo = today.minus(daysToSubtract, ChronoUnit.DAYS);
		Optional<BigDecimal[]> totalWithCount = paymentRepository.getMonthlyPayments(daysAgo, today)
				.stream().map(Payment::getAmount)
				.filter(Objects::nonNull)
				.map(bd -> new BigDecimal[]{bd, BigDecimal.ONE})
				.reduce((a, b) -> new BigDecimal[]{a[0].add(b[0]), a[1].add(BigDecimal.ONE)});

		if(totalWithCount.isPresent()) {
			BigDecimal average = totalWithCount.get()[0].divide(totalWithCount.get()[1], RoundingMode.HALF_UP);
			return new PaymentAverage(average);
		} else {
			return new PaymentAverage(BigDecimal.ZERO);
		}




	}


}
