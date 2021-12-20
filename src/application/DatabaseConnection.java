package application;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnection {
	
	public Connection databaseLink;
	
	public Connection getConnection() {
		String databaseName = "examcauwen";
		String databaseUser = "root";
		String databasePassword= "Leahpar7";
		String url = "jdbc:mariadb://localhost:3306/" + databaseName;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
			System.out.print("connecter dans la db");
		}catch(Exception e) {
			e.printStackTrace();
			e.getCause();
		}
		
		return databaseLink;
		
	}

}
