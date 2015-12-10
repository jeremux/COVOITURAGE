package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.TrajetGestionImpl;
import metier.VilleGestionImpl;
import model.Trajet;
import model.Ville;

/**
 * Servlet implementation class InfoTrajetServlet
 */
@WebServlet(name = "infoTrajet", urlPatterns = { "/infoTrajet" })
public class InfoTrajetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_TRAJET = "trajet";
	public static final String ATT_VILLE = "lesVilles";
	public static final String VUE = "/infoTrajet.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoTrajetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrajetGestionImpl trajetDAO = new TrajetGestionImpl();
		int idTrajet = Integer.parseInt(request.getParameter("id"));
		Trajet trajet = trajetDAO.find(idTrajet);
		VilleGestionImpl villeDAO = new VilleGestionImpl();
		List<Ville> lesVilles = villeDAO.findAll();
		
		request.setAttribute( ATT_VILLE, lesVilles);
		request.setAttribute( ATT_TRAJET, trajet);
		
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
