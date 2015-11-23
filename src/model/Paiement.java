package model;

public class Paiement {
	
	private Passager client;
	private Trajet trajet;
	private boolean paiementValide;
	
	public Paiement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paiement(Passager client, Trajet trajet, boolean paiementValide) {
		super();
		this.client = client;
		this.trajet = trajet;
		this.paiementValide = paiementValide;
	}

	public Passager getPassager() {
		return client;
	}

	public void setPassager(Passager client) {
		this.client = client;
	}

	public Trajet getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

	public boolean isPaiementValide() {
		return paiementValide;
	}

	public void setPaiementValide(boolean paiementValide) {
		this.paiementValide = paiementValide;
	}
	
	
}
