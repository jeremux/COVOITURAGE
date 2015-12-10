package facade;

import java.util.List;

import metier.MessageGestionImpl;
import metier.ProfilGestionImpl;
import metier.TrajetGestionImpl;
import metier.VoyageursGestionImpl;
import model.Message;
import model.Profil;
import model.Trajet;
import model.Ville;

public class FacadeUtilisateur implements IOperations {
	
	private MessageGestionImpl messageDAO = new MessageGestionImpl();
	private ProfilGestionImpl profilDAO = new ProfilGestionImpl();
	private TrajetGestionImpl trajetDAO = new TrajetGestionImpl();
	private VoyageursGestionImpl voyageurDAO = new VoyageursGestionImpl();
	
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
		if(dep.getId() == -1 && (date == null  || date.equals("") ))
		{
			if(arrivee.getId()==-1)
				return trajetDAO.findAll();
			else
				return trajetDAO.find(arrivee);
		}
		else if (dep.getId()==-1)
		{
			if(arrivee.getId()==-1)
				return trajetDAO.find(date);
			else
				return trajetDAO.find(arrivee,date);
		}
		else 
		{
			return trajetDAO.find(dep,arrivee,date);
		}
	
	}

	@Override
	public List<Trajet> getLesTrajet() {
		return trajetDAO.findAll();
	}

	@Override
	public List<Trajet> rechercherTrajet(Ville arrivee) {
		return trajetDAO.find(arrivee);
	}

	@Override
	public List<Trajet> rechercherTrajet(Ville arrivee, String date) {
		// TODO Auto-generated method stub
		return trajetDAO.find(arrivee, date);
	}
	
	public List<Trajet> getReservations(Profil p) {
		return voyageurDAO.find(p);
	}
	
}
