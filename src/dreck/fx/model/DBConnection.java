package dreck.fx.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection 
{	
	
	private Connection c = null;
    private Statement stmt = null;
	
	public Connection openConnection(String DBName, String Password)
	{
		try {
	    	 //LOGIN to DB
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/Test",
	            DBName, Password);
	         c.setAutoCommit(false);
		     
	         System.out.println("Opened database successfully");
	         //LOGIN to DB
	         
	         
	        
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
		
		return c;
	}

}
