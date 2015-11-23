package metier;

import model.Preference;

public interface IPreferenceGestion {
	
	public void addPreference(Preference p);
	public void deletePreference(int id);
	public Preference getPreference(int idPref);
	
}
