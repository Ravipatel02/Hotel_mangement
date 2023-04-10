package com.neebal.reatingService.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Reating {
	
	@Id
	
	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String remark;

}
