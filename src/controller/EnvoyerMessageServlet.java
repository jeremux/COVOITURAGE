/*
 * Classe pour envoyer un message 
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

import metier.VilleGestionImpl;
import model.Message;
import model.Trajet;
import model.Ville;
import web.AjouterTrajetForm;
import web.EnvoyerMessageForm;

/**
 * Servlet implementation class EnvoyerMessageServlet
 */
@WebServlet(name = "envoyerMessage", urlPatterns = { "/envoyerMessage" })
public class EnvoyerMessageServlet extends HttpServlet {
	private static final long   serialVersionUID = 1L;

    public  static final String ATT_FORM         = "form";
    public  static final String VUE              = "/contactConducteur.jsp";
    public  static final String VUE_POST         = "/accueil";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnvoyerMessageServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//gestion du formulaire d'envoie
		EnvoyerMessageForm form = new EnvoyerMessageForm();
		Message            m    = form.ajouterMessage(request);
		
		request.setAttribute( ATT_FORM, form );
        
		
        if(m.getId()!=-1)
        {
        	this.getServletContext().getRequestDispatcher( VUE_POST ).forward( request, response );
        }
        else{
        	String erreur = "une erreur est survenue";
        	request.setAttribute("erreur", erreur);
        	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        }
	}

}
