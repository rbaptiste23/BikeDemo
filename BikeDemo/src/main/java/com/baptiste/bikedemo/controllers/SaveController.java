package com.baptiste.bikedemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baptiste.bikedemo.model.Bike;
import com.baptiste.bikedemo.repository.BikeRepository;
import com.baptiste.bikedemo.service.BikeService;

@Controller
@RequestMapping("/Save")
public class SaveController {

	@Autowired
	BikeRepository bikeRepository;
	
	@Autowired 
	BikeService bikeService;
	
	
	@GetMapping
	public String viewForm(Model model) {				
		//model.addAttribute("bikelist", this.bikeService.getAllBikes());		
		//model.addAttribute("curDate", bikeService.getCDate());
		//System.out.println("Returning " + this.bikeService.getAllBikes().size() + " Bikes to bikes.jsp");					
		return "bikelistsaveform";
	}
	
 
//	//Update 
//	@PostMapping("/{id}")
//	public String updateEvent(@PathVariable("id") long id, @ModelAttribute("Bike") Bike bike) {
//		System.out.println(bike);
//		bikeRepository.save(bike);
//		return "bikelistsaveform";
//	}
	
	//Update 
	@PostMapping()
	public String updateNoParmEvent(@ModelAttribute("Bike") Bike bike) {		
		bikeRepository.save(bike);
		return "bikelistsaveform";
	}
	
}
