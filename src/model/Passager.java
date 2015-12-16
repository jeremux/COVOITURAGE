/*
 * Classe pour représenter un passager
 *
 * @author Jeremy FONTAINE
 * @since 1.0
 */
package model;

public class Passager extends Profil {

	public Passager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passager(String pseudo, String pass, String email, String nom, String prenom, String dateInscription,
			String dateNaissance, Ville ville, Preference preference) {
		super(pseudo, pass, email, nom, prenom, dateInscription, dateNaissance, ville, preference);
		// TODO Auto-generated constructor stub
	}

	public Passager(Profil p) {
		this(p.getPseudo(), p.getPass(), p.getEmail(), p.getNom(), p.getPrenom(), p.getDateInscription(), p.getDateNaissance(), p.getVille(), p.getPreference());
		this.setId(p.getId());
	}

	
}
