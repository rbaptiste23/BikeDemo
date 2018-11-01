package com.baptiste.bikedemo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.baptiste.bikedemo.model.Bike;
import com.baptiste.bikedemo.model.Customer;
import com.baptiste.bikedemo.repository.BikeRepository;
import com.baptiste.bikedemo.repository.CustomerRepository;
import com.baptiste.bikedemo.repository.PagingRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@WebAppConfiguration
public class BikeServiceTest {

	@InjectMocks
	BikeService bikeService;

	@Mock
	BikeRepository bikeRepository;

	@Mock
	CustomerRepository customerRepository;

	@Mock
	PagingRepository pagingRepository;
	
	@Mock
	PageRequest pageRequest;
	
	@Mock
	EntityManager entityManager;

//	@Before
//	void setUp() throws Exception{
//		MockitoAnnotations.initMocks(this);
//	}

	@Test
	public void testGetAllBikes() {

		Bike bike1 = new Bike();

		bike1.setContact(true);
		bike1.setEmail("riley.bap@outlook.com");
		bike1.setModel("MX200");
		bike1.setPhone("444-22-3232");
		bike1.setSerialNumber("SN123456");

		List<Bike> bikeList = new ArrayList<Bike>();
		bikeList.add(bike1);

		when(bikeRepository.findAll()).thenReturn(bikeList);
		assertThat(bikeService.getAllBikes()).isNotEqualTo(null);
	}

	@Test
	public void testGetCDate() {
		assertThat(bikeService.getCDate()).isEqualTo("10/25/2018");
	}
	
	

//	@SuppressWarnings("unchecked")
//	@Test
//	public void testGetBike() {
//		
//		Bike bike1 = new Bike();
//
//		bike1.setContact(true);
//		bike1.setEmail("riley.bap@outlook.com");
//		bike1.setModel("MX200");
//		bike1.setPhone("444-22-3232");
//		bike1.setSerialNumber("SN123456");
//
//		List<Bike> bikeList = new ArrayList<Bike>();
//		bikeList.add(bike1);
//		
//		int pageNumber = 1;
//		int PAGESIZE = 4;
//		
//		PageRequest p = PageRequest.of(pageNumber-1, 4, Sort.Direction.ASC, "id");	
//		
//		Page<Bike> pb = "Hello";
//		
//	
//		
//	
//		
//		
//	
//		
//		when(pagingRepository.findAll(p)).thenReturn(pb);
//		
//		Page<Bike> b = bikeService.getBike(1);
//		assertThat(b).isNotEqualTo(null);
//		
//		
//	}

	
	  @Test public void testGetAllCustomer() {
		  
			Customer customer1 = new Customer();

			customer1.setEmail("riley.bap@outlook.com");
			customer1.setModel("MX4500");
			customer1.setName("Riley");
		 

			List<Customer> customerList = new ArrayList<Customer>();
			customerList.add(customer1);

			when(customerRepository.findAll()).thenReturn(customerList);
			assertThat(bikeService.getAllCustomer()).isNotEqualTo(null);
	  
	  }
	
    	  
	  @Test public void testGet600Customer() { 
			Customer customer1 = new Customer();
			String query ="Select c from Customer c";

			customer1.setEmail("riley.bap@outlook.com");
			customer1.setModel("MX4500");
			customer1.setName("Riley");		

			List<Customer> customerList = new ArrayList<Customer>();
			customerList.add(customer1);
			
			when(entityManager.createQuery(query).getResultList()).thenReturn(customerList);
			
			assertThat(bikeService.get600Customer()).isNotEqualTo(null);
	  
	  }
	 

}
