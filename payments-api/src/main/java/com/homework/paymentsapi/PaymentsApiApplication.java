package com.homework.paymentsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;

@SpringBootApplication(exclude = RepositoryRestMvcAutoConfiguration.class)
public class PaymentsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentsApiApplication.class, args);
	}

}
