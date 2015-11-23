package metier;

import model.Passager;
import model.Trajet;
import model.Voyageurs;

public interface IVoyageursGestion {
	
	public void add(Voyageurs v);
	public void delete(Voyageurs v);
	public void delete(Passager p,Trajet t);
	
}
