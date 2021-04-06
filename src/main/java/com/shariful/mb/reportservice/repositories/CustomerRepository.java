package com.shariful.mb.reportservice.repositories;
import com.shariful.mb.reportservice.entities.dtos.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
