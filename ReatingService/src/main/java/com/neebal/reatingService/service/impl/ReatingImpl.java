package com.neebal.reatingService.service.impl;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neebal.reatingService.dao.ReatingRepo;
import com.neebal.reatingService.entity.Reating;
import com.neebal.reatingService.exception.ResourceNotFoundException;
import com.neebal.reatingService.service.ReatingService;

@Service
public class ReatingImpl implements ReatingService{

	private Logger log = LoggerFactory.getLogger(ReatingImpl.class);
	
	@Autowired
	private ReatingRepo reatingRepo;

	@Override
	public Reating createData(Reating reating) {
		String string = UUID.randomUUID().toString();
		reating.setRatingId(string);
		return this.reatingRepo.save(reating);
		
		
	}

	@Override
	public Reating updateData(Reating reating, String reatingId) {
		Reating resource = this.reatingRepo.findById(reatingId).orElseThrow(()->new ResourceNotFoundException());

		resource.setRating(reating.getRating());
		resource.setRemark(reating.getRemark());
		resource.setRatingId(reating.getRatingId());
		return resource;
	}

	@Override
	public void deleteData(String reatingId) {
		Reating resource = this.reatingRepo.findById(reatingId).orElseThrow(()->new ResourceNotFoundException());
		this.reatingRepo.delete(resource);
		
		
	}

	@Override
	public List<Reating> showData() {
		List<Reating> list = this.reatingRepo.findAll();
		return list;
	}

	@Override
	public List<Reating> getReatingByuserId(String userId) {
		List<Reating> list = this.reatingRepo.findByUserId(userId);
		System.out.println(list);
		return list;
	}

	@Override
	public List<Reating> getReatingByHotelId(String hotelId) {
		List<Reating> list = this.reatingRepo.findByHotelId(hotelId);
		return list;
	}

	

	

}
