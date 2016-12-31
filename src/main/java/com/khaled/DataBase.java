package com.khaled;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

public class DataBase {
public Connection connect(){
	Connection con;
	Properties prop = new Properties();
	InputStream input = null;
	try{
		input = new FileInputStream("src/main/resources/config.properties");
		prop.load(input);
		String dbUrl=prop.getProperty("dbUrl");
		int dbPort=Integer.parseInt(prop.getProperty("dbPort"));
		String dbUser=prop.getProperty("dbUser");
		String dbPassword=prop.getProperty("dbPassword");
		String dbName=prop.getProperty("dbName");
        con=DriverManager.getConnection("jdbc:mysql://"+ dbUrl +":"+dbPort+"/"+dbName,dbUser,dbPassword); 
        return con;
       }
    catch (Exception e) 
    {
        System.out.println(e);
    }
	return null;
}
}
