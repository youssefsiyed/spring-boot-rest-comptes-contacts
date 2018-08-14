package com.dev.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Etudiant implements Serializable{

	@Id
	@GeneratedValue
	private Long idEtudiant;
	private String nomEtudiant;
	private String prenomEtudiant;
	@ManyToOne(fetch=FetchType.LAZY)
	private Formation formation;
	////////////////////////////////////////

	//////////////////////////////////////
	public Long getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(Long idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	public String getNomEtudiant() {
		return nomEtudiant;
	}
	public void setNomEtudiant(String nomEtudiant) {
		this.nomEtudiant = nomEtudiant;
	}
	public String getPrenomEtudiant() {
		return prenomEtudiant;
	}
	public void setPrenomEtudiant(String prenomEtudiant) {
		this.prenomEtudiant = prenomEtudiant;
	}
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	//////////////////////////////////////////	
	
	public Etudiant() {
		
	}
	
	public Etudiant(String nomEtudiant, String prenomEtudiant, Formation formation) {
		super();
		this.nomEtudiant = nomEtudiant;
		this.prenomEtudiant = prenomEtudiant;
		this.formation = formation;
	}
	
}

