package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Profil;
import web.EditionProfilForm;

/**
 * Servlet implementation class EditProfilServlet
 */
@WebServlet(name = "editProfil", urlPatterns = { "/editProfil" })
public class EditProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_USER = "utilisateur";
    public static final String ATT_FORM = "form";
    public static final String VUE = "/editionProfil.jsp";
    public static final String VUE_POST ="/postEditionProfil.jsp";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfilServlet() {
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
		EditionProfilForm form = new EditionProfilForm();
		Profil utilisateur = form.modifierProfil(request);
		
		 /* Récupération de la session depuis la requête */
       
		
        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */
        if ( form.getErreurs().isEmpty() ) {
        	HttpSession session = request.getSession();
             /*if(!session.isNew()){
             	session.invalidate();
             	session=request.getSession();
             }*/
            session.setAttribute( ATT_SESSION_USER, utilisateur );
        } 
          
    
		
		
		request.setAttribute( ATT_FORM, form );
       request.setAttribute( ATT_USER, utilisateur );
		
       if(form.getErreurs().isEmpty())   
       { 
    	   
    	   this.getServletContext().getRequestDispatcher( VUE_POST ).forward( request, response );
       }
       else
    	   this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

}
