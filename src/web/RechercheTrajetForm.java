package web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import facade.FacadeUtilisateur;
import metier.ProfilGestionImpl;
import metier.VilleGestionImpl;
import model.Profil;
import model.Trajet;
import model.Ville;

public class RechercheTrajetForm {
	public static final String CHAMP_VILLE_DEPART = "villeDepart";
	public static final String CHAMP_VILLE_ARRIVEE = "villeArrivee";
	public static final String CHAMP_DATE = "date";

    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public List<Trajet> rechercheTrajet( HttpServletRequest request ) {
        /* Récupération des champs du formulaire */
        String villeDepart = getValeurChamp( request, CHAMP_VILLE_DEPART );
        String villeArrivee = getValeurChamp( request, CHAMP_VILLE_ARRIVEE );
        String date = getValeurChamp(request, CHAMP_DATE);
        FacadeUtilisateur facade =  new FacadeUtilisateur();
        VilleGestionImpl villeDAO = new VilleGestionImpl();
        

        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            
        } else {
            
        }
        
        Ville vDep = villeDAO.findByCP(villeDepart);
        Ville vArr = villeDAO.findByCP(villeArrivee);
        System.out.println("vDep = "+vDep.getId());
        System.out.println("vArr = "+vArr.getId());
        System.out.println("date = "+date);
        return facade.rechercherTrajet(vArr,vDep, date);
    }



    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
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
