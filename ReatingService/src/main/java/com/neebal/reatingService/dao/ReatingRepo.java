package com.neebal.reatingService.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neebal.reatingService.entity.Reating;

public interface ReatingRepo extends JpaRepository<Reating, String>{
	
	List<Reating> findByUserId(String userId);
	List<Reating> findByHotelId(String hotelId);

}
