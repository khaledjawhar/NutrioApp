package com.khaled;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginHandler {
	Connection con;
	PreparedStatement preStatement;
	ResultSet rs;  
	 public Boolean checkLogin(String name,String password)
	 {
	        try {
	        	DataBase db= new DataBase();    
	        	con=db.connect(); 
	        	preStatement = con.prepareStatement("SELECT * FROM nutriodb.registration where name=? and password=?");
	        	preStatement.setString(1, name); //this replaces the 1st  "?" in the query for username
	        	preStatement.setString(2, password);    //this replaces the 2st  "?" in the query for password
	            //executes the prepared statement
	            rs=preStatement.executeQuery();
	            if(rs.next())
	            {
	                //TRUE iff the query founds any corresponding data
	                return true;
	            }
	            else
	            {
	                return false;
	            }
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            System.out.println("error while validating"+e);
	            return false;
	        }
	        finally 
			{  
			   if( con != null )
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
			}
	}
	
}
