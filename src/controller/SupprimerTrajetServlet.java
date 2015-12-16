/*
 * Classe supprimer un trajet existant
 *
 * @author Jeremy FONTAINE
 * @since 1.0
 */
package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.FacadeAdmin;
import facade.FacadeConducteur;
import facade.FacadeUtilisateur;
import metier.MessageGestionImpl;
import metier.ProfilGestionImpl;
import metier.TrajetGestionImpl;
import metier.VoyageursGestionImpl;
import model.Conducteur;
import model.Message;
import model.Profil;
import model.Trajet;

/**
 * Servlet implementation class SupprimerTrajetServlet
 */
@WebServlet(name = "supprimerTrajet", urlPatterns = { "/supprimerTrajet" })
public class SupprimerTrajetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/accueil";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerTrajetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idTrajet = Integer.parseInt(request.getParameter("idTrajet"));
		int idConducteur = Integer.parseInt(request.getParameter("idConducteur"));
	
		ProfilGestionImpl profilDAO = new ProfilGestionImpl();
		TrajetGestionImpl trajetDAO = new TrajetGestionImpl();
		VoyageursGestionImpl voyageursDAO = new VoyageursGestionImpl();
		MessageGestionImpl messageDAO = new MessageGestionImpl();
		
		
		Conducteur conducteur = new Conducteur(profilDAO.find(idConducteur));
		FacadeConducteur c = new FacadeConducteur(conducteur);
		FacadeAdmin admin = new FacadeAdmin();
		
		Trajet t = trajetDAO.find(idTrajet);
		List<Profil> voyageurs = voyageursDAO.findByTrajet(t);
		
		//on envoie un message aux personnes inscrit au trajets
		Message m = new Message();
		String contenu = "Annulation du voyage "+t.getDepart().getNom()+"==>"+t.getDestination().getNom()+" prévu le "+t.getDate2()+"\n";
		String objet = "Annulation";
		
		m.setContenu(contenu);
		m.setObjet(objet);
		m.setExpediteur(conducteur);
		//pas de trajet
		m.setTrajet(new Trajet());
		m.setSensTrajet(t.getDepart().getNom()+"->"+t.getDestination().getNom());
		
		for(Profil p: voyageurs)
		{
			
			m.setDestinataire(p);
			messageDAO.create(m);
		}
		c.supprimerTrajet(t);
		admin.supprimerMessage(t);
		admin.supprimerVoyageurs(t);
		
		
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
