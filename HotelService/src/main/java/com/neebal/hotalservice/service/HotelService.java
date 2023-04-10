package com.neebal.hotalservice.service;

import java.util.List;

import com.neebal.hotalservice.entity.Hotel;

public interface HotelService {
	
	// post hotel details
	
	Hotel createData(Hotel hotel);
	// update hotels details
	
	Hotel updateData(Hotel hotel , String hotelId);
	
	// delete hotels details
	
	void deleteData (String hotelId);
	
	// gel all details 
	
	List<Hotel> showData();
	
	// get sigal details
	
	Hotel showDataById(String hotelId);

}
