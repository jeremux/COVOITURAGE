package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.fastinfoset.tools.VocabularyGenerator;

import facade.FacadeAdmin;
import metier.TrajetGestionImpl;
import metier.VilleGestionImpl;
import metier.VoyageursGestionImpl;
import model.Profil;
import model.Trajet;
import model.Ville;
import model.Voyageurs;

/**
 * Servlet implementation class InfoTrajetServlet
 */
@WebServlet(name = "infoTrajet", urlPatterns = { "/infoTrajet" })
public class InfoTrajetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_TRAJET = "trajet";
	public static final String ATT_VILLE = "lesVilles";
	public static final String ATT_VOYAGEURS = "voyageurs";
	public static final String VUE = "/infoTrajet.jsp";
	public static final String FACADE ="facadeAdmin";
	
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
		FacadeAdmin facadeAdmin = new FacadeAdmin();
		Trajet trajet = trajetDAO.find(idTrajet);
		VilleGestionImpl villeDAO = new VilleGestionImpl();
		VoyageursGestionImpl voyageursDAO = new VoyageursGestionImpl();
		Voyageurs voyageurs = new Voyageurs();
		List<Ville> lesVilles = villeDAO.findAll();
		Profil p;
		HttpSession session = request.getSession();

        if(!session.isNew()){
         p = (Profil) session.getAttribute("sessionUtilisateur");
         if(p != null)
        	 voyageurs = voyageursDAO.find(idTrajet,p.getId());
        }

		
		request.setAttribute(ATT_VOYAGEURS, voyageurs);
		request.setAttribute( ATT_VILLE, lesVilles);
		request.setAttribute( ATT_TRAJET, trajet);
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
