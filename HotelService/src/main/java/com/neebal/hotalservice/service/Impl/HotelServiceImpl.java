package com.neebal.hotalservice.service.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neebal.hotalservice.dao.HotelRepo;
import com.neebal.hotalservice.entity.Hotel;
import com.neebal.hotalservice.exception.ResourceNotFoundException;
import com.neebal.hotalservice.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepo hotelRepo;

	@Override
	public Hotel createData(Hotel hotel) {
		String string = UUID.randomUUID().toString();
		hotel.setId(string);
		return this.hotelRepo.save(hotel);
		
	}

	@Override
	public Hotel updateData(Hotel hotel, String hotelId) {
		
		Hotel resource = this.hotelRepo.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel Id"+" "+ "id not found"));
		
		resource.setName(hotel.getName());
		resource.setAbout(hotel.getAbout());
		resource.setLocation(hotel.getLocation());
		
		return resource;
	}

	@Override
	public void deleteData(String hotelId) {
		// TODO Auto-generated method stub
		Hotel resouce = this.hotelRepo.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Hotel"+" "+hotelId));
		this.hotelRepo.delete(resouce);
		
	}

	@Override
	public List<Hotel> showData() {
		List<Hotel> list = this.hotelRepo.findAll();
		return list;
	}

	
	@Override
	public Hotel showDataById(String hotelId) {
		Hotel resource = this.hotelRepo.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Hotel id Not Found"+" "+ hotelId));
		
		return resource;
	}

}
