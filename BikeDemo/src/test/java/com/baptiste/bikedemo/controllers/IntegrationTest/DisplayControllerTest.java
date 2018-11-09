package com.baptiste.bikedemo.controllers.IntegrationTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.baptiste.bikedemo.controllers.DisplayController;
import com.baptiste.bikedemo.model.Bike;
import com.baptiste.bikedemo.service.BikeService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DisplayControllerTest {
	
	
	@Autowired
	DisplayController displayController;

	@Autowired
	BikeService bikeService;

	
	@Mock
	Model model;
	
	@Mock
	ModelAndView modelAndView;
	
	@Test
	public void testViewAll() {
		
		ModelAndView mv = displayController.viewAll(modelAndView);
		assertNotNull(mv);
	}

	@Test
	public void testGetEvent() {
		Bike bike = new Bike();
		bike.setEmail("bjackson@yahoo.com");
		bike.setName("Bobby Jackson");
		bike.setPurchasePrice(new BigDecimal(508.23));
		bike.setSerialNumber("SN9876543210");
		bike.setPhone("405-448-8747");
		bike.setModel("XM300");
		bike.setPurchaseDate(new Date());
		
		String outcome = displayController.getEvent(4l, bike);
		assertThat(outcome, is(equalTo("bikelist")));
	}

	@Test
	public void testPageViewOneByOne() {
		String outcome = displayController.pageViewOneByOne(model, 4);
		assertThat(outcome, is(equalTo("bikelistpage")));
	}

}
