package com.test;
/*create or replace function RetrieveCustBal60
(ano varchar2) return number as balance number;
begin
select bal into balance from custdata60 where accno=ano;
return balance;
end;
/*/
import java.sql.*;
import java.util.Scanner;

public class Program 
{
	public static void main(String[] args) 
	{
	       Scanner s = new Scanner(System.in);
	       try(s;)
	       {
	    	   try {
	    		   Class.forName("oracle.jdbc.driver.OracleDriver");
	       		Connection con = DriverManager.getConnection
	       				("jdbc:oracle:thin:@localhost:1521:orcl","system","root");
	       		CallableStatement cs = con.prepareCall
	       		("{call ?:=RetrieveCustBal60(?)}");
	       		
	       		System.out.println("Enter the Cust AC no to retrieve Balance:");
	       		String acno = s.nextLine();
	       		
	       		cs.registerOutParameter(1, Types.FLOAT);
	       		cs.setString(2, acno);
	       		cs.execute();
	       		System.out.println("Customer-Ac no:"+acno);
	       		System.out.println("Customer-Bal:"+cs.getFloat(1));
	       		con.close();
	    	   }
	    	   catch(Exception e)
	    	   {
	    		   e.printStackTrace();
	    	   }
	       }//end of try with resource
	}
}

