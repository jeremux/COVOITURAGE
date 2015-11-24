package model;

import java.util.Date;

public class Profil {
	
	private int id;
	private String pseudo;
	private String pass;
	private String email;
	private String nom;
	private String prenom;
	private String dateInscription;
	private String dateNaissance;
	private Ville ville;
	private Preference preference;
	
	public Profil(String pseudo, String pass, String email, String nom, String prenom, String dateInscription,
			String dateNaissance, Ville ville, Preference preference) {
		super();
		this.pseudo = pseudo;
		this.pass = pass;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.dateInscription = dateInscription;
		this.dateNaissance = dateNaissance;
		this.ville = ville;
		this.preference = preference;
	}

	public Profil() {
		super();
		this.id = -1;
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(String string) {
		this.dateInscription = string;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public Preference getPreference() {
		return preference;
	}

	public void setPreference(Preference preference) {
		this.preference = preference;
	}
	
	
	
}
