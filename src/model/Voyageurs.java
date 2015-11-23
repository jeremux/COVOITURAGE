package model;

public class Voyageurs {
	
	private Profil passager;
	private Trajet trajet;
	
	public Voyageurs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Voyageurs(Profil passager, Trajet trajet) {
		super();
		this.passager = passager;
		this.trajet = trajet;
	}

	public Profil getPassager() {
		return passager;
	}

	public void setPassager(Profil passager) {
		this.passager = passager;
	}

	public Trajet getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}
	
	
	
}
