package com.baptiste.bikedemo.controllers.IntegrationTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.baptiste.bikedemo.controllers.HelloResource;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloResourceTest {
	
	
	@Autowired
	HelloResource helloController;
	
	@Mock
	UserDetails userDetails;
		

	@Test
	public void testHelloTrue() {
		
		when(userDetails.isEnabled()).thenReturn(true);
		when(userDetails.isAccountNonExpired()).thenReturn(true);
		when(userDetails.isAccountNonLocked()).thenReturn(true);
		String outcome = helloController.hello(userDetails);
		assertThat(outcome, is(equalTo("Hello World")));
	}
	
	@Test
	public void testHelloFalse() {
		
		when(userDetails.isEnabled()).thenReturn(false);
		when(userDetails.isAccountNonExpired()).thenReturn(false);
		when(userDetails.isAccountNonLocked()).thenReturn(false);
		String outcome = helloController.hello(userDetails);
		assertThat(outcome, is(equalTo("Hello World")));
	}


}
