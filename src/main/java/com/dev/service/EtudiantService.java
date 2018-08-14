package com.dev.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dev.entity.Etudiant;
import com.dev.repository.EtudiantRepository;

@Component
@Path("/scolarite")
public class EtudiantService {

	@Autowired
	private EtudiantRepository etudiantRepository;
	
	
	@GET
	@Path("/etudiants")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Etudiant> AllEtudiants(){
		return etudiantRepository.findAll();
	}

	@GET
	@Path("/etudiants/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Etudiant chercherEtudiants(@PathParam(value="id")Long id){
		return etudiantRepository.findOne(id);
	}
    
	@POST
	@Path("/etudiants")
	@Produces(MediaType.APPLICATION_JSON)
	public Etudiant SaveEtudiants(Etudiant etd){
		return etudiantRepository.save(etd);
	}

	@PUT
	@Path("/etudiants/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Etudiant UpdateEtudiants(@PathParam(value="id")Long id ,Etudiant etd){
		etd.setIdEtudiant(id);
		return etudiantRepository.save(etd);
		
	}

	@DELETE
	@Path("/etudiants/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void DeleteEtudiants(@PathParam(value="id")Long id){
		 etudiantRepository.delete(id);
	}



}
