package com.bocobi.back.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "Caissier")
@DiscriminatorValue("Cai")
public class Caissier extends Employe{
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long idCaissier;
//
//	public Long getIdCaissier() {
//		return idCaissier;
//	}
//
//	public void setIdCaissier(Long idCaissier) {
//		this.idCaissier = idCaissier;
//	}
}
