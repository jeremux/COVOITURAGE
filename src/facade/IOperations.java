package facade;

import java.util.List;

import model.Message;
import model.Profil;
import model.Trajet;
import model.Ville;

public interface IOperations {
	
	public void envoyerMessage(Message m);
	public void modifierProfil(Profil nouveauProfil);
	public List<Trajet> rechercherTrajet(Profil p,Ville arrivee);
	public List<Trajet> rechercherTrajet(Ville arrivee,Ville dep);
	public List<Trajet> rechercherTrajet(Ville arrivee,Ville dep,String date);
	public List<Trajet> getLesTrajet();

}
