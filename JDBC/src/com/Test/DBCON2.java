package com.Test;
import java.sql.*;
import java.util.Scanner;

public class DBCON2 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			try 
			{
				System.out.println("Enter the Cust-PhoneNO:");
        		long phno = Long.parseLong(sc.nextLine());
        		System.out.println("Enter the Cust-Name:");
        		String name = sc.nextLine();
        		System.out.println("Enter the Cust-City:");
        		String city = sc.nextLine();
        		System.out.println("Enter the Cust-MailId:");
        		String mId = sc.nextLine();

				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","root");
				Statement st = con.createStatement();
				
				int k = st.executeUpdate("insert into Customer60 values("+phno+",'"+name+"','"+city+"','"+mId+"')");
				if(k>0) 
				{
        			System.out.println("Customer Added Successfully....");
        		}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}//try resources
	}
}
