/*
 * Classe pour lire les messages recus
 *
 * @author Jeremy FONTAINE
 * @since 1.0
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.MessageGestionImpl;
import model.Message;

/**
 * Servlet implementation class LireMessageServlet
 */
@WebServlet(name = "lireMessage", urlPatterns = { "/lireMessage" })
public class LireMessageServlet extends HttpServlet {
	private static final long   serialVersionUID = 1L;
	public  static final String ATT_MSG          = "message";
	public  static final String VUE              = "/ouvrirMessage.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LireMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int                idMessage  = Integer.parseInt(request.getParameter("id"));
		MessageGestionImpl messageDAO = new MessageGestionImpl();
		Message            message    = messageDAO.find(idMessage);
		
		request.setAttribute(ATT_MSG, message);
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
