package org.sid.observabilityspringgrafana.repository;

import org.sid.observabilityspringgrafana.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
