package com.neebal.reatingService.service;

import java.util.List;

import com.neebal.reatingService.entity.Reating;



public interface ReatingService {
	
	
	// post hotel details
	
		Reating createData(Reating reating);
		// update hotels details
		
		Reating updateData(Reating reating , String reatingId);
		
		// delete hotels details
		
		void deleteData (String reatingId);
		
		// gel all details 
		
		List<Reating> showData();
		
		// get all reating by user details
		
		List<Reating> getReatingByuserId(String userId);
		
		// get all reating by hotelId
		
		List<Reating> getReatingByHotelId(String hotelId);

}
