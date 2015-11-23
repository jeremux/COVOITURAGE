package metier;

import model.Conducteur;
import model.Profil;

public interface IProfilGestion {
	
	public void addProfil(Profil p);
	public void deleteProfil(Profil p);
	public Profil getProfilFromPseudo(String pseudo);
	public Profil getProfilFromEmail(String email);
	public Conducteur getProfilFromID(int id);
}
