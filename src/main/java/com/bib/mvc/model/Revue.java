package com.bib.mvc.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("REV")
public class Revue extends Document {
	
	@Column
	private String 	reference;
	private String annee_publication;
	public Revue(String title, Double prix, String reference, String annee_publication) {
		super(title, prix);
		this.reference = reference;
		this.annee_publication=annee_publication;
	}

	

	public Revue(String reference, String annee_publication) {
		super();
		this.reference = reference;
		this.annee_publication = annee_publication;
	}



	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Revue(String reference) {
		super();
		this.reference = reference;
	}

	public Revue() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getAnnee_publication() {
		return annee_publication;
	}



	public void setAnnee_publication(String annee_publication) {
		this.annee_publication = annee_publication;
	}
	
}