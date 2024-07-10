package com.demoreserva.demoreserva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.demoreserva.demoreserva.repository")
public class DemoreservaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoreservaApplication.class, args);
	}

}
