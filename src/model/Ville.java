package model;

import java.io.Serializable;

public class Ville implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nom;
	private String codePostal;
	
	public Ville(String nom, String codePostal) {
		super();
		this.nom = nom;
		this.codePostal = codePostal;
	}

	public Ville() {
		super();
		this.id=-1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
		
		
		
		
}
