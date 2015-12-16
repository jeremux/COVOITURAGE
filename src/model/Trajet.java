package model;

public class Trajet implements Comparable<Trajet>{
	
	private int id;
	private Ville depart;
	private Ville destination;
	private String date;
	private String heure;
	private int places;
	private double prix;
	private Conducteur conducteur;
	private String date2;
	
	public Trajet() {
		super();
		// TODO Auto-generated constructor stub
		this.id=-1;
	}

	public Trajet(Ville depart, Ville destination, String date, String heure, int places, double prix,
			Conducteur conducteur) {
		super();
		this.depart = depart;
		this.destination = destination;
		this.setDate(date);
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
		String[] tmp = date.split("-");
		setDate2(tmp[2]+"-"+tmp[1]+"-"+tmp[0]);
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
	
	public String toString()
	{
		String res = "***************************************";
		res += "\nVille depart = "+this.getDepart().getNom();
		res += "\n ville d'arrivee = "+this.getDestination().getNom();
		res += "\n date = "+this.getDate();
		res += "\n heure ="+this.getHeure();
		res += "\n places ="+this.getPlaces();
		res += "\n prix =" +this.getPrix();
		res += "\n conducteur ="+this.getConducteur().getPrenom();
		
		return res;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	@Override
	public int compareTo(Trajet o) {
		return Double.compare(this.prix, o.prix);
	}

	public void decrementePlace() {
		if(places>=1)
			places--;
		
	}
	
}
