package com.dev.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
//@AllArgsConstructor
//@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Formation implements Serializable{
	@Id
	@GeneratedValue
private Long idFormation;
private int dureeFormation;
private String nomFormation;

    @OneToMany(mappedBy="formation")
    @JsonIgnore
    @XmlTransient
private Collection<Etudiant> etudiants;
/////////////////////////////////////////////  
    public Formation (){
    	
    }
/////////////////////////////////////////////

    public Formation(Long idFormation, int dureeFormation, String nomFormation, Collection<Etudiant> etudiants) {
    	super();
    	this.idFormation = idFormation;
    	this.dureeFormation = dureeFormation;
    	this.nomFormation = nomFormation;
    	this.etudiants = etudiants;
    }
////////////////////////////////////////
	public Long getIdFormation() {
		return idFormation;
	}

	
	public void setIdFormation(Long idFormation) {
		this.idFormation = idFormation;
	}

	public int getDureeFormation() {
		return dureeFormation;
	}

	public void setDureeFormation(int dureeFormation) {
		this.dureeFormation = dureeFormation;
	}

	public String getNomFormation() {
		return nomFormation;
	}

	public void setNomFormation(String nomFormation) {
		this.nomFormation = nomFormation;
	}

	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

////////////////////////////////////////

}