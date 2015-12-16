/*
 * Classe pour l'inscription
 * d'un nouvel utilisateur
 *
 * @author Jeremy FONTAINE
 * @since 1.0
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Profil;
import web.InscriptionForm;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet(name = "inscription", urlPatterns = { "/inscription" })
public class InscriptionServlet extends HttpServlet {
	private static final long   serialVersionUID     = 1L;

	public  static final String ATT_USER             = "utilisateur";
    public  static final String ATT_FORM             = "form";
    public  static final String VUE                  = "/inscription.jsp";
    public  static final String VUE_POST_INSCRIPTION = "/postInscription.jsp";
    public  static final String ATT_SESSION_USER     = "sessionUtilisateur";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InscriptionForm form        = new InscriptionForm();
		Profil          utilisateur = form.inscrireUtilisateur(request);
		
		
		
		request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, utilisateur );
		
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

}
