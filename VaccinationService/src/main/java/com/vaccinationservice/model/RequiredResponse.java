package com.vaccinationservice.model;

import java.util.List;

import com.vaccinationservice.entity.Vaccination;

public class RequiredResponse {

	private Vaccination vaccination;
	private List<Citizen>citizens;
	
	public RequiredResponse() {
		System.out.println("VaccinationModelClassExecuted");	
	}

	public RequiredResponse(Vaccination vaccination, List<Citizen> citizens) {
		super();
		this.vaccination = vaccination;
		this.citizens = citizens;
	}

	@Override
	public String toString() {
		return "RequiredResponse [vaccination=" + vaccination + ", citizens=" + citizens + "]";
	}

	public Vaccination getVaccination() {
		return vaccination;
	}

	public void setVaccination(Vaccination vaccination) {
		this.vaccination = vaccination;
	}

	public List<Citizen> getCitizens() {
		return citizens;
	}

	public void setCitizens(List<Citizen> citizens) {
		this.citizens = citizens;
	}
	
	
	
 	
}
