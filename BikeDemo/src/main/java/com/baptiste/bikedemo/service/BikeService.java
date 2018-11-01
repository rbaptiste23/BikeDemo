package com.baptiste.bikedemo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.baptiste.bikedemo.model.Bike;
import com.baptiste.bikedemo.model.Customer;
import com.baptiste.bikedemo.repository.BikeRepository;
import com.baptiste.bikedemo.repository.CustomerRepository;
import com.baptiste.bikedemo.repository.PagingRepository;

@Service
public class BikeService {
	
	public BikeService() {
		
	}

	@Autowired
	BikeRepository bikeRepository;
	
	@Autowired
	PagingRepository pagingRepository;
	
	@Autowired 
	CustomerRepository customerRepository;
	

	@PersistenceContext
	private EntityManager entityManager;
	
	
	private final static int PAGESIZE = 4;
	
	public List<Bike> getAllBikes() {
		return bikeRepository.findAll();
	}
	
	
	public String getCDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		return sdf.format(new Date());
	}
	
	public Page<Bike> getBike(int pageNumber){
    	PageRequest request = PageRequest.of(pageNumber-1, PAGESIZE, Sort.Direction.ASC, "id");		
		return pagingRepository.findAll(request);
	}
	
	
	public List<Customer> getAllCustomer() {	
		return customerRepository.findAll();

	}
	

	public List<Customer> get600Customer() {
		
		//String query = "select t from Customer t order by t.model desc";
		//String query = "select t from Customer t where t.model in ('XM200','XM600') ";
		//String query = "Select a, b  from Customer a INNER JOIN a.model b";
		
		
		
		//return customerRepository.findAllCustomerReports();
		
		//return customerRepository.findCustRiley();
		
		//return customerRepository.findAll();
		
 
		
		
		
		//return customerRepository.findModelMx300And400();
		
		// I want the model XM300
		return customerRepository.findModelMx200("XM300");
		
		 
	}
	
	
	
}
