package application;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnection {
	
	//singleton
	private static DatabaseConnection singleConnection;
	
	private  static Connection databaseLink; 
	
	//params
	private static String databaseName = "";
	private static String databaseUser = "";
	private static String databasePassword= "";
	private static String url = "";
	
	
	private DatabaseConnection()
	{
		DatabaseConnection.databaseName = "testdm";
		DatabaseConnection.databaseUser = "root";
		DatabaseConnection.databasePassword = "root";
		DatabaseConnection.url = "jdbc:mariadb://localhost:3306/" + getDatabaseName();
		
		System.out.println("\t\tInstance creation ! ! !\n");
	}
	
	//Access Singleton
	public static DatabaseConnection getInstance()
	{
		if(singleConnection == null) 
		{
			singleConnection = new DatabaseConnection();
		}
		return singleConnection;
		
	}

	// connection
    public  Connection getConnection()
    {

        if(databaseLink==null)
        {
            try 
            {
				Class.forName("org.mariadb.jdbc.Driver");
				databaseLink = DriverManager.getConnection(getUrl(),getDatabaseUser(),getDatabasePassword());
				System.out.print("connecter dans la db\n");
				
				return databaseLink;
				
            } 
            catch(Exception e) 
            {
            	e.printStackTrace();
            	e.getCause();
            }
        }
		return databaseLink;
    }
	
	private static String getDatabaseName() {
		return databaseName;
	}

	private static String getDatabaseUser() {
		return databaseUser;
	}

	private static String getDatabasePassword() {
		return databasePassword;
	}

	private static String getUrl() {
		return url;
	}
}
