package com.Test;

import java.sql.*;
import java.util.Scanner;

public class DBCON4 
{
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try(s;){
        	try {
        		Class.forName("oracle.jdbc.driver.OracleDriver");
        		Connection con = DriverManager.getConnection
        				("jdbc:oracle:thin:@localhost:1521:orcl","system","root");
        		CallableStatement cs = con.prepareCall
        			("{call InsertEmp60(?,?,?,?,?,?,?,?,?,?,?,?)}");
        		
        		System.out.println("Enter the Emp-Id:");
        		String eId = s.nextLine();
        		System.out.println("Enter the Emp-Name:");
        		String eName = s.nextLine();
        		System.out.println("Enter the Emp-Desg:");
        		String eDesg = s.nextLine();
        		System.out.println("Enter the Emp-City:");
        		String city = s.nextLine();
        		System.out.println("Enter the Emp-State:");
        		String state = s.nextLine();
        		System.out.println("Enter the Emp-PinCode:");
        		int pinCode = Integer.parseInt(s.nextLine());
        		System.out.println("Enter the Emp-MId:");
        		String mId = s.nextLine();
        		System.out.println("Enter the Emp-PhoneNo:");
        		long phNo = Long.parseLong(s.nextLine());
        		System.out.println("Enter the Emp-BSal:");
        		int bSal = Integer.parseInt(s.nextLine());
        		float hra = 0.93F*bSal;
        		float da = 0.61F*bSal;
                float totSal = bSal+hra+da;
                
                cs.setString(1, eId);
                cs.setString(2, eName);
                cs.setString(3, eDesg);
                cs.setString(4, city);
                cs.setString(5, state);
                cs.setInt(6, pinCode);
                cs.setString(7, mId);
                cs.setLong(8, phNo);
                cs.setInt(9, bSal);
                cs.setFloat(10, hra);
                cs.setFloat(11, da);
                cs.setFloat(12, totSal);
                
                cs.execute();//Procedure executed with IN Parameter Values
                System.out.println("Employee details stored Successfully...");
        	}catch(Exception e) {e.printStackTrace();}
        }//end of try with resource
	}

}
