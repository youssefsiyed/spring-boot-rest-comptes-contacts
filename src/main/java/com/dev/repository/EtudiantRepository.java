package com.dev.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dev.entity.Etudiant;

////@RepositoryRestResource
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

@Query("select p from Etudiant p where p.nomEtudiant like :x")
public Page<Etudiant> selectEtudiant(@Param("x")String mot,Pageable p);
}
