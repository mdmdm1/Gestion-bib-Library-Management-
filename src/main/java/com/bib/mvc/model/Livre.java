package com.bib.mvc.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Positive;

@Entity
@DiscriminatorValue("LIV")
public class Livre extends Document {
	public Livre(String auteur, int nombrePage) {
		super();
		this.auteur = auteur;
		this.nombrePage = nombrePage;
	}
	@Column
	private String 	auteur;
	
	@Column
	@Positive
	private int nombrePage;
	public Livre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Livre(String title, Double prix, String auteur, int nombrePage) {
		super(title, prix);
		this.auteur = auteur;
		this.nombrePage = nombrePage;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public int getNombrePage() {
		return nombrePage;
	}
	public void setNombrePage(int nombrePage) {
		this.nombrePage = nombrePage;
	}
	
}
