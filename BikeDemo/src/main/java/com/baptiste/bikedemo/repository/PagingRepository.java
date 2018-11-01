package com.baptiste.bikedemo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.baptiste.bikedemo.model.Bike;
@Repository
public interface PagingRepository extends PagingAndSortingRepository<Bike, Long> {

}
