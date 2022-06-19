package com.bocobi.back.services;

import java.util.List;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import com.bocobi.back.models.Patient;

public interface PatientService {

	List<Patient> getAllPatients();
	Patient savePatient(Patient patient);
	void deletePatient(Long id) throws ResourceNotFoundException;
	
}
