package com.homework.paymentsapi.controller;

import com.homework.paymentsapi.controller.request.AveragePeriod;
import com.homework.paymentsapi.controller.request.PaymentRequest;
import com.homework.paymentsapi.controller.request.PaymentUpdateStatusRequest;
import com.homework.paymentsapi.service.PaymentService;
import com.homework.paymentsapi.service.dto.PaymentAverage;
import com.homework.paymentsapi.service.dto.PaymentDto;
import com.homework.paymentsapi.service.dto.PaymentGroupedDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	private final PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PaymentDto save(@RequestBody PaymentRequest paymentRequest) {
		return paymentService.createPayment(paymentRequest);
	}

	@GetMapping("/monthly")
	public List<PaymentDto> getAllMonthlyPayments() {
		return paymentService.getAllMonthlyPayments();
	}

	@PatchMapping("/{paymentId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updatePaymentStatus(@PathVariable Long paymentId, @RequestBody PaymentUpdateStatusRequest paymentUpdateStatusRequest) throws Exception {
		paymentService.markPaymentAsPaid(paymentId, paymentUpdateStatusRequest.getStatus());
	}

	@GetMapping("/monthly_group")
	public PaymentGroupedDto getAllMonthlyGroupPayments() {
		return paymentService.getAllMonthlyPaymentsGrouped();
	}

	@GetMapping("/average")
	public PaymentAverage getAverageCostByPeriod(@RequestParam AveragePeriod averagePeriod) {
		return paymentService.getAverageCostByPeriod(averagePeriod);
	}
}
