package com.neebal.hotalservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Hotel {
	
	@Id
	private String id;
	
	private String name;
	
	private String location;
	
	private String about;

}
