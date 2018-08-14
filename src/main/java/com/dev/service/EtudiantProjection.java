package com.dev.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.dev.entity.Etudiant;

@Projection(name="p2",types={Etudiant.class})
public interface EtudiantProjection {
	
@Value("#{target.nomEtudiant} #{target.prenomEtudiant}")
public String getfullName();

}
