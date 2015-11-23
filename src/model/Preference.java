package model;

public class Preference {
	private int id;
	private boolean aimeMusique;
	private boolean aimeAnimaux;
	private boolean aimeDiscution;
	private boolean fumeur;
	
	public Preference(boolean aimeMusique, boolean aimeAnimaux, boolean aimeDiscution, boolean fumeur) {
		super();
		this.aimeMusique = aimeMusique;
		this.aimeAnimaux = aimeAnimaux;
		this.aimeDiscution = aimeDiscution;
		this.fumeur = fumeur;
	}

	public Preference() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isAimeMusique() {
		return aimeMusique;
	}

	public void setAimeMusique(boolean aimeMusique) {
		this.aimeMusique = aimeMusique;
	}

	public boolean isAimeAnimaux() {
		return aimeAnimaux;
	}

	public void setAimeAnimaux(boolean aimeAnimaux) {
		this.aimeAnimaux = aimeAnimaux;
	}

	public boolean isAimeDiscution() {
		return aimeDiscution;
	}

	public void setAimeDiscution(boolean aimeDiscution) {
		this.aimeDiscution = aimeDiscution;
	}

	public boolean isFumeur() {
		return fumeur;
	}

	public void setFumeur(boolean fumeur) {
		this.fumeur = fumeur;
	}

	
	
	
}
