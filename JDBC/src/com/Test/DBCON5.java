package com.Test;

import java.sql.*;
import java.util.Scanner;
public class DBCON5 
{
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try(s;){
       	 try {
       		 Class.forName("oracle.jdbc.driver.OracleDriver");
        		Connection con = DriverManager.getConnection
        				("jdbc:oracle:thin:@localhost:1521:orcl","system","root");
        		CallableStatement cs = con.prepareCall
        				("{call RetrieveEmp60(?,?,?,?,?,?,?,?,?,?,?,?)}");
        		System.out.println("Enter the Emp-Id to display details:");
        		String id = s.nextLine();
        		cs.setString(1, id);
        		cs.registerOutParameter(2, Types.VARCHAR);
        		cs.registerOutParameter(3, Types.VARCHAR);
        		cs.registerOutParameter(4, Types.VARCHAR);
        		cs.registerOutParameter(5, Types.VARCHAR);
        		cs.registerOutParameter(6, Types.INTEGER);
        		cs.registerOutParameter(7, Types.VARCHAR);
        		cs.registerOutParameter(8, Types.BIGINT);
        		cs.registerOutParameter(9, Types.INTEGER);
        		cs.registerOutParameter(10, Types.FLOAT);
        		cs.registerOutParameter(11, Types.FLOAT);
        		cs.registerOutParameter(12, Types.FLOAT);
        		
        		cs.execute();//Procedure
        		
        		System.out.println("Emp-Id:"+id);
        		System.out.println("Emp-Name:"+cs.getString(2));
        		System.out.println("Emp-Desg:"+cs.getString(3));
        		System.out.println("Emp-City:"+cs.getString(4));
        		System.out.println("Emp-State:"+cs.getString(5));
        		System.out.println("Emp-PinCode:"+cs.getInt(6));
        		System.out.println("Emp-MID:"+cs.getString(7));
        		System.out.println("Emp-PhoneNo:"+cs.getLong(8));
        		System.out.println("Emp-Bsal:"+cs.getInt(9));
        		System.out.println("Emp-HRA:"+cs.getFloat(10));
        		System.out.println("Emp-DA:"+cs.getFloat(11));
        		System.out.println("Emp-TotSal:"+cs.getFloat(12));
        		
        		con.close();
        		
       	 }catch(Exception e) {e.printStackTrace();}
        }//end of try with resource
	}

}
