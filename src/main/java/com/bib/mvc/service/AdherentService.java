package com.bib.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bib.mvc.model.Adherent;
import com.bib.mvc.repository.AdherentRepository;

@Service
public class AdherentService {
	
	@Autowired
	private AdherentRepository repository;
	
	public List<Adherent> getAllAdherents(){
		
		return this.repository.findAll();
	}
	
	public Adherent getAdherentByID(Long id) {
		return this.repository.findById(id).orElse(null);
	}
	
	public Adherent saveAdherent(Adherent adherent) {
		return this.repository.save(adherent);
		
	}
	
	public Adherent consulterAdherent(String CIN){
		Adherent ad = this.repository.findByCIN(CIN);
		return ad;
	}

	public void delete(Long id) {
		this.repository.deleteById(id);
		
	}

}	
