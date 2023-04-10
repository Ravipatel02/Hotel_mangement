package com.neebal.user.service.UserService.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.neebal.user.service.UserService.entity.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neebal.user.service.UserService.Dao.UserRepo;
import com.neebal.user.service.UserService.entity.User;
import com.neebal.user.service.UserService.exception.ResourceNotFoundException;
import com.neebal.user.service.UserService.service.UserServices;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceIImpl implements UserServices{
	@Autowired
	private RestTemplate restTemplate ;
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public User saveData(User user) {
		String string = UUID.randomUUID().toString();
		user.setUserId(string);
		User save = this.userRepo.save(user);
		return save;
	}

	@Override
	public User updateData(User user, String userId) {
		User user1 = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User id not found !"+" "+userId));
		user1.setName(user.getName());
		user1.setEmail(user.getEmail());
		user1.setAbout(user.getAbout());
		
		return user1;
	}

	@Override
	public List<User> getData() {
		List<User> findAll = this.userRepo.findAll();
		return findAll;
	}

	@Override
	public User getDataById(String userId) {
		User userdata = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Rsource Not found ! "+ userId));

		// find reating data
		// http://localhost:8083/reating/user/8f85a458-f6a5-4415-86ce-1862fba80d2d
		ArrayList<Rating> ratingForUser = restTemplate.getForObject("http://localhost:8083/reating/user/"+userdata.getUserId(), ArrayList.class);

        userdata.setRating(ratingForUser);
		return userdata;
	}

	@Override
	public void deleteData(String userId) {
		
		User userdata = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Rsource Not found ! "+ userId));
		this.userRepo.delete(userdata);
		
		
	}

}
