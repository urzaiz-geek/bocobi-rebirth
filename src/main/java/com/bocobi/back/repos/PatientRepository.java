package com.bocobi.back.repos;

import org.springframework.stereotype.Repository;

import com.bocobi.back.models.Patient;

@Repository
public interface PatientRepository extends PersonRepository<Patient> {
	
}
