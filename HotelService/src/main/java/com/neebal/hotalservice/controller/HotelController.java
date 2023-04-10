package com.neebal.hotalservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neebal.hotalservice.entity.Hotel;
import com.neebal.hotalservice.service.HotelService;


@RestController
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("hotel/post")
	public ResponseEntity<Hotel> addData(@RequestBody Hotel hotel){
		
		Hotel createData = this.hotelService.createData(hotel);
		
		return new ResponseEntity<Hotel>(createData , HttpStatus.OK);
		
	}
	
	@PutMapping("hotel/update/{hotelId}")
	public ResponseEntity<Hotel> updateData(@RequestBody Hotel hotel , @PathVariable String hotelId){
		
		Hotel updateData = this.hotelService.updateData(hotel, hotelId);
		
		return new ResponseEntity<Hotel>(updateData , HttpStatus.OK);
		
	}
	
	@DeleteMapping("hotel/delete/{hotelId}")
	public void deleteData(@PathVariable String hotelId){
		this.hotelService.deleteData(hotelId);
		
		//return ResponseEntity.ok(map.)
		
		
		
	}
	
	@GetMapping("hotel/show")
	public ResponseEntity<List<Hotel>> showAll(){
		
		List<Hotel> list = this.hotelService.showData();
		
		return new ResponseEntity<List<Hotel>>(list , HttpStatus.OK);
		
	}
	
	@GetMapping("hotel/showData/{hotelId}")
	
	public ResponseEntity<Hotel> showDataById(@PathVariable String hotelId){
		Hotel data = this.hotelService.showDataById(hotelId);
		
		return new ResponseEntity<Hotel>(data , HttpStatus.OK);
	}
	
	
	
	

}
