/*
 * Classe pour afficher les messages envoyes
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

import metier.MessageGestionImpl;
import model.Message;

/**
 * Servlet implementation class MessageEnvoyes
 */
@WebServlet(name = "messageEnvoyes", urlPatterns = { "/messageEnvoyes" })
public class MessageEnvoyes extends HttpServlet {
	private static final long   serialVersionUID = 1L;
	public  static final String ATT_MSG          = "messagesEnvoyes";
	public  static final String VUE              = "/messageEnvoyes.jsp";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageEnvoyes() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MessageGestionImpl messageDAO      = new MessageGestionImpl();
		int                idProfil        = Integer.parseInt(request.getParameter("id"));
		List<Message>      messagesEnvoyes = messageDAO.findEnvoyes(idProfil);
	
		request.setAttribute( ATT_MSG,messagesEnvoyes);
		
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
