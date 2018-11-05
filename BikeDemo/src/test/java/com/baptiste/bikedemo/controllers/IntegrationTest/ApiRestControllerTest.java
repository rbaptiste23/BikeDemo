package com.baptiste.bikedemo.controllers.IntegrationTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.baptiste.bikedemo.controllers.ApiRestController;
import com.baptiste.bikedemo.service.BikeService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApiRestControllerTest {
	
	@Autowired
	ApiRestController apiRestController; 
	
	
	@Autowired 
	private BikeService bikeService;
	
	

	@Test
	public void testGetAllBikes() {
		bikeService.getAllBikes();
	}

}
