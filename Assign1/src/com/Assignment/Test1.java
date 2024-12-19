package com.Assignment;

import java.sql.*;
import java.util.Scanner;

public class Test1 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);   
        try (sc;)
        {
        	 try
             {
             	   System.out.println("Enter product code");
                   int code = sc.nextInt();

                   System.out.println("Enter product name");
                   String name = sc.next();

                   System.out.println("Enter product price");
                   int price = sc.nextInt();

                   System.out.println("Enter product quantity");
                   int qty = sc.nextInt();
                   
                   Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "root");
                   Statement st = con.createStatement();
                   
                   int k = st.executeUpdate("insert into product60 VALUES ("+code+",'"+name+"','"+price+"','"+qty+"')");
                   
                   if(k>1)
                   {
                	   System.out.println("Successfully inserted");
                   }
                   con.close();
             }
             catch(Exception e)
             {
             	e.printStackTrace();
             }
        }
    }
}
