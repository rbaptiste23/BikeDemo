package com.baptiste.bikedemo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Customer {

	public static final String FIND_BIKE_REPORTS = "findBikeReports";
	
	
	@Id
	private String model;
	private String ssi;
	private String name;
	private String email;
	private String phone;

	@OneToMany
	@JoinColumn(name = "model")
	private List<Bike> bike;

	public String getSsi() {
		return ssi;
	}

	public void setSsi(String ssi) {
		this.ssi = ssi;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Bike> getBike() {
		return bike;
	}

 
	public void setBike(List<Bike> bike) {
		this.bike = bike;
	}

}
