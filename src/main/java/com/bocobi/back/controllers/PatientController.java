package com.bocobi.back.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.bocobi.back.models.Patient;
import com.bocobi.back.services.PatientService;

@RestController
@RequestMapping("/patients")
@CrossOrigin("*")
public class PatientController {

	private final PatientService patientService;

	@Autowired
	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}

	@GetMapping
	public ResponseEntity<List<Patient>> getAllPatients() {
		return ResponseEntity.status(HttpStatus.OK).body(patientService.getAllPatients());
	}

	@PostMapping
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient,
			UriComponentsBuilder uriComponentsBuilder) {
		
		Patient savedPatient = patientService.savePatient(patient);
		UriComponents uriComponent = uriComponentsBuilder.path("/patients/{id}")
				.buildAndExpand(savedPatient.getIdPersonne());

		return ResponseEntity.status(HttpStatus.CREATED).header("Location", uriComponent.toUriString())
				.body(savedPatient);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deletePatient(@PathVariable("id") Long id, UriComponentsBuilder uriComponentsBuilder) throws Exception{
		patientService.deletePatient(id);
		UriComponents uriComponents = uriComponentsBuilder.path("/patients/{id}").buildAndExpand(id);
		return ResponseEntity.status(HttpStatus.OK).header("Location", uriComponents .toUriString()).build();
	}

}
