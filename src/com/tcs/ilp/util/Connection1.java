package com.tcs.ilp.util;
import java.sql.*;


public class Connection1 {
	static Connection con=null;
	//static String url="jdbc:oracle:thin:@localhost:1521:xe",username="ilp",password="ilp";
	static String url="jdbc:oracle:thin:@172.25.192.71:1521:javadb", username="h01orauser1d", password="tcshyd";
	
	public static Connection getMyConnection() throws Exception
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			con= DriverManager.getConnection(url,username,password);
            
	}	
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return con;
		
	}
	
}