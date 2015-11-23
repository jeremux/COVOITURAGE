package metier;

import model.Ville;

public interface IVilleGestion {
	
	public Ville getVilleParID(int id);
	public void addVille(Ville v);
	public void deleteVille(String cp);
}
