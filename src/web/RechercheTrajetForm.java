/*
 * Classe pour traiter le formulaire de recherche
 *
 * @author Jeremy FONTAINE
 * @since 1.0
 */
package web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import facade.FacadeUtilisateur;
import metier.VilleGestionImpl;
import model.Trajet;
import model.Ville;

public class RechercheTrajetForm {
	public static final String CHAMP_VILLE_DEPART = "villeDepart";
	public static final String CHAMP_VILLE_ARRIVEE = "villeArrivee";
	public static final String CHAMP_DATE = "date";

//    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();

//    public String getResultat() {
//        return resultat;
//    }

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
        
        
        Ville vDep = villeDAO.findByCP(villeDepart);
        Ville vArr = villeDAO.findByCP(villeArrivee);
        return facade.rechercherTrajet(vArr,vDep, date);
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
