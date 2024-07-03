package com.bib.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bib.mvc.model.Document;
import com.bib.mvc.repository.DocumentRepository;

@Service
public class DocumentService {
	
	@Autowired
	private DocumentRepository repository;
	
	public List<Document> getAllDocuments(){
		
		return this.repository.findAll();
	}
   
	
	public Document getDocumentByID(Long id) {
		return this.repository.findById(id).orElse(null);
	}
	
	public Document saveDocument(Document document) {
		return this.repository.save(document);
		
	}


	public void delete(Long id) {
		this.repository.deleteById(id);
		
	}

	
	
}
