package com.bib.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bib.mvc.model.Emprunt;


public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {

}
