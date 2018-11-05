package com.baptiste.bikedemo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
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
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class BikeServiceUnitTest {
	
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
	
	@InjectMocks
	BikeService bikeService;

//	@Before
//	void setUp() throws Exception{
//		MockitoAnnotations.initMocks(this);
//	}

	@Test
	public void testGetAllBikes() {

		
		List<Bike> aMockBikeList = new ArrayList<Bike>();
		Bike aMockBike = new Bike();

		aMockBike.setContact(true);
		aMockBike.setEmail("bjackson@yahoo.com");
		aMockBike.setName("Bobby Jackson");
		aMockBike.setPurchasePrice(new BigDecimal(508.23));
		aMockBike.setSerialNumber("SN9876543210");
		aMockBike.setPhone("405-448-8747");
		aMockBike.setModel("XM300");

		aMockBikeList.add(aMockBike);
		
		when(bikeRepository.findAll()).thenReturn(aMockBikeList);
				
		List<Bike> returnBike = bikeService.getAllBikes();
		
	    assertEquals(1,returnBike.size());		
	}

	
	@Test
	public void testGetCDate() {
		String currentDate; 
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		currentDate = sdf.format(new Date());				
		assertThat(bikeService.getCDate()).isEqualTo(currentDate);
	}
	
	

//	@Test
//	public void testGetBike() {
//		int pageNumber = 3;
//		int PAGESIZE = 4; 
//		
//		
//		Page<Bike> aMockPageList = (Page<Bike>) new ArrayList();
//		
//		Bike aMockBike = new Bike();
//
//		aMockBike.setContact(true);
//		aMockBike.setEmail("bjackson@yahoo.com");
//		aMockBike.setName("Bobby Jackson");
//		aMockBike.setPurchasePrice(new BigDecimal(508.23));
//		aMockBike.setSerialNumber("SN9876543210");
//		aMockBike.setPhone("405-448-8747");
//		aMockBike.setModel("XM300");
//
//		aMockPageList.add(aMockBike);
//		
//		
//		
//		
//				
//
//			
//		PageRequest pr = PageRequest.of(pageNumber-1, PAGESIZE, Sort.Direction.ASC, "id");
//		aMockPageList = pagingRepository.findAll(pr);
//		
//		when(pagingRepository.findAll(pr)).thenReturn(aMockPageList);
//		
//		Page<Bike> b = bikeService.getBike(pageNumber);
//		
//		
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

			customer1.setEmail("rb@outlook.com");
			customer1.setModel("MX4500");
			customer1.setName("Nathan");		

			List<Customer> customerList = new ArrayList<Customer>();
			customerList.add(customer1);
			
			when(customerRepository.findModelMx200And400()).thenReturn(customerList);
			
			assertThat(bikeService.get600Customer()).isNotEqualTo(null);
	  
	  }
	 

}
