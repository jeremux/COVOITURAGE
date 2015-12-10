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
 * Servlet implementation class MessageRecus
 */
@WebServlet(name = "messageRecus", urlPatterns = { "/messageRecus" })
public class MessageRecus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_MSG = "messagesRecus";
	public static final String VUE = "/messageRecus.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageRecus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MessageGestionImpl messageDAO = new MessageGestionImpl();
		int idProfil = Integer.parseInt(request.getParameter("id"));
		List<Message> messagesRecus = messageDAO.findRecus(idProfil);
		
		request.setAttribute( ATT_MSG,messagesRecus);
		
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
