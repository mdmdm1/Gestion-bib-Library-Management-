package com.bib.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bib.mvc.model.Adherent;

public interface AdherentRepository extends JpaRepository<Adherent, Long> {

	Adherent findByCIN(String cIN);

//	public Adherent findByCIN(String cIN);
 
}
