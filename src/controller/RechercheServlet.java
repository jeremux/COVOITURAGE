/*
 * Classe rechercher un trajet
 *
 * @author Jeremy FONTAINE
 * @since 1.0
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.VilleGestionImpl;
import model.Profil;
import model.Trajet;
import model.Ville;
import web.InscriptionForm;
import web.RechercheTrajetForm;

/**
 * Servlet implementation class RechercheServlet
 */
@WebServlet(name = "recherche", urlPatterns = { "/recherche" })
public class RechercheServlet extends HttpServlet {
	private static final long   serialVersionUID = 1L;

	public  static final String ATT_VILLE        = "lesVilles";
	public  static final String ATT_TRAJET       = "lesTrajets";
    public  static final String ATT_FORM         = "form";
    public  static final String VUE              = "/recherche.jsp";
    public  static final String POST_VUE         = "/post_recherche.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercheServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VilleGestionImpl villeDAO = new VilleGestionImpl();
		List<Ville> lesVilles = villeDAO.findAll();
		int taille = -1;
		
        request.setAttribute( ATT_VILLE, lesVilles);
        request.setAttribute( "taille", taille);
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RechercheTrajetForm form = new RechercheTrajetForm();
		VilleGestionImpl villeDAO = new VilleGestionImpl();
		List<Ville> lesVilles = villeDAO.findAll();
		List<Trajet> lesTrajets = form.rechercheTrajet(request);
		int taille = 0;

			
		
		request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_VILLE, lesVilles);
		
        taille = lesTrajets.size();
        
        // si on trouve des trajets
        if(lesTrajets.size()>0)
        {
        	 request.setAttribute( ATT_TRAJET, lesTrajets);
        	this.getServletContext().getRequestDispatcher(POST_VUE).forward( request, response );
        }
        else
        {
        	request.setAttribute( "taille", taille);
        	this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
        }
	}

}
