package com.bib.mvc.model;

import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Positive;

@Entity 
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name= "Type",length=3)
public abstract class Document {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	
	
	@Override
	public String toString() {
		return "Document [id=" + id + ", title=" + title + ", prix=" + prix + ", emprunts=" +  "]";
	}

	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Document( String title, Double prix) {
		super();
		this.title = title;
		this.prix = prix;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Collection<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(Collection<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}
	
	@Positive
	private Double prix;
	
	@OneToMany(mappedBy = "document", fetch = FetchType.LAZY)
	private Collection<Emprunt> emprunts;
}
