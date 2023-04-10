package com.neebal.user.service.UserService.controller;

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
import org.springframework.web.client.RestTemplate;

import com.neebal.user.service.UserService.entity.User;
import com.neebal.user.service.UserService.service.UserServices;


@RestController
public class UserCotroller {
	
	@Autowired
	private UserServices userService;
	
	//@Autowired
	//private RestTemplate restTemplate;
	
	// post data
	
	@PostMapping("user/post")
	public ResponseEntity<User> saveData( @RequestBody User user){
		
		User saveData = this.userService.saveData(user);
		
		return new ResponseEntity<User>(saveData , HttpStatus.CREATED);
		
	}
	
	// update data 
	@PutMapping("user/{userId}")
	public ResponseEntity<User> updateData(@RequestBody User user , @PathVariable String userId){
		
		User updateData = this.userService.updateData(user, userId);
		
		return new ResponseEntity<User>(updateData , HttpStatus.OK);
		
	}
	
	// get data 
	@GetMapping("user")
	public ResponseEntity<List<User>> getData(){
		
		List<User> data = this.userService.getData();
		
		return new ResponseEntity<List<User>>(data , HttpStatus.OK);
		
	}
	
	// get data by id
	@GetMapping("user/{userId}")
	public ResponseEntity<User> getdataById(@PathVariable String userId){
		User dataById = this.userService.getDataById(userId);
		
		return new ResponseEntity<User>(dataById , HttpStatus.OK);
	}
	
	// delete data by id
	
	@DeleteMapping("user/{userId}")
	public void delete(@PathVariable String userId){
		this.userService.deleteData(userId);
		
		//return ResponseEntity.ok(Map.of("Deleted","delete successfully"));
		
	}

}
