package application;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnection {
	
	public Connection databaseLink;
	
	public Connection getConnection() {
		String databaseName = "";
		String databaseUser = "";
		String databasePassword= "";
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
