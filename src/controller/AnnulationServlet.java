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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("idTrajet")!=null && request.getParameter("idPassager")!=null)
		{int idTrajet = Integer.parseInt(request.getParameter("idTrajet"));
		int idProfil = Integer.parseInt(request.getParameter("idPassager"));
		
		ProfilGestionImpl profilDAO = new ProfilGestionImpl();
		TrajetGestionImpl trajetDAO = new TrajetGestionImpl();
		VoyageursGestionImpl voyageursDAO = new VoyageursGestionImpl();
		
		Passager passager = new Passager(profilDAO.find(idProfil));
		Trajet trajet = trajetDAO.find(idTrajet);
		
		voyageursDAO.delete(passager, trajet);
		}
		
		Profil p = (Profil) request.getSession().getAttribute("sessionUtilisateur");
		
       
		
		 this.getServletContext().getRequestDispatcher("/mesReservations?id="+p.getId()).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
