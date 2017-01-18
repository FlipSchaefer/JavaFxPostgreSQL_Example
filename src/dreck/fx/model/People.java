package dreck.fx.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class People 
{
	private Statement stmt = null;
	private Connection c = null;
	
	private int id;
	private String name;
	
	public People(Connection c)
	{
		this.c = c;
	}

	public void insertPerson(int ID, String Name)
	{
		try {
			stmt = c.createStatement();
			String sql = "INSERT INTO PEOPLE (ID,NAME) " + "VALUES (" +ID+ ", '" +Name+ " ');";
			stmt.executeUpdate(sql);
			
			stmt.close();
	        c.commit();
	        c.close();
		}
		catch (Exception e) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
		}
		
		System.out.println("Insertion done successfully with ID="+ID+" and Name="+Name);
		
	}
	
	public ResultSet selectAllPerson()
	{
		try
		{
			
			stmt = c.createStatement();
	        ResultSet rs = stmt.executeQuery( "SELECT * FROM PEOPLE;" );
	        while ( rs.next() ) {
	           id = rs.getInt("id");
	           name = rs.getString("name");
	           System.out.println( "ID = " + id );
	           System.out.println( "NAME = " + name );

	           System.out.println();
	        	return rs;
	        }
	        rs.close();
	        stmt.close();
	        c.close();
      } 
	catch ( Exception e ) {
        System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        System.exit(0);
        return null;
      }
		
      System.out.println("Selection done successfully");
	return null;
      
	}
	
	public void deletePerson(int ID, String Name)
	{
		if(ID == 0){
			try
			{
				 stmt = c.createStatement();
		         String sql = "DELETE from PEOPLE where NAME="+Name+";";
		         stmt.executeUpdate(sql);
		         c.commit();
		
		         ResultSet rs = stmt.executeQuery( "SELECT * FROM PEOPLE;" );
		         while ( rs.next() ) {
		            int id = rs.getInt("id");
		            String  name = rs.getString("name");
		            System.out.println( "ID = " + id );
		            System.out.println( "NAME = " + name );
		
		            System.out.println();
		         }
		         rs.close();
		         stmt.close();
		         c.close();
		       } catch ( Exception e ) {
		         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		         System.exit(0);
		       }
		       System.out.println("Deletion done successfully with Name=" + Name);
		}
		else {
			
			try
			{
				 stmt = c.createStatement();
		         String sql = "DELETE from PEOPLE where ID="+ID+";";
		         stmt.executeUpdate(sql);
		         c.commit();
		
		         ResultSet rs = stmt.executeQuery( "SELECT * FROM PEOPLE;" );
		         while ( rs.next() ) {
		            int id = rs.getInt("id");
		            String  name = rs.getString("name");
		            System.out.println( "ID = " + id );
		            System.out.println( "NAME = " + name );
		
		            System.out.println();
		         }
		         rs.close();
		         stmt.close();
		         c.close();
		       } catch ( Exception e ) {
		         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		         System.exit(0);
		       }
		       System.out.println("Deletion done successfully with ID=" + ID);
		}
		
	}
	
	public void updatePeople (int ID, String Name)
	{
		try
		{
			 stmt = c.createStatement();
	         String sql = "UPDATE PEOPLE set NAME = '" + Name + "' where ID="+ID+";";
	         stmt.executeUpdate(sql);
	         c.commit();

	         ResultSet rs = stmt.executeQuery( "SELECT * FROM PEOPLE;" );
	         while ( rs.next() ) {
	            int id = rs.getInt("id");
	            String  name = rs.getString("name");

	            System.out.println( "ID = " + id );
	            System.out.println( "NAME = " + name );
	            System.out.println();
	         }
	         rs.close();
	         stmt.close();
	         c.close();
	    } 
		catch ( Exception e ) 
		{
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	       }
		
	    System.out.println("Updating of ID's=" + ID + " NAME=" +Name+ " done successfully");
	}
	
}
