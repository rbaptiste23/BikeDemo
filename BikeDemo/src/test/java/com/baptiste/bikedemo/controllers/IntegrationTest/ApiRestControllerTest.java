package com.baptiste.bikedemo.controllers.IntegrationTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.baptiste.bikedemo.controllers.ApiRestController;
import com.baptiste.bikedemo.model.Bike;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApiRestControllerTest {
	
	@Autowired
	ApiRestController apiRestController; 
	
 
	

	@Test
	public void testGetAllBikes() {
		List<Bike> bikes = apiRestController.getAllBikes();
		assertThat(bikes).isNotEqualTo(null);
	}

}
