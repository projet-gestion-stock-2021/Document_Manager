package ctrlEntites;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.TreeSet;

import application.DatabaseConnection;
import entity.Reference;
import entity.Scan;

public class CtrlScan 
{
	private ArrayList<Scan> listeScanPath = new ArrayList<Scan>();
	private Connection connexion = DatabaseConnection.getInstance().getConnection();
	

	public ArrayList<Scan> getListeScanPath()
	{
		return listeScanPath;
	}



	public void setListeScanPath(ArrayList<Scan> listeScanPath)
	{
		this.listeScanPath = listeScanPath;
	}
	
	public void charger() throws SQLException 
	{
		CallableStatement fctCall = connexion.prepareCall("{call select_scan()}"); 
		ResultSet resultatRequete = fctCall.executeQuery();
		
		while(resultatRequete.next())
		{

			listeScanPath.add(new Scan(resultatRequete));
			
		}
	}

}
