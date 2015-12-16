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
import metier.ProfilGestionImpl;
import model.Conducteur;
import model.Profil;
import model.Trajet;

/**
 * Servlet implementation class ConsultationReservationServlet
 */
@WebServlet(name = "mesReservations", urlPatterns = { "/mesReservations" })
public class ConsultationReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_ANNONCES = "mesReservations";
	public static final String VUE = "/mesAnnoncesReservations.jsp";
	private static final String TITRE ="titre";
	private static final String FACADE = "facadeAdmin";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultationReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProfilGestionImpl profilDAO = new ProfilGestionImpl();
		int idProfil = Integer.parseInt(request.getParameter("id"));
		FacadeUtilisateur facade = new FacadeUtilisateur();
		FacadeAdmin facadeAdmin = new FacadeAdmin();
		Profil p = profilDAO.find(idProfil);
		List<Trajet> mesReservations = facade.getReservations(p);
		String titre = "Mes reservations";
		
		request.setAttribute(TITRE, titre);
		request.setAttribute( ATT_ANNONCES,mesReservations);
		request.setAttribute(FACADE, facadeAdmin);
		
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
