package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.FacadeUtilisateur;
import model.Trajet;

/**
 * Servlet implementation class ListeTrajetServlet
 */
@WebServlet(name = "listTrajet", urlPatterns = { "/listTrajet" })
public class ListeTrajetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_TRAJET = "lesTrajets";
	public static final String VUE = "/listTrajet.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeTrajetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		FacadeUtilisateur f = new FacadeUtilisateur();
		List<Trajet> lesTrajets = f.getLesTrajet();
		//lesTrajets = form.rechercheTrajet(request);

		for(Trajet t:lesTrajets)
			System.out.println(t.toString());
			
		
        request.setAttribute( ATT_TRAJET, lesTrajets);
		
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
