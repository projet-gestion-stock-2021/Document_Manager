package application2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//classe qui herite de la classe absraite connection et implemente l'interface pour redéfinir les metthodes
public class UtilisateurDaoImpl extends AbstractDAO implements IUtilisateurDAO {

	@Override
	public void add(Utilisateur u) {
		PreparedStatement pst;
		ResultSet rs;
		String sql="(insert into utilistaeur(Nom,Prenom,Login,Mdp) values(?,?,?,?)";
		
		try {
			 pst=connection.prepareStatement(sql);
			 pst.setString(1,u.getNom());
			 pst.setString(1,u.getPrenom());
			 pst.setString(1,u.getLogin());
			 pst.setString(1,u.getMdp());
			System.out.println("succes d'exce de la connection");
			rs=pst.executeQuery();
			pst.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur getOne(int id) {
		PreparedStatement pst=null;
		ResultSet rs;
		String sql="select * from utilisateur where Id_Utilisateur=?";
		try {
			 pst=connection.prepareStatement(sql);
			 pst.setInt(1, id);
			System.out.println("succes d'exce de la connection");
			rs=pst.executeQuery();
			if(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
				return new Utilisateur(rs.getInt("Id_Utilisateur"),rs.getString("Nom"),rs.getString("Prenom"),rs.getString("Login"),rs.getString("Mdp"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Utilisateur> getAll(){
	//public ObservableList<Utilisateur> getAl(){
			List<Utilisateur>  list =new ArrayList<Utilisateur>();
		//ObservableList<Utilisateur> list =FXCollections.observableArrayList();
			PreparedStatement pst=null;
			ResultSet rs;
			String sql="select * from utilisateur";
			try {
				 pst=connection.prepareStatement(sql);
				System.out.println("succes d'exce de la connection");
				rs=pst.executeQuery();
				while(rs.next())
				{
					
					  //System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "
					 // +rs.getString(4));
					 
					
					  Utilisateur u =new Utilisateur(rs.getInt(1), rs.getString(2),
					  rs.getString(3), rs.getString(4), rs.getString(5));
					  
					  list.add(u);
				}
				pst.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return list;
		
		
	}

	
	/*
	 * @Override public List<Utilisateur> getAll(String nom) { // TODO
	 * Auto-generated method stub return null; }
	 */
	

}
