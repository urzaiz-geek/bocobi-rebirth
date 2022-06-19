package com.bocobi.back.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.bocobi.back.models.Patient;
import com.bocobi.back.repos.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {
	
	private final PatientRepository patientRepository;

	@Autowired
	public PatientServiceImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}

	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public void deletePatient(Long id) throws ResourceNotFoundException{
		
		Patient toDelete = patientRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
		patientRepository.delete(toDelete);
	}

}
