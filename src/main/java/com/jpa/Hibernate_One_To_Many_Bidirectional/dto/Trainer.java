package com.jpa.Hibernate_One_To_Many_Bidirectional.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Trainer {
	
	@Id
	@Column(name = "Trainer_Id")
	private int id;
	private String name;
	private String address;
	private long phone;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy =   "trainer")
	private List<Trainee> trainees;

	public Trainer(int id, String name, String address, long phone) {
	
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	
	
	

}
