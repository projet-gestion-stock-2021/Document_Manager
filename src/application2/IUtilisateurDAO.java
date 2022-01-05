package application2;

import java.util.List;

import javafx.collections.ObservableList;

public interface IUtilisateurDAO extends IDAO <Utilisateur> {
	public List<Utilisateur> getAll();
	
}
