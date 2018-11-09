package com.baptiste.bikedemo.controllers;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class HelloResource {

	@GetMapping
	public String hello(@AuthenticationPrincipal final UserDetails userDetails) {
		String username = userDetails.getUsername();

		Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
		authorities.forEach(System.out::println);

		System.out.println(username);

		if (userDetails.isEnabled()) { 
			System.out.println("User is enabled.");
		} else {
			System.out.println("User is not enabled.");
		}

		if (userDetails.isAccountNonExpired()) {
			System.out.println("Account is not expired.");
		} else {
			System.out.println("Account is expired");
		}

		if (userDetails.isAccountNonLocked()) {
			System.out.println("Account is not locked.");
		} else {
			System.out.println("Account is locked");
		}

		return "Hello World";
	}


}
