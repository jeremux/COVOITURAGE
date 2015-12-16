/*
 * Classe pour traiter le formulaire d'ajout de trajet
 *
 * @author Jeremy FONTAINE
 * @since 1.0
 */
package web;


import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import metier.TrajetGestionImpl;
import metier.VilleGestionImpl;
import model.Conducteur;

import model.Profil;
import model.Trajet;


public class AjouterTrajetForm {
	
    private static final String CHAMP_DEPART  = "villeDepart";
    private static final String CHAMP_ARRIVEE  = "villeArrivee";
    private static final String CHAMP_DATE   = "date";
    private static final String CHAMP_HEURE  = "heure";
    private static final String CHAMP_PLACES  = "places";
    private static final String CHAMP_PRIX  = "prix";

    //private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();

   /* public String getResultat() {
        return resultat;
    }*/

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Trajet ajouterTrajet( HttpServletRequest request ) {
        /* Récupération des champs du formulaire */
        String cpVilleDepart  = getValeurChamp( request, CHAMP_DEPART );
        String cpVilleArrivee = getValeurChamp( request, CHAMP_ARRIVEE );
        String date           = getValeurChamp(request, CHAMP_DATE);
        String heure          = getValeurChamp(request, CHAMP_HEURE);
        String places         = getValeurChamp(request, CHAMP_PLACES);
        String prix           = getValeurChamp(request, CHAMP_PRIX);
        Trajet trajet         = new Trajet();

       
                       
        /* Validation */
        try {
            validationDate(date);
        } catch ( Exception e ) {
            setErreur( CHAMP_DATE, e.getMessage() );
        }
        
        try {
            validationVille(cpVilleArrivee,cpVilleDepart);
        } catch ( Exception e ) {
            setErreur( CHAMP_DEPART, e.getMessage() );
            setErreur( CHAMP_ARRIVEE, e.getMessage() );
        }


        if ( erreurs.isEmpty() ) {
        	Profil p = (Profil) request.getSession().getAttribute("sessionUtilisateur");
        	TrajetGestionImpl trajetDAO = new TrajetGestionImpl();
            VilleGestionImpl villeDAO = new VilleGestionImpl();
            Conducteur conducteur = new Conducteur(p);
            trajet = new Trajet(villeDAO.findByCP(cpVilleDepart),villeDAO.findByCP(cpVilleArrivee), date, heure, Integer.parseInt(places), Double.parseDouble(prix), conducteur);
            trajet = trajetDAO.create(trajet);
        }
        return trajet;
    }



    private void validationVille(String cpVilleArrivee, String cpVilleDepart) throws Exception {
		if(cpVilleArrivee.equals(cpVilleDepart))
		{
			throw new Exception("Indiquez des villes différentes");
		}
		
	}

	private void validationDate(String date) throws Exception {
    	int annee = Integer.parseInt(date.split("-")[0]);
    	int mois = Integer.parseInt(date.split("-")[1]);
    	int jour = Integer.parseInt(date.split("-")[2]);




    	Calendar c = Calendar.getInstance();

    	// set the calendar to start of today
    	c.set(Calendar.HOUR_OF_DAY, 0);
    	c.set(Calendar.MINUTE, 0);
    	c.set(Calendar.SECOND, 0);
    	c.set(Calendar.MILLISECOND, 0);

    	// and get that as a Date
    	Date today = c.getTime();

    	// or as a timestamp in milliseconds
    	long todayInMillis = c.getTimeInMillis();

    
    	// reuse the calendar to set user specified date
    	c.set(Calendar.YEAR, annee);
    	c.set(Calendar.MONTH, mois);
    	c.set(Calendar.DAY_OF_MONTH,jour);

    	// and get that as a Date
    	Date dateSpecified = c.getTime();

    	// test your condition
    	if (dateSpecified.before(today)) {
    		throw new Exception( "Date anterieur à celle d'aujourd'hui" );
    	} 
    	

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
    
    private static boolean toBool(String s)
    {
    	 return (s == null )? false : true;
    }
}
