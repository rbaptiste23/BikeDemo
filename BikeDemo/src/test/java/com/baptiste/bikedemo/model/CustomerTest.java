package com.baptiste.bikedemo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerTest {

	Customer customer;

	Bike bike;
	List<Bike> bikeList;

	@Before
	public void init() {
		customer = new Customer();
		bike = new Bike();
		bikeList = new ArrayList<Bike>();

	}

	@Test
	public void testGetSsi() {
		customer.setSsi("444-44-4444");
		String outcome = customer.getSsi();
		assertEquals("444-44-4444", outcome);
	}

	@Test
	public void testGetName() {
		customer.setName("Johnny Appleseed");
		String outcome = customer.getName();
		assertEquals("Johnny Appleseed", outcome);
	}

	@Test
	public void testGetEmail() {
		customer.setEmail("jappleseed@yahoo.com");
		String outcome = customer.getEmail();
		assertEquals("jappleseed@yahoo.com", outcome);
	}

	@Test
	public void testGetModel() {
		customer.setModel("MX200");
		String outcome = customer.getModel();
		assertEquals("MX200", outcome);
	}

	@Test
	public void testGetPhone() {
		customer.setPhone("405-781-4872");
		String outcome = customer.getPhone();
		assertEquals("405-781-4872", outcome);
	}

	@Test
	public void testGetBike() {

		bike.setEmail("bjackson@yahoo.com");
		bike.setName("Bobby Jackson");
		bike.setPurchasePrice(new BigDecimal(508.23));
		bike.setSerialNumber("SN9876543210");
		bike.setPhone("405-448-8747");
		bike.setModel("XM300");
		bike.setPurchaseDate(new Date());

		bikeList.add(bike);

		customer.setBike(bikeList);
		List<Bike> bikeFinal = customer.getBike();
		assertEquals(bikeList, bikeFinal);
	}

}
