package com.bib.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bib.mvc.model.Document;


public interface DocumentRepository extends JpaRepository<Document, Long> {

	//Document save(Emprunte emprunte);
	//public Page<Livre> listLivre(Long id,Pageable peagable );

}
