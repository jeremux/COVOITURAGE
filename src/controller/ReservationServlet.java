package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.ProfilGestionImpl;
import metier.TrajetGestionImpl;
import metier.VoyageursGestionImpl;
import model.Passager;
import model.Voyageurs;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet(name = "reserverTrajet", urlPatterns = { "/reserverTrajet" })
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idTrajet = Integer.parseInt(request.getParameter("idTrajet"));
		int idProfil = Integer.parseInt(request.getParameter("idProfil"));
		
		ProfilGestionImpl profilDAO = new ProfilGestionImpl();
		TrajetGestionImpl trajetDAO = new TrajetGestionImpl();
		VoyageursGestionImpl voyageursDAO = new VoyageursGestionImpl();
		
		Voyageurs v = new Voyageurs();
		v.setPassager(new Passager(profilDAO.find(idProfil)));
		v.setTrajet(trajetDAO.find(idTrajet));
		v.setPaye(false);
		
		voyageursDAO.create(v);
		
		
		this.getServletContext().getRequestDispatcher("/infoTrajet?id="+idTrajet).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
