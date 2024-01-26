package com.homework.paymentsapi.service.dto;

import com.homework.paymentsapi.persistence.model.PaymentStatus;

import java.math.BigDecimal;
import java.time.Instant;

public class PaymentDto {

	private Long id;
	private String name;
	private String lastName;
	private String phone;
	private String email;
	private String curp;
	private String rfc;
	private String paymentName;
	private String paymentDescription;
	private Instant startDate;
	private Instant endDate;
	private BigDecimal amount;

	private PaymentStatus status;


	public PaymentDto() {
	}

	public PaymentDto(Long id, String name, String lastName, String phone, String email, String curp, String rfc, String paymentName, String paymentDescription, Instant startDate, Instant endDate, BigDecimal amount, PaymentStatus status) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.curp = curp;
		this.rfc = rfc;
		this.paymentName = paymentName;
		this.paymentDescription = paymentDescription;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getPaymentName() {
		return paymentName;
	}

	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}

	public String getPaymentDescription() {
		return paymentDescription;
	}

	public void setPaymentDescription(String paymentDescription) {
		this.paymentDescription = paymentDescription;
	}

	public Instant getStartDate() {
		return startDate;
	}

	public void setStartDate(Instant startDate) {
		this.startDate = startDate;
	}

	public Instant getEndDate() {
		return endDate;
	}

	public void setEndDate(Instant endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "PaymentDto{" +
				"name='" + name + '\'' +
				", lastName='" + lastName + '\'' +
				", phone='" + phone + '\'' +
				", email='" + email + '\'' +
				", curp='" + curp + '\'' +
				", rfc='" + rfc + '\'' +
				", paymentName='" + paymentName + '\'' +
				", paymentDescription='" + paymentDescription + '\'' +
				", startDate=" + startDate +
				", endDate=" + endDate +
				", amount=" + amount +
				'}';
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}


}
