package com.dev.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.dev.entity.Etudiant;
import com.dev.entity.Formation;

public interface ScolariteRemote extends Remote{

	public List<Etudiant> AllEtudiant() throws RemoteException;
	public Etudiant GetEtudiant(Long id) throws RemoteException;
	public Formation SaveFormations(Formation f) throws RemoteException;
}
