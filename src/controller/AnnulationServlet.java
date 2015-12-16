/*
 * Classe pour gérer 
 * l'annulation d'une reservation
 *
 * @author Jeremy FONTAINE
 * @since 1.0
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.ProfilGestionImpl;
import metier.TrajetGestionImpl;
import metier.VoyageursGestionImpl;
import model.Passager;
import model.Profil;
import model.Trajet;
import model.Voyageurs;

/**
 * Servlet implementation class AnnulationServlet
 */
@WebServlet(name = "annulerReservation", urlPatterns = { "/annulerReservation" })
public class AnnulationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnnulationServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//si on a les parametres dans l'url
		if (request.getParameter("idTrajet") != null && request.getParameter("idPassager") != null) {
			int                  idTrajet     = Integer.parseInt(request.getParameter("idTrajet"));
			int                  idProfil     = Integer.parseInt(request.getParameter("idPassager"));

			ProfilGestionImpl    profilDAO    = new ProfilGestionImpl();
			TrajetGestionImpl    trajetDAO    = new TrajetGestionImpl();
			VoyageursGestionImpl voyageursDAO = new VoyageursGestionImpl();
		
			//on recupere le passager
			Passager             passager     = new Passager(profilDAO.find(idProfil));
			//on recupere le trajet
			Trajet               trajet       = trajetDAO.find(idTrajet);
			
			//on supprime le couple (passager,trajet)
			voyageursDAO.delete(passager, trajet);
		}

		Profil p = (Profil) request.getSession().getAttribute("sessionUtilisateur");
		
		this.getServletContext().getRequestDispatcher("/mesReservations?id=" + p.getId()).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
