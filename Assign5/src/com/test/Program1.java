package com.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
	/*	create or replace procedure Insertcust60
		(acno varchar2,nm varchar2,bal number,acty varchar2,cty varchar2,
		st varchar2,pcode number,md varchar2,pno number) is
		begin
   		insert into custData60 values(acno,nm,bal,acty);
   		insert into custAddress60 values(acno,cty,st,pcode);
   		insert into custContact60 values(acno,md,pno);
		end;
		/
	 */
public class Program1 
{
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try(s;){
        	try {
        		Class.forName("oracle.jdbc.driver.OracleDriver");
        		Connection con = DriverManager.getConnection
        				("jdbc:oracle:thin:@localhost:1521:orcl","system","root");
        		CallableStatement cs = con.prepareCall
        			("{call InsertCust60(?,?,?,?,?,?,?,?,?)}");
        		
        		System.out.println("Enter the Cust-Acno:");
        		String cno = s.nextLine();
        		System.out.println("Enter the Cust-Name:");
        		String cname = s.nextLine();
        		System.out.println("Enter the Cust-BSal:");
        		int bSal = s.nextInt();
        		s.nextLine();
        		System.out.println("Enter the Cust-Acctype:");
        		String catyp = s.nextLine();
        		
        		System.out.println("Enter the Cust-City:");
        		String city = s.nextLine();
        		System.out.println("Enter the Cust-State:");
        		String state = s.nextLine();
        		System.out.println("Enter the Cust-PinCode:");
        		int pinCode = Integer.parseInt(s.nextLine());
        		System.out.println("Enter the Cust-MId:");
        		String mId = s.nextLine();
        		System.out.println("Enter the Cust-PhoneNo:");
        		long phNo = Long.parseLong(s.nextLine());
        		
                cs.setString(1, cno);
                cs.setString(2, cname);
                cs.setInt(3, bSal);
                cs.setString(4, catyp);
                cs.setString(5, city);
                cs.setString(6, state);
                cs.setInt(7, pinCode);
                cs.setString(8, mId);
                cs.setLong(9, phNo);
                               
                cs.execute();//Procedure executed with IN Parameter Values
                System.out.println("Customer details stored Successfully...");
        	}catch(Exception e) {e.printStackTrace();}
        }//end of try with resource
	}
}
