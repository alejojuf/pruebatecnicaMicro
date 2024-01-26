package com.homework.paymentsapi.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(
		name = "PAYMENT"
)
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private String phone;
	@Column(nullable = false)
	private String email;

	private String curp;

	private String rfc;
	@Column(nullable = false)
	private String paymentName;

	private String paymentDescription;

	@Column(nullable = false)
	private Instant startDate;
	private Instant endDate;

	@Column(nullable = false)
	private BigDecimal amount;

	@Enumerated(EnumType.STRING)
	private PaymentStatus status;

	public Payment(String name, String lastName, String phone, String email, String curp, String rfc, String paymentName, String paymentDescription, Instant startDate, Instant endDate, BigDecimal amount, PaymentStatus status) {
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

	public Payment() {
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}
}
