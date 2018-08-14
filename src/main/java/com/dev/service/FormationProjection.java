package com.dev.service;

import org.springframework.data.rest.core.config.Projection;

import com.dev.entity.Formation;

@Projection(name="projection1",types={Formation.class})
public interface FormationProjection {
	
public Long getIdFormation();
public String getNomFormation();

}
