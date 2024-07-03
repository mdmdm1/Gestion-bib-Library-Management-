package com.bib.mvc.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Adherent {
	
	public Adherent() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column
	@NotBlank
	private String nom;
	
	@Column
	@NotBlank
	private String prenom;
	
	@Column
	private String adresse;
	
	@Column
	private String CIN;
	
	@Column
	//@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateNaissance;
	
	
	public Adherent(String nom, String prenom, String adresse, String CIN, Date dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.CIN = CIN;
		this.dateNaissance = dateNaissance;
	}

	@OneToMany(mappedBy = "adherent", fetch = FetchType.LAZY)
	private Collection<Emprunt> emprunts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String CIN) {
		this.CIN = CIN;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Collection<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunt(Collection<Emprunt> emprunt) {
		this.emprunts = emprunt;
	}

	@Override
	public String toString() {
		return "Adherent [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", CIN=" + CIN
				+ ", dateNaissance=" + dateNaissance +  "]";
	}
	
	
}
