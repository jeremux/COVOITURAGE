/*
 * Classe pour répresenter un conducteur
 *
 * @author Jeremy FONTAINE
 * @since 1.0
 */
package model;

public class Conducteur extends Profil {

	/**
	 * Instantiates a new conducteur.
	 */
	public Conducteur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Conducteur(String pseudo, String pass, String email, String nom, String prenom, String dateInscription,
			String dateNaissance, Ville ville, Preference preference) {
		super(pseudo, pass, email, nom, prenom, dateInscription, dateNaissance, ville, preference);
		// TODO Auto-generated constructor stub
	}

	public Conducteur(Profil p) {
		this(p.getPseudo(), p.getPass(), p.getEmail(), p.getNom(), p.getPrenom(), p.getDateInscription(), p.getDateNaissance(), p.getVille(), p.getPreference());
		this.setId(p.getId());
	}

}
