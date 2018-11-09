package com.baptiste.bikedemo.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerTest {


	@Mock
	Customer customer;


		
	

	@Test
	public void testGetSsi() {
//		List<Bike> bikeList = new ArrayList<Bike>();
//		List<Customer> cust = new ArrayList<Customer>();
//		
//  		Bike bike = new Bike();
//  		bike.setEmail("bjackson@yahoo.com");
//  		bike.setName("Bobby Jackson");
//  		bike.setPurchasePrice(new BigDecimal(508.23));
//  		bike.setSerialNumber("SN9876543210");
//  		bike.setPhone("405-448-8747");
//  		bike.setModel("XM300");
//  		bike.setPurchaseDate(new Date());
//  		
//  		bikeList.add(bike);
//  		
//  		
//  		
//  		customer.setEmail("george@yahoo.com");
//  		customer.setModel("MX500");
//  		customer.setName("John Doe");
//  		customer.setPhone("405-778-1487");
//  		customer.setSsi("615-87-1578");
//  		customer.setBike(bikeList);
		
		when(customer.getSsi()).thenReturn("557-78-1187");
		String outcome = customer.getSsi();
		assertNotNull(outcome);
	}

	@Test
	public void testGetName() {
		String outcome = customer.getName();
		assertNotNull(outcome);
	}

	@Test
	public void testGetEmail() {
		String outcome = customer.getEmail();
		assertNotNull(outcome);
	}
	
	@Test
	public void testGetModel() {
		String outcome = customer.getModel();
		assertNotNull(outcome);
	}

	@Test
	public void testGetPhone() {
		String outcome = customer.getPhone();
		assertNotNull(outcome);
	}


	@Test
	public void testGetBike() {
		List<Bike> bikeFinal = customer.getBike();
		assertNotNull(bikeFinal);
	}
	
	
	@Test
	public void testSetSsi() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void testSetEmail() {
		fail("Not yet implemented");
	}


	@Test
	public void testSetModel() {
		fail("Not yet implemented");
	}


	@Test
	public void testSetPhone() {
		fail("Not yet implemented");
	}


	@Test
	public void testSetBike() {
		fail("Not yet implemented");
	}

}
