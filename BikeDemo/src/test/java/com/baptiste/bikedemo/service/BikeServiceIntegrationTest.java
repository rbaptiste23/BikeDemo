package com.baptiste.bikedemo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import com.baptiste.bikedemo.model.Bike;
import com.baptiste.bikedemo.model.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class BikeServiceIntegrationTest {

	@Autowired
	BikeService bikeService;

	@Test
	public void testGetAllBikes() {
		List<Bike> bikes = bikeService.getAllBikes();
		assertNotNull(bikes);
		
	}

	@Test
	public void testGetCDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String currDate = bikeService.getCDate();
		assertNotNull(currDate);
		assertEquals(sdf.format(new Date()), currDate);

	}

	@Test
	public void testGetBike() {

		Page<Bike> pBike = bikeService.getBike(3);
		assertNotNull(pBike);
		assertEquals(4, pBike.getSize());
	}

	@Test
	public void testGetAllCustomer() {
		List<Customer> customer = bikeService.getAllCustomer();
		assertNotNull(customer);
		assertEquals(5, customer.size());
	}

	@Test
	public void testGet600Customer() {
		List<Customer> customer = bikeService.get600Customer();
		assertNotNull(customer);
		assertEquals(2, customer.size());
	}
	
	@Test
	//@Transactional
	public void testSaveBike() {
 			
		Bike bike = new Bike();
		bike.setEmail("bjackson@yahoo.com");
		bike.setName("Bobby Jackson");
		bike.setPurchasePrice(new BigDecimal(508.23));
		bike.setSerialNumber("SN9876543210");
		bike.setPhone("405-448-8747");
		bike.setModel("XM300");
		bike.setPurchaseDate(new Date());
	
		
		bikeService.saveBike(bike);
		
		assertNotNull(bike);
		assertNotNull(bike.getEmail());
		assertEquals("Bobby Jackson", bike.getName());
	}
	
	

}
