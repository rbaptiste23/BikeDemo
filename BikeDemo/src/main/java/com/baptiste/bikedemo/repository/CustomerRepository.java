package com.baptiste.bikedemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.baptiste.bikedemo.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

	
	@Query("Select c from Customer c Where c.model = :model")
	List<Customer> findModelByModel(String model);
	
	@Query("Select c.name, c.model, b.email, b.serialNumber, b.phone from Customer c, Bike b Where c.model = b.model")
	List<Customer> findCustRiley();
	
	
	@Query("Select c from Customer c Where c.model in ('XM200','XM400') ")
	List<Customer> findModelMx200And400();
	
}
