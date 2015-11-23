package metier;

import model.Ville;

public interface IVilleGestion {
	
	public Ville getVilleParID(int id);
	public Ville getVille(Ville v);
	public void addVille(Ville v);
	public void deleteVille(String cp);
}
