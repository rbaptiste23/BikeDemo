package com.baptiste.bikedemo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baptiste.bikedemo.model.Bike;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long> {
	


}
