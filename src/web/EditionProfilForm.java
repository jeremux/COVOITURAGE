/*
 * Classe pour traiter le formulaire d'edition de profil
 *
 * @author Jeremy FONTAINE
 * @since 1.0
 */
package web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import metier.PreferenceGestionImpl;
import metier.ProfilGestionImpl;
import metier.VilleGestionImpl;
import model.Preference;
import model.Profil;
import model.Ville;

public class EditionProfilForm {
	
	private static final String CHAMP_OLD_PASS  = "oldPass";
    private static final String CHAMP_PASS      = "pass";
    private static final String CHAMP_EMAIL     = "email";
    private static final String CHAMP_MUSIQUE   = "aimeMusique";
    private static final String CHAMP_DISCUTION = "aimeDiscution";
    private static final String CHAMP_ANIMAUX   = "aimeAnimaux";
    private static final String CHAMP_FUMEUR    = "fumeur";
    private static final String CHAMP_VILLE     = "ville";
    private static final String CHAMP_CP        = "codePostal";
	private static final String CHAMP_CONF      = "conf";

    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Profil modifierProfil( HttpServletRequest request ) {
        /* Récupération des champs du formulaire */
        String  email         = getValeurChamp( request, CHAMP_EMAIL );
        String  pass          = getValeurChamp( request, CHAMP_PASS );
        String  conf          = getValeurChamp(request, CHAMP_CONF);
        String  ville         = getValeurChamp(request, CHAMP_VILLE);
        String  codePostal    = getValeurChamp(request, CHAMP_CP);
        String  oldPass       = getValeurChamp(request, CHAMP_OLD_PASS);
        boolean aimeMusique   = toBool(getValeurChamp( request, CHAMP_MUSIQUE ));
        boolean aimeDiscution = toBool(getValeurChamp( request, CHAMP_DISCUTION));
        boolean aimeAnimaux   = toBool(getValeurChamp(request, CHAMP_ANIMAUX));
        boolean fumeur        = toBool(getValeurChamp(request, CHAMP_FUMEUR));
        
        ProfilGestionImpl profilDAO = new ProfilGestionImpl();
        PreferenceGestionImpl preferenceDAO = new PreferenceGestionImpl();
        VilleGestionImpl villeDAO = new VilleGestionImpl();
        

        Preference pref = new Preference(aimeMusique, aimeAnimaux, aimeDiscution, fumeur);
        Ville v = villeDAO.findByCP(codePostal);
        Preference p = preferenceDAO.getPreference(pref);
        Profil oldProfil = profilDAO.find(Integer.parseInt(request.getParameter("id")));
        Profil newProfil = new Profil();

        /* TODO
         * Tres mauvaise méthode !
         */
        if(v.getId()==-1)
        {
        	v.setCodePostal(codePostal);
        	v.setNom(ville);
        	v = villeDAO.create(v);
        }
               
     
        try {
            validationEmail(email,oldProfil.getEmail());
         
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        
   
        
        if(pass!=null && pass.length()>0)
        try {
            validationMotsDePasse( pass, conf);
            try {
    			validationOldPass(oldPass,oldProfil);
    		} catch (Exception e1) {
    			setErreur(CHAMP_OLD_PASS, e1.getMessage());
    		}
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
            setErreur( CHAMP_CONF, e.getMessage());
            try {
    			validationOldPass(oldPass,oldProfil);
    		} catch (Exception e1) {
    			setErreur(CHAMP_OLD_PASS, e1.getMessage());
    		}
        }
        else
        {
        	pass = oldProfil.getPass();
        }

      
        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
        	newProfil = new Profil(oldProfil.getPseudo(), pass, email, oldProfil.getNom(),oldProfil.getPrenom(), oldProfil.getDateInscription(),oldProfil.getDateNaissance(), v, p);
        	newProfil = profilDAO.update(oldProfil,newProfil);
            resultat = " Profil modifié !";
        } else {
            resultat = "Échec de la modification.";
        }
        
        return newProfil;
    }



	private void validationOldPass(String champOldPass,Profil oldProfil) throws Exception {
		if (champOldPass == null || champOldPass.length()==0)
		{
			throw new Exception("Ancien mot de passe requis");
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

	private void validationEmail(String email,String oldEmail) throws Exception {
		ProfilGestionImpl profilDAO = new ProfilGestionImpl();
		if ( email != null ) {
	        
			if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	            throw new Exception( "Adresse email invalide." );
	        }
	        else if (profilDAO.findByEmail(email).getId()!=-1 && !email.equals(oldEmail)){
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
