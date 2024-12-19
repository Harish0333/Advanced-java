package com.test;

import java.io.*;
import java.sql.*;
import java.util.*;

public class CSV_File 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException ,IOException
	{
		Connection con=null;
		try 
		{
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","root");
			PreparedStatement ps=con.prepareStatement("insert into data values(?,?,?,?)");
			FileInputStream fis=new FileInputStream("E:\\Advance java\\Data.csv");
			Scanner s=new Scanner(fis);
			s.nextLine();
			while(s.hasNext())
			{
				String str[]=s.nextLine().split(",");
				for(int i=1;i<=4;i++)
				{
					ps.setString(i,str[i-1]);
				}
			    ps.executeUpdate();
			 }
			  System.out.println("Record Inserted SuccessFully.....");  
			  con.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}	
	

