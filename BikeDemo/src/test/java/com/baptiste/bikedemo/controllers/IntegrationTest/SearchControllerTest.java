package com.baptiste.bikedemo.controllers.IntegrationTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import com.baptiste.bikedemo.controllers.SearchController;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SearchControllerTest {
	
	
	@Autowired
	SearchController searchController;

	
	@Mock
	Model model;

	@Test
	public void testSearch() {
		String outcome = searchController.search(model, "Hello");
		assertThat(outcome, is(equalTo("bikelisthome")));
	}

}
