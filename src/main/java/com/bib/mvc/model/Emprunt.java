package com.bib.mvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Emprunt {


	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_emprunt;
	
	public Emprunt() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emprunt(Date date_emprunt, Date date_retour, Document document, Adherent adherent) {
		super();
		this.date_emprunt = date_emprunt;
		this.date_retour = date_retour;
		this.document = document;
		this.adherent = adherent;
	}

	

	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", date_emprunt=" + date_emprunt + ", date_retour=" + date_retour + ", document="
				+ document + ", adherent=" + adherent + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate_emprunt() {
		return date_emprunt;
	}

	public void setDate_emprunt(Date date_emprunt) {
		this.date_emprunt = date_emprunt;
	}

	public Date getDate_retour() {
		return date_retour;
	}

	public void setDate_retour(Date date_retour) {
		this.date_retour = date_retour;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotBlank
	private Date date_retour;
	
	@ManyToOne
	@NotBlank
	private Document document;
	
	@ManyToOne
	@NotBlank
	private Adherent adherent;
	
	
	
}
