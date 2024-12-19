package com.Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test2 
{
	public static void main(String[] args)
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","0333");

			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from product60");
			
			while(rs.next())
			{
				System.out.println(rs.getLong(1)+"\t"+rs.getString(2)+"\t"+rs.getLong(3)+"\t"+rs.getLong(4));
			}
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
