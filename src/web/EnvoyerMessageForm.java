package web;



import javax.servlet.http.HttpServletRequest;

import metier.MessageGestionImpl;
import metier.ProfilGestionImpl;
import metier.TrajetGestionImpl;
import model.Message;
import model.Profil;


public class EnvoyerMessageForm {
	
    private static final String CHAMP_OBJET = "objet";
    private static final String CHAMP_CONTENU = "contenu";

    

    public Message ajouterMessage( HttpServletRequest request ) {
        /* Récupération des champs du formulaire */
        String objet = getValeurChamp( request, CHAMP_OBJET );
        String contenu = getValeurChamp( request, CHAMP_CONTENU );
              
        Message m = new Message();
        MessageGestionImpl messageDAO = new MessageGestionImpl();
        ProfilGestionImpl profilDAO = new ProfilGestionImpl();
        TrajetGestionImpl trajetDAO = new TrajetGestionImpl();
        
        System.out.println("idConducteur ="+request.getParameter("idConducteur"));
        System.out.println("idTrajet ="+request.getParameter("idTrajet"));
        int idDestinataire = Integer.parseInt(request.getParameter("idConducteur"));
        int idTrajet = Integer.parseInt(request.getParameter("idTrajet"));
        Profil p = (Profil) request.getSession().getAttribute("sessionUtilisateur");
        
        if(objet==null)
        	objet = messageDAO.find(Integer.parseInt(request.getParameter("idMessage"))).getObjet();
        
        m = new Message(contenu, objet, p,profilDAO.find(idDestinataire), trajetDAO.find(idTrajet));
        m = messageDAO.create(m);
       
        return m;
    }





    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
    
}
