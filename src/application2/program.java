package application2;

import java.util.List;

import javafx.collections.ObservableList;

public class program {

	public static void main(String[] args) {
		
		  IUtilisateurDAO udao=new UtilisateurDaoImpl();
		  
		  System.out.println("--------------getAll------------");
		 List<Utilisateur> list=udao.getAll();
		  for(Utilisateur u: list) 
			 System.out.println(u.toString());
		  
			
			  System.out.println("--------------getOne()------------"); Utilisateur
			  u=udao.getOne(5); System.out.println(u.toString());
			 
			//  udao.add(new Utilisateur("Descy","Nina","Nina","Secret"));
	
			 
		 
		
	}

}
