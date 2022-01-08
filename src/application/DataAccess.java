package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entites.Utilisateur;

public class DataAccess {
	 String databaseName = "testdm";
	  String databaseUser = "root";
	  String databasePassword= "Youssef12";
	  String url = "jdbc:mariadb://localhost:3306/" + databaseName;
	  Connection connection=null;
	  public  DataAccess()
	  {try {
		  connection=DriverManager.getConnection(url,databaseUser,databasePassword);
		  System.out.println("connecte");
	  }catch(SQLException e) {
	  e.printStackTrace();}
	  }
	List <Utilisateur>  getAll()
	{
		List<Utilisateur>  list =new ArrayList<Utilisateur>();
		PreparedStatement pst=null;
		ResultSet rs;
		String sql="select * from utilisateur";
		try {
			 pst=connection.prepareStatement(sql);
			System.out.println("succes d'exce de la connection");
			rs=pst.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
				list.add(new Utilisateur(rs.getInt("Id_Utilisateur"),rs.getString("Nom"),rs.getString("Prenom"),rs.getString("Login"),rs.getString("Mdp")));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	List <Utilisateur>  getUtilistaeurByKeyWord(int id)
	{
		List<Utilisateur>  list =new ArrayList<Utilisateur>();
		PreparedStatement pst=null;
		ResultSet rs;
		String sql="select * from utilisateur where Id_Utilisateur=? ";
		try {
			 pst=connection.prepareStatement(sql);
			 pst.setInt(1,id);
			System.out.println("succes d'exce de la connection");
			rs=pst.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
				list.add(new Utilisateur(rs.getInt("Id_Utilisateur"),rs.getString("Nom"),rs.getString("Prenom"),rs.getString("Login"),rs.getString("Mdp")));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
		  
 }


