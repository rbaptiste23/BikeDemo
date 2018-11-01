package com.baptiste.bikedemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baptiste.bikedemo.model.Bike;
import com.baptiste.bikedemo.service.BikeService;

@RestController
@RequestMapping("/api")
public class ApiRestController {

	@Autowired 
	private BikeService bikeService;
	
	
	
	@GetMapping("/bikes")
	public List<Bike> getAllBikes() {
		
		return this.bikeService.getAllBikes();
	}
}
