/*
 * Classe traiter le formulaire d'inscription
 *
 * @author Jeremy FONTAINE
 * @since 1.0
 */
package web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import metier.PreferenceGestionImpl;
import metier.ProfilGestionImpl;
import metier.VilleGestionImpl;
import model.Preference;
import model.Profil;
import model.Ville;

public class InscriptionForm {
	
    private static final String CHAMP_NOM  = "nom";
    private static final String CHAMP_PRENOM  = "prenom";
    private static final String CHAMP_PASS   = "pass";
    private static final String CHAMP_NAISSANCE  = "dateNaissance";
    private static final String CHAMP_EMAIL  = "email";
    private static final String CHAMP_MUSIQUE  = "aimeMusique";
    private static final String CHAMP_DISCUTION  = "aimeDiscution";
    private static final String CHAMP_ANIMAUX  = "aimeAnimaux";
    private static final String CHAMP_FUMEUR  = "fumeur";
    private static final String CHAMP_VILLE  = "ville";
    private static final String CHAMP_CP  = "codePostal";
	private static final String CHAMP_CONF = "conf";
	private static final String CHAMP_LOGIN = "login";

    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Profil inscrireUtilisateur( HttpServletRequest request ) {
        /* Récupération des champs du formulaire */
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String pass = getValeurChamp( request, CHAMP_PASS );
        String conf = getValeurChamp(request, CHAMP_CONF);
        String nom = getValeurChamp(request, CHAMP_NOM);
        String prenom = getValeurChamp(request, CHAMP_PRENOM);
        String dateDeNaissance = getValeurChamp(request, CHAMP_NAISSANCE);
        String ville = getValeurChamp(request, CHAMP_VILLE);
        String codePostal = getValeurChamp(request, CHAMP_CP);
        String login = getValeurChamp(request, CHAMP_LOGIN);
        boolean aimeMusique = toBool(getValeurChamp( request, CHAMP_MUSIQUE ));
        boolean aimeDiscution = toBool(getValeurChamp( request, CHAMP_DISCUTION));
        boolean aimeAnimaux = toBool(getValeurChamp(request, CHAMP_ANIMAUX));
        boolean fumeur = toBool(getValeurChamp(request, CHAMP_FUMEUR));
        
        ProfilGestionImpl profilDAO = new ProfilGestionImpl();
        PreferenceGestionImpl preferenceDAO = new PreferenceGestionImpl();
        VilleGestionImpl villeDAO = new VilleGestionImpl();
        
        Profil utilisateur = new Profil();
        Preference pref = new Preference(aimeMusique, aimeAnimaux, aimeDiscution, fumeur);
        Ville v = villeDAO.findByCP(codePostal);
        Preference p = preferenceDAO.getPreference(pref);
       
        
        if(v.getId()==-1)
        {
        	v.setCodePostal(codePostal);
        	v.setNom(ville);
        	v = villeDAO.create(v);
        }
               
        /* Validation */
        try {
            validationLogin(login);
        } catch ( Exception e ) {
            setErreur( CHAMP_LOGIN, e.getMessage() );
        }
        
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }


        try {
            validationMotsDePasse( pass, conf);
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
            setErreur( CHAMP_CONF, e.getMessage());
        }


        utilisateur.setNom( nom );
      
        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
        	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        	Date date = new Date();
        	utilisateur = new Profil(login, pass, email, nom, prenom,dateFormat.format(date), dateDeNaissance, v, p);
        	utilisateur = profilDAO.create(utilisateur);
            resultat = utilisateur.getEmail()+" inscrit !";
        } else {
            resultat = "Échec de l'inscription.";
        }
        
        return utilisateur;
    }



    private void validationLogin(String login) throws Exception {
    	ProfilGestionImpl profilDAO = new ProfilGestionImpl();
    	if (login != null)
		{
			if(profilDAO.findByPseudo(login).getId()!=-1)
				throw new Exception( "Login existant" );
		}
		
	}

	private void validationMotsDePasse(String pass, String conf) throws Exception {
    	 if ( pass != null && conf != null ) {
    	        if ( !pass.equals( conf ) ) {
    	            throw new Exception( "Les mots de passe sont différents" );
    	        } else if ( pass.length() < 4 ) {
    	            throw new Exception("Entrez un mot de passe de plus de 3 caractère");
    	        }
    	       
    	    } else {
    	        throw new Exception( "Mot de passe obligatoire" );
    	    }
		
	}

	private void validationEmail(String email) throws Exception {
		ProfilGestionImpl profilDAO = new ProfilGestionImpl();
		if ( email != null ) {
	        
			if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	            throw new Exception( "Adresse email invalide." );
	        }
	        else if (profilDAO.findByEmail(email).getId()!=-1){
	        	throw new Exception( "Utilisateur déjà inscrit." );
	    } 
		} else {
	        throw new Exception( "Adresse email requise." );
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
