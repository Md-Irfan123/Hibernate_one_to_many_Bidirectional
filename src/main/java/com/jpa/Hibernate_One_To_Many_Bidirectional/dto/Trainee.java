package com.jpa.Hibernate_One_To_Many_Bidirectional.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trainee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
	private long phone;
	
	@ManyToOne
	@JoinColumn(name="Trainer_Id")
	private Trainer trainer;

	public Trainee(String name, String address, long phone, Trainer trainer) {
	
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.trainer = trainer;
	}
	
	

	

}
