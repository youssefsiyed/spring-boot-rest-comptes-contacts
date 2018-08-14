package com.dev.repository;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.dev.entity.Formation;

@RepositoryRestResource
@RestResource(path="/format")
public interface FormationRepository extends JpaRepository<Formation, Long>{


//public Page<Formation> findbyNameFormation(@Param("mot")String mot,Pageable p);
}
