package com.bib.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bib.mvc.model.Emprunt;
import com.bib.mvc.repository.EmpruntRepository;

@Service
public class EmpruntService {
	
	@Autowired
	private EmpruntRepository repository;
	
	public List<Emprunt> getAllEmprunts(){
		
		return this.repository.findAll();
	}
	
	public Emprunt getEmpruntByID(Long id) {
		return this.repository.findById(id).orElse(null);
	}
	
	public Emprunt saveEmprunt(Emprunt emprunt) {
		return this.repository.save(emprunt);
		
	}

	public void delete(Long id) {
		this.repository.deleteById(id);
	}

	
}
