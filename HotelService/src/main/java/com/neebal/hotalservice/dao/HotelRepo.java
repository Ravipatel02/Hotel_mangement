package com.neebal.hotalservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neebal.hotalservice.entity.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, String>{

}
