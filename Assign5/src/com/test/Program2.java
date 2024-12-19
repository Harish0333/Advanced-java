package com.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;
/*
 * create or replace procedure RetrieveCust60
	(acno number,nam OUT varchar2,bal OUT number,actyp OUT varchar2,cty OUT varchar2,
	st OUT varchar2,pcode OUT number,md OUT varchar2,pno OUT number) is
	begin
	Select cname,bal,acctype into nam,bal,actyp from custData60 where accno=acno;
	Select city,state,pincode into cty,st,pcode from  custAddress60 where accno=acno;
	Select mid,phno into md,pno from custContact60 where accno=acno;
	end;
	/
*/
public class Program2 
{
	public static void main(String[] args) 
	{
        Scanner s = new Scanner(System.in);
        try(s;)
        {
        	try 
        	{
        		Class.forName("oracle.jdbc.driver.OracleDriver");
        		Connection con = DriverManager.getConnection
        				("jdbc:oracle:thin:@localhost:1521:orcl","system","root");
        		CallableStatement cs = con.prepareCall
        			("{call RetrieveCust60(?,?,?,?,?,?,?,?,?)}");
        		System.out.println("Enter the Customer-Account details to display details:");
         		String id = s.nextLine();
         		cs.setString(1, id);
         		cs.registerOutParameter(2, Types.VARCHAR);//name
         		cs.registerOutParameter(3, Types.INTEGER);//bal
         		cs.registerOutParameter(4, Types.VARCHAR);//actype
         		cs.registerOutParameter(5, Types.VARCHAR);//cty
         		cs.registerOutParameter(6, Types.VARCHAR);//st
         		cs.registerOutParameter(7, Types.INTEGER);//pcode
         		cs.registerOutParameter(8, Types.VARCHAR);//md
         		cs.registerOutParameter(9, Types.LONGNVARCHAR);//phno 		
         		cs.execute();//Procedure
         		
         		System.out.println("Cust-Acc:"+id);
         		System.out.println("Cust-Name:"+cs.getString(2));
         		System.out.println("Cust-Bsal:"+cs.getInt(3));
         		System.out.println("Cust-AccType:"+cs.getString(4));
         		System.out.println("Cust-City:"+cs.getString(5));
         		System.out.println("Cust-State:"+cs.getString(6));
         		System.out.println("Cust-PinCode:"+cs.getInt(7));
         		System.out.println("Cust-MID:"+cs.getString(8));
         		System.out.println("Cust-PhoneNo:"+cs.getLong(9));
         	         	System.out.println("\n**********************************");
         		con.close();
           	}
        	catch(Exception e)
        	{
        		e.printStackTrace();
        	}
        }
	}       		
}
