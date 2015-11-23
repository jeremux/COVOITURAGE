package model;

public class Trajet {
	
	private int id;
	private Ville depart;
	private Ville destination;
	private String date;
	private String heure;
	private int places;
	private double prix;
	private Conducteur conducteur;
	
	public Trajet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trajet(Ville depart, Ville destination, String date, String heure, int places, double prix,
			Conducteur conducteur) {
		super();
		this.depart = depart;
		this.destination = destination;
		this.date = date;
		this.heure = heure;
		this.places = places;
		this.prix = prix;
		this.conducteur = conducteur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ville getDepart() {
		return depart;
	}

	public void setDepart(Ville depart) {
		this.depart = depart;
	}

	public Ville getDestination() {
		return destination;
	}

	public void setDestination(Ville destination) {
		this.destination = destination;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

	public int getPlaces() {
		return places;
	}

	public void setPlaces(int places) {
		this.places = places;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Conducteur getConducteur() {
		return conducteur;
	}

	public void setConducteur(Conducteur conducteur) {
		this.conducteur = conducteur;
	}
	
	
}
