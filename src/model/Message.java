package model;

public class Message {
	
	private int id;
	private String contenu;
	private String objet;
	private Profil expediteur;
	private Profil destinataire;
	private Trajet trajet;
	private String sensTrajet;
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(String contenu, String objet, Profil expediteur, Profil destinataire, Trajet trajet) {
		super();
		this.contenu = contenu;
		this.objet = objet;
		this.expediteur = expediteur;
		this.destinataire = destinataire;
		this.trajet = trajet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public Profil getExpediteur() {
		return expediteur;
	}

	public void setExpediteur(Profil expediteur) {
		this.expediteur = expediteur;
	}

	public Profil getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(Profil destinataire) {
		this.destinataire = destinataire;
	}

	public Trajet getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}
	
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

	public String getSensTrajet() {
		return sensTrajet;
	}

	public void setSensTrajet(String sensTrajet) {
		this.sensTrajet = sensTrajet;
	}
	
	
}
