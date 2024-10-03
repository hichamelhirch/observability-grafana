package org.sid.observabilityspringgrafana;

import org.sid.observabilityspringgrafana.entities.Customer;
import org.sid.observabilityspringgrafana.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ObservabilitySpringGrafanaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObservabilitySpringGrafanaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.save(Customer.builder().firstName("John").lastName("Doe").email("john.doe@example.com").build());
			customerRepository.save(Customer.builder().firstName("Jane").lastName("Smith").email("jane.smith@example.com").build());
			customerRepository.save(Customer.builder().firstName("Bob").lastName("Brown").email("bob.brown@example.com").build());
			customerRepository.save(Customer.builder().firstName("Alice").lastName("Johnson").email("alice.johnson@example.com").build());
		};
	}
}
