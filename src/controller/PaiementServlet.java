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
import model.Profil;
import model.Trajet;
import model.Voyageurs;

/**
 * Servlet implementation class PaiementServlet
 */
@WebServlet(name = "payerTrajet", urlPatterns = { "/payerTrajet" })
public class PaiementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/paiement.jsp";
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idTrajet = Integer.parseInt(request.getParameter("idTrajet"));
		int idProfil = Integer.parseInt(request.getParameter("idProfil"));
		
		ProfilGestionImpl profilDAO = new ProfilGestionImpl();
		TrajetGestionImpl trajetDAO = new TrajetGestionImpl();
		VoyageursGestionImpl voyageursDAO = new VoyageursGestionImpl();
		
		Voyageurs v = new Voyageurs();
		v = voyageursDAO.find(idTrajet, idProfil);
		
		System.out.println("idTrajet = "+idTrajet);
		System.out.println("idProfil = "+idProfil);
		System.out.println("DEBUG = "+v.isPaye());
		
		v.setPassager(new Passager(profilDAO.find(idProfil)));
		Trajet t = trajetDAO.find(idTrajet);
		t.decrementePlace();
		t = trajetDAO.update(t);
		v.setTrajet(t);
		v.setPaye(true);
		
		v = voyageursDAO.update(v);
		v = voyageursDAO.find(idTrajet, idProfil);
		
		System.out.println("idTrajet = "+idTrajet);
		System.out.println("idProfil = "+idProfil);
		System.out.println("DEBUG = "+v.isPaye());
		
		Profil p = (Profil) request.getSession().getAttribute("sessionUtilisateur");
		
		this.getServletContext().getRequestDispatcher("/mesReservations?id="+p.getId()).forward( request, response );
	}

}
