package com.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Program1 
{
	public static void main(String[] args) 
	{
		 Scanner sc = new Scanner(System.in);   

	        try (sc;) 
	        {
	        	 try
	             {
	             	  System.out.println("Enter Employee ID :");
	                   int id = sc.nextInt();

	                   System.out.println("Enter Ename");
	                   String ename = sc.next();

	                   System.out.println("Enter Edesignation");
	                   String edesign = sc.next();

	                   System.out.println("Enter Employee salary");
	                   int bsal = sc.nextInt();	                     
	                   int da=(int) (0.61*bsal);
	                   int hra=(int) (0.93*bsal);
	                   int totsal=(int) (hra+da+bsal);
	                   
	                   Class.forName("oracle.jdbc.driver.OracleDriver");	                   
	                   Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "root");
	                   
	                   Statement st = con.createStatement();
	                   int k = st.executeUpdate("insert into employee60 values ("+id+",'"+ename+"','"+edesign+"','"+bsal+"','"+hra+"','"+da+"','"+totsal+"')");	                   
	                   if(k>0)
	                	   System.out.println("One record Successfully inserted....!!!");
	                   
	                   con.close();
	             }
	             catch(Exception e)
	             {
	             	e.printStackTrace();
	             }
	        }
	 }
}
