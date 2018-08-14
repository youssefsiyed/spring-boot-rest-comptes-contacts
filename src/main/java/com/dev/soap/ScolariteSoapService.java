package com.dev.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dev.entity.Etudiant;
import com.dev.entity.Formation;
import com.dev.repository.EtudiantRepository;
import com.dev.repository.FormationRepository;

@Component
@WebService
public class ScolariteSoapService {

	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Autowired
	private FormationRepository formationRepository;
	////////////////////////////////////////////////
	
	@WebMethod(operationName="ListEtudiant")
	public List<Etudiant> AllEtudiants(){
		return etudiantRepository.findAll();
	}
	//*************************
	@WebMethod(operationName="UnEtudiant")
	public Etudiant OneEtudiant(@WebParam(name="id")Long id){
		return etudiantRepository.findOne(id);
	}
	
	//*************************
		@WebMethod(operationName="saveEtudiant")
	public Etudiant saveEtudiant(@WebParam(name="etudiant")Etudiant etd){
		return etudiantRepository.save(etd);
	}
	//*************************
		@WebMethod(operationName="ajoueFormation")
	public Formation saveFormation(@WebParam(name="formation")Formation f){
		return formationRepository.save(f);
	}
	
}
