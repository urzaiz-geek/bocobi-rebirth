package com.bocobi.back.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
@PrimaryKeyJoinColumn(name = "fk_idPersonne",referencedColumnName = "idPersonne")
public class Patient extends Personne {
	
	private Date dateNaissance;
	private String lieuResidence;
	private int age;
	private String statutMatrimonial;
	
	
	/*public Long getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(Long idPatient) {
		this.idPatient = idPatient;
	}*/
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getLieuResidence() {
		return lieuResidence;
	}
	public void setLieuResidence(String lieuResidence) {
		this.lieuResidence = lieuResidence;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getStatutMatrimonial() {
		return statutMatrimonial;
	}
	public void setStatutMatrimonial(String statutMatrimonial) {
		this.statutMatrimonial = statutMatrimonial;
	}
	
	
}
