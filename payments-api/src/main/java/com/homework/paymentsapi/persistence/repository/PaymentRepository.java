package com.homework.paymentsapi.persistence.repository;

import com.homework.paymentsapi.persistence.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	@Query(nativeQuery = true,
			value = "select * " +
					"from PAYMENT " +
					"where start_date >= :startDate and start_date <= :endDate")
	List<Payment> getMonthlyPayments(@Param("startDate") Instant startDate, @Param("endDate") Instant endDate);

}

