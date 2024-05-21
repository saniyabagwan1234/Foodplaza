package com.cadd.foodplaza.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//DbUtility or DBConnection

public class DBUtility {

	//establishConnection() or getConnection()
	
	public static Connection establishConnection() throws ClassNotFoundException, SQLException
{
		String url,user,pass;
		url="jdbc:mysql://localhost:3306/foodplaza_saniya";
		user="root";
		pass="root";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection(url,user,pass);
		return con;
		
	}
}
