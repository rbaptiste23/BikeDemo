package com.baptiste.bikedemo.model;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BikeTest {

	Bike bike;
	
	
	@Before
	public void setUp() throws Exception {
	
		bike = new Bike();
	}
	

	@Test
	public void testGetName() {
		bike.setName("Charlie Wilson");
		String outcome = bike.getName();
		assertEquals("Charlie Wilson", outcome);
	}

	@Test
	public void testGetEmail() {
		bike.setEmail("cwilsion@yahoo.com");
		String outcome = bike.getEmail();
		assertEquals("cwilsion@yahoo.com", outcome);
	}

	@Test
	public void testGetPhone() {
		bike.setPhone("333-44-5555");
		String outcome = bike.getPhone();
		assertEquals("333-44-5555", outcome);
	}

	@Test
	public void testGetSerialNumber() {
		bike.setSerialNumber("SN04558145");
		String outcome = bike.getSerialNumber();
		assertEquals("SN04558145", outcome);
	}

	@Test
	public void testGetPurchasePrice() {
		BigDecimal bd = new BigDecimal("3232.12");
		
		bike.setPurchasePrice(bd);
		BigDecimal outcome = bike.getPurchasePrice();
		assertEquals(bd, outcome);
	}

	@Test
	public void testGetPurchaseDate() {
		bike.setPurchaseDate(new Date());
		Date outcome = bike.getPurchaseDate();
		assertEquals(new Date(), outcome);
	}

	@Test
	public void testIsContact() {
		bike.setContact(true);
		Boolean outcome = bike.isContact();
		assertEquals(true, outcome);
	}

	@Test
	public void testGetId() {
		Long val = 8L;
		
		bike.setId(8L);
		Long outcome = bike.getId();
		assertEquals(val, outcome);
	}

	@Test
	public void testGetModel() {
		bike.setModel("MX2000");
		String outcome = bike.getModel();
		assertEquals("MX2000", outcome);;
	}

	@Test
	public void testToString() {
		String val = bike.toString();
		assertNotNull(val);		
	}

}
