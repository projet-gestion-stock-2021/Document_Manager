package application2;

import java.util.List;

import javafx.collections.ObservableList;
// interface g�n�ric pour d�finir toutes les methodes communes des classes
public interface IDAO<T> {
	public void add(T obj);
	public void delete(int id);
	public T getOne(int id);
	List<T>  getAll();
	//ObservableList<T> getAl();
	

}
