package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Program2 
{
	public static void main(String[] args) 
	{
		 try
         {
			 Class.forName("oracle.jdbc.driver.OracleDriver");	                   
             Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "root");
             Statement st = con.createStatement();
             
             ResultSet rs=st.executeQuery("select * from employee60");
             
             while(rs.next())
             {
            	 System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5)+"\t"+rs.getInt(6)+"\t"+rs.getInt(7));
             }
         }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	}
}
