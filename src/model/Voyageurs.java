package model;

public class Voyageurs {
	
	private Profil passager;
	private Trajet trajet;
	private boolean paye;
	private int flagExistence;
	public Voyageurs() {
		super();
		setFlagExistence(-1);
	}

	

	public Voyageurs(Profil passager, Trajet trajet, boolean paye) {
		super();
		this.passager = passager;
		this.trajet = trajet;
		this.paye = paye;
		setFlagExistence(1);
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

	public boolean isPaye() {
		return paye;
	}

	public void setPaye(boolean paye) {
		this.paye = paye;
	}



	public int getFlagExistence() {
		return flagExistence;
	}



	public void setFlagExistence(int flagExistence) {
		this.flagExistence = flagExistence;
	}
	
	
}
