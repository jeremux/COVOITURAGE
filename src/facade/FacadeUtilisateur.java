package facade;

import java.util.List;

import metier.MessageGestionImpl;
import metier.ProfilGestionImpl;
import metier.TrajetGestionImpl;
import model.Message;
import model.Profil;
import model.Trajet;
import model.Ville;

public class FacadeUtilisateur implements IOperations {
	
	private MessageGestionImpl messageDAO = new MessageGestionImpl();
	private ProfilGestionImpl profilDAO = new ProfilGestionImpl();
	private TrajetGestionImpl trajetDAO = new TrajetGestionImpl();
	
	@Override
	public void envoyerMessage(Message m) {
		messageDAO.create(m);
	}

	@Override
	public void modifierProfil(Profil nouveauProfil) {
		profilDAO.update(nouveauProfil);
	}

	@Override
	public List<Trajet> rechercherTrajet(Profil p,Ville arrivee) {
		return trajetDAO.find(p.getVille(),arrivee);
	}

	@Override
	public List<Trajet> rechercherTrajet(Ville depart, Ville arrivee) {
		return trajetDAO.find(depart,arrivee);
	}

	@Override
	public List<Trajet> rechercherTrajet(Ville arrivee, Ville dep, String date) {
		return trajetDAO.find(dep,arrivee,date);
	}

	@Override
	public List<Trajet> getLesTrajet() {
		return trajetDAO.findAll();
	}
	
}