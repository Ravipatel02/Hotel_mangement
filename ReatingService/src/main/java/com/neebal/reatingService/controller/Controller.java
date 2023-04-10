package com.neebal.reatingService.controller;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

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

import com.neebal.reatingService.entity.Reating;
import com.neebal.reatingService.service.ReatingService;

@RestController
public class Controller {
	
	// create data


	
	@Autowired
	private ReatingService reatingService;
	
	@PostMapping("reating/post")
	public ResponseEntity<Reating> createData(@RequestBody Reating reating){
		
		Reating createData = this.reatingService.createData(reating);
		
		return new ResponseEntity<Reating>(createData , HttpStatus.CREATED);
		
	}
	
	//update data
	@PutMapping("reating/update/{reatingId}")
	public ResponseEntity<Reating> updateReating(@RequestBody Reating reating , @PathVariable String reatingId){
		
		Reating updateData = this.reatingService.updateData(reating, reatingId);
		updateData.setHotelId(reating.getHotelId());
		updateData.setRating(reating.getRating());
		updateData.setRemark(reating.getRemark());
		updateData.setUserId(reating.getUserId());
		
		return new ResponseEntity<Reating>(updateData , HttpStatus.OK);
		
	}
	
	//delete data
	@DeleteMapping("reating/delete/{reatingId}")
	public void deleteReating(@PathVariable String reatingId){
		this.reatingService.deleteData(reatingId);
		//return ResponseEntity.ok(Map.of("deleted","deleted successfully"));
	}
	
	//get reating by userId
	@GetMapping("reating/user/{userId}")
	public ResponseEntity<List<Reating>> getReatingByuserId(@PathVariable String userId){
		List<Reating> list = this.reatingService.getReatingByuserId(userId);
		return new ResponseEntity<List<Reating>>(list ,HttpStatus.OK);

	}

	// get all data
	public ResponseEntity<List<Reating>> showAllReating(){
		//this.reatingService.ge

		return null;

	}
	
//	@GetMapping("reating/user/{hotelId}")
//	public ResponseEntity<List<Reating>> getReatingByHotelId(@PathVariable String hotelId){
//		List<Reating> list = this.reatingService.getReatingByuserId(hotelId);
//		return new ResponseEntity<List<Reating>>(list ,HttpStatus.OK);
//
//	}

}
