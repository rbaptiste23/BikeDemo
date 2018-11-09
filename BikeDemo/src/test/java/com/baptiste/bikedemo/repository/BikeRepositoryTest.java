package com.baptiste.bikedemo.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.baptiste.bikedemo.model.Bike;
import com.baptiste.bikedemo.service.BikeService;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class BikeRepositoryTest {


	@Autowired
	TestEntityManager em;

	@Autowired
	BikeRepository bikeRepository;
	


	@Test
	public void testFindAll() {
		List<Bike> bike = bikeRepository.findAll();
		assertNotNull(bike);
		
	}



	@Test
	public void testGetOne() {
	

		Long id = 8L;
		Bike bike = new Bike();
		bike.setId(id);

		bike.setEmail("bjackson@yahoo.com");
		bike.setName("Bobby Jackson");
		bike.setPurchasePrice(new BigDecimal(508.23));
		bike.setSerialNumber("SN9876543210");
		bike.setPhone("405-448-8747");
		bike.setModel("XM300");
		bike.setPurchaseDate(new Date());

		
		//em.persist(bike);

		Optional<Bike> foundBike = bikeRepository.findById(id);
				
		assertThat(foundBike.get().getId(), is(equalTo(id)));

	}

}
