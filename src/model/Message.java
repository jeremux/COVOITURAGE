/*
 * Classe pour representer un message
 *
 * @author Jeremy FONTAINE
 * @since 1.0
 */
package model;

public class Message {
	
	/** The id. */
	private int id;
	
	/** The contenu. */
	private String contenu;
	
	/** The objet. */
	private String objet;
	
	/** The expediteur. */
	private Profil expediteur;
	
	/** The destinataire. */
	private Profil destinataire;
	
	/** The trajet. */
	private Trajet trajet;
	
	/** The sens trajet. */
	private String sensTrajet;
	
	/**
	 * Instantiates a new message.
	 */
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new message.
	 *
	 * @param contenu the contenu
	 * @param objet the objet
	 * @param expediteur the expediteur
	 * @param destinataire the destinataire
	 * @param trajet the trajet
	 */
	public Message(String contenu, String objet, Profil expediteur, Profil destinataire, Trajet trajet) {
		super();
		this.contenu = contenu;
		this.objet = objet;
		this.expediteur = expediteur;
		this.destinataire = destinataire;
		this.trajet = trajet;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the contenu.
	 *
	 * @return the contenu
	 */
	public String getContenu() {
		return contenu;
	}

	/**
	 * Sets the contenu.
	 *
	 * @param contenu the new contenu
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	/**
	 * Gets the objet.
	 *
	 * @return the objet
	 */
	public String getObjet() {
		return objet;
	}

	/**
	 * Sets the objet.
	 *
	 * @param objet the new objet
	 */
	public void setObjet(String objet) {
		this.objet = objet;
	}

	/**
	 * Gets the expediteur.
	 *
	 * @return the expediteur
	 */
	public Profil getExpediteur() {
		return expediteur;
	}

	/**
	 * Sets the expediteur.
	 *
	 * @param expediteur the new expediteur
	 */
	public void setExpediteur(Profil expediteur) {
		this.expediteur = expediteur;
	}

	/**
	 * Gets the destinataire.
	 *
	 * @return the destinataire
	 */
	public Profil getDestinataire() {
		return destinataire;
	}

	/**
	 * Sets the destinataire.
	 *
	 * @param destinataire the new destinataire
	 */
	public void setDestinataire(Profil destinataire) {
		this.destinataire = destinataire;
	}

	/**
	 * Gets the trajet.
	 *
	 * @return the trajet
	 */
	public Trajet getTrajet() {
		return trajet;
	}

	/**
	 * Sets the trajet.
	 *
	 * @param trajet the new trajet
	 */
	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String res = "***************************************";
		res += "id = "+this.getId();
		res += "\nDestinataire = "+this.getDestinataire().getNom();
		res += "\nExpediteur = "+this.getExpediteur().getNom();
		res += "\nObjet = "+this.getObjet();
		res += "\nContenu ="+this.getContenu();
		
		if(this.getTrajet().getId()!=-1)
		{
			System.out.println("trajet = "+this.getTrajet().getId());
			res += "\nDepart ="+this.getTrajet().getDepart().getNom();
			res += "\nArrivee ="+this.getTrajet().getDestination().getNom();
		}
		
		return res;
	}

	/**
	 * Gets the sens trajet.
	 *
	 * @return the sens trajet
	 */
	public String getSensTrajet() {
		return sensTrajet;
	}

	/**
	 * Sets the sens trajet.
	 *
	 * @param sensTrajet the new sens trajet
	 */
	public void setSensTrajet(String sensTrajet) {
		this.sensTrajet = sensTrajet;
	}
	
	
}
