package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnection {
	 String databaseName = "testdm";
	  String databaseUser = "root";
	  String databasePassword= "Youssef12";
	  String url = "jdbc:mariadb://localhost:3306/" + databaseName;
	  private static Connection connection=null;
	  private SingleConnection() {
		  
		  try {
			connection=DriverManager.getConnection(url,databaseUser,databasePassword);
			System.out.println("instance créée");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	  }
	  public static Connection getConnection()
	  { 
		if(connection==null) 
			new SingleConnection();
		return connection;
		  
	  }
}
