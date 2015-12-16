/*
 * Classe pour publier un nouveau trajet
 *
 * @author Jeremy FONTAINE
 * @since 1.0
 */
package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.VilleGestionImpl;
import model.Trajet;
import model.Ville;
import web.AjouterTrajetForm;

/**
 * Servlet implementation class PublicationServlet
 */
@WebServlet(name = "publication", urlPatterns = { "/publication" })
public class PublicationServlet extends HttpServlet {

	private static final long   serialVersionUID = 1L;
	public  static final String ATT_VILLE        = "lesVilles";
	public  static final String ATT_TRAJET       = "lesTrajets";
    public  static final String ATT_FORM         = "form";
    public  static final String VUE              = "/ajouterTrajet.jsp";
    public  static final String VUE_POST         = "/accueil";  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VilleGestionImpl villeDAO = new VilleGestionImpl();
		List<Ville> lesVilles = villeDAO.findAll();
		
		request.setAttribute( ATT_VILLE, lesVilles);
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VilleGestionImpl villeDAO = new VilleGestionImpl();
		List<Ville> lesVilles = villeDAO.findAll();
	
		
		AjouterTrajetForm form = new AjouterTrajetForm();
		//on ajoute le nouveau trajet
		Trajet t = form.ajouterTrajet(request);
		
		request.setAttribute( ATT_VILLE, lesVilles);
		request.setAttribute( ATT_FORM, form );
        
        if(t.getId()!=-1)
        {
        	this.getServletContext().getRequestDispatcher( VUE_POST ).forward( request, response );
        }
        else{
        	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        }
	}

}
