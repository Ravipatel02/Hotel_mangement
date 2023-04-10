package com.neebal.user.service.UserService.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neebal.user.service.UserService.entity.User;

public interface UserRepo extends JpaRepository<User,String> {
	
	

}
