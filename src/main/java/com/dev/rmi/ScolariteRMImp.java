package com.dev.rmi;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dev.entity.Etudiant;
import com.dev.entity.Formation;
import com.dev.repository.EtudiantRepository;
import com.dev.repository.FormationRepository;

@Component
public class ScolariteRMImp implements ScolariteRemote{
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Autowired
	private FormationRepository formationRepository;
	
	@Override
	public List<Etudiant> AllEtudiant() throws RemoteException {
		
		return etudiantRepository.findAll();
	}

	@Override
	public Etudiant GetEtudiant(Long id) throws RemoteException {
		
		return etudiantRepository.findOne(id);
	}

	@Override
	public Formation SaveFormations(Formation f) throws RemoteException {
		
		return formationRepository.save(f);
	}

}
