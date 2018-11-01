package com.baptiste.bikedemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baptiste.bikedemo.model.Bike;
import com.baptiste.bikedemo.repository.BikeRepository;

@Controller
@RequestMapping("/Delete")
public class DeleteController {

	
	@Autowired
	BikeRepository bikeRepository;
	
 
	@GetMapping
	public String deleteGetEvent() {
		//System.out.println(bike);
		//bikeRepository.delete(bike);

		// delete information 
		
		
		return "bikelistdeleteform";
	}
	
	
	
//	//Delete 
//	@PostMapping("/{id}")
//	public String deleteEvent(@PathVariable("id") long id, @ModelAttribute("Bike") Bike bike) {
//		//System.out.println(bike);
//		bikeRepository.delete(bike);
//
//		return "bikelistdeleteform";
//	}
//	
	
	@PostMapping()
	public String deleteNoEvent(@ModelAttribute("Bike") Bike bike) {
		//System.out.println(bike);
		bikeRepository.delete(bike);
		return "bikelistdeleteform";
	}
	
}
