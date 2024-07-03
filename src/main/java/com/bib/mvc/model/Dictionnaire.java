package com.bib.mvc.model;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DIC")
public class Dictionnaire extends Document {
	private String 	langue;

	public String getLangue() {
		return langue;
	}
	
	public void setLangue(String langue) {
		this.langue = langue;
	}

	public Dictionnaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dictionnaire(String title, Double prix, String langue) {
		super(title, prix);
		this.langue = langue;
	}

	public Dictionnaire(String langue) {
		super();
		this.langue = langue;
	}
}