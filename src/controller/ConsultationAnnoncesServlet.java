/*
 * Classe pour consulter ses
 * annonces poster
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

import facade.FacadeConducteur;
import metier.ProfilGestionImpl;
import model.Conducteur;
import model.Trajet;

/**
 * Servlet implementation class ConsultationAnnoncesServlet
 */
@WebServlet(name = "mesAnnonces", urlPatterns = { "/mesAnnonces" })
public class ConsultationAnnoncesServlet extends HttpServlet {
	private static final long   serialVersionUID = 1L;
	public  static final String ATT_ANNONCES     = "mesAnnonces";
	public  static final String VUE              = "/mesAnnoncesReservations.jsp";
	private static final String TITRE            = "titre";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConsultationAnnoncesServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProfilGestionImpl profilDAO   = new ProfilGestionImpl();
		int               idProfil    = Integer.parseInt(request.getParameter("id"));

		//On recupere le conducteur
		Conducteur        c           = new Conducteur(profilDAO.find(idProfil));

		//On utilise la facade conducteur pour recuperer ses annonces
		FacadeConducteur  facade      = new FacadeConducteur(c);
		List<Trajet>      mesAnnonces = facade.getAnnonces();

		//Titre html à envoyer dans la requete
		String            titre       = "Mes annonces";

		request.setAttribute(ATT_ANNONCES, mesAnnonces);
		request.setAttribute(TITRE, titre);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
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
