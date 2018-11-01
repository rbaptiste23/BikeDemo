package com.baptiste.bikedemo.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Bike {
	
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
	@NotEmpty
	private String name;

	@NotEmpty
	@Email
	@Pattern(regexp = ".*\\@.*\\..*", message = "This is not a valid e-mail address")
	private String email;

	@NotEmpty
	@Pattern(regexp = "([0-9]{3})[-]([0-9]{3})[-]([0-9]{4})$", message = "Phone number must be in XXX-XXX-XXXX format")
	// @Pattern(regexp="([0-9]{3})[-]?([0-9]{3})[-]?([0-9]{4})$", message="Phone
	// number must be in XXX-XXX-XXXX format")
	private String phone;

	// @Size(min=3, max=20, message="Model must be between 3 and 20 characters")
	// @Pattern(regexp="MX.*", message="Model must have a MX prefix.")
	//@ManyToOne
	private String model;

	@Size(min = 3, max = 15, message = "Serial number must be between 3 and 15 characters")
	@Pattern(regexp = "SN.*", message = "Serial number must begin with a SN followed by a character...")
	@NotEmpty
	@Column(name="serial_number")
	private String serialNumber;

	// @Pattern(regexp="([0-9]{5})[.]([0-9]{2})$", message="Purchase price must be
	// in XXXXX.XX format")
	@NotNull
	private BigDecimal purchasePrice;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	// @Pattern(regexp="([0-9]{2})[/]([0-9]{2}[/]([0-9]{4})$", message="Purchase
	// date must be in MM/DD/YYYY format")
	@NotNull
	private Date purchaseDate;

	@NotNull
	private boolean contact;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public boolean isContact() {
		return contact;
	}

	public void setContact(boolean contact) {
		this.contact = contact;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return getName() + ", " + getEmail() + ", " + getPhone()
				+ ", " + getSerialNumber() + ", " + getPurchasePrice()
				+ ", " + getPurchaseDate() + ", " + isContact() + ", " + getId()
				+ ", " + getModel() + "|| ";
	}

}
