package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.FacadeUtilisateur;
import model.Trajet;

/**
 * Servlet implementation class accueilServlet
 */
@WebServlet(name = "accueil", urlPatterns = { "/accueil" })
public class accueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ATT_TRAJET = "lesTrajets";
	public static final String VUE = "/index.jsp";
	public static final String MEILLEURS_PRIX = "meilleursPrix";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public accueilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FacadeUtilisateur f = new FacadeUtilisateur();
		List<Trajet> lesTrajets = f.getLesTrajet();
		List<Trajet> tmp = f.getLesTrajet();
		Collections.sort(tmp);
		List<Trajet> meilleursPrix = new ArrayList<Trajet>();
		
		if(lesTrajets.size()>1)
		{
		
			for(int i=0;i<2;i++)
				meilleursPrix.add(tmp.get(i));
		}
		
		
		if(lesTrajets.size()==1)
		{
		
			meilleursPrix.add(tmp.get(0));
		}
		
		ServletContext servletContext=getServletContext();
		servletContext.setAttribute(MEILLEURS_PRIX,meilleursPrix);
		request.setAttribute(ATT_TRAJET, lesTrajets);
		request.setAttribute(MEILLEURS_PRIX, meilleursPrix);
		
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
