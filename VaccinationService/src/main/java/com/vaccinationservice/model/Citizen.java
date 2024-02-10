package com.vaccinationservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Citizen {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private int mobile;
	private double height;
	private double weight;
	private int vaccinationCenterId;
	public Citizen() {
		System.out.println("TableCreated");
	}
	public Citizen(int id, String name, String email, int mobile, double height, double weight,
			int vaccinationCenterId) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.height = height;
		this.weight = weight;
		this.vaccinationCenterId = vaccinationCenterId;
	}
	@Override
	public String toString() {
		return "Citizen [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", height=" + height
				+ ", weight=" + weight + ", vaccinationCenterId=" + vaccinationCenterId + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getVaccinationCenterId() {
		return vaccinationCenterId;
	}
	public void setVaccinationCenterId(int vaccinationCenterId) {
		this.vaccinationCenterId = vaccinationCenterId;
	}

	
	

}
