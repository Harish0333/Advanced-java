package com.Test;

import java.sql.*;

public class DBCON1 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","0333");

			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from customer60");
			
			while(rs.next())
			{
				System.out.println(rs.getLong(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			}
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
