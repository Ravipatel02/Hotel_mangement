package com.neebal.user.service.UserService.service;

import java.util.List;

import com.neebal.user.service.UserService.entity.User;

public interface UserServices {
	
	// save data
	
	User saveData(User user);
	
	// update data
	
	User updateData(User user , String userId);
	
	// get All data
	
	List<User> getData();
	
	// get data by id
	
	User getDataById(String userId);
	
	// delete data 
	
	void deleteData (String userId);
	

}
