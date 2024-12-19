package com.Test;
	import java.util.*;
	import java.sql.*;
	public class DBCon7 
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
	        		PreparedStatement ps1 = con.prepareStatement
	        		("select * from Bank60 where accno=?");
	        		PreparedStatement ps2 = con.prepareStatement
	        		("update Bank60 set bal=bal+? where accNo=?");
	        		System.out.println("Commit status:"+con.getAutoCommit());
	        		con.setAutoCommit(false);
	        		System.out.println("Commit status:"+con.getAutoCommit());
	        		Savepoint sp = con.setSavepoint();
	        		System.out.println("Enter the HomeAccNo:");
	        		long hAccNo = s.nextLong();
	        		ps1.setLong(1, hAccNo);
	        		ResultSet rs1 = ps1.executeQuery();
	        		if(rs1.next()) 
	        		{
	        			float bl = rs1.getFloat(3);
	        			System.out.println("Enter the beneficiery AccNo:");
	        			long bAccNo = s.nextLong();
	        			ps1.setLong(1, bAccNo);
	        			ResultSet rs2 = ps1.executeQuery();
	        			if(rs2.next()) 
	        			{
	        				System.out.println("Enter the amount to transfer:");
	        				float amt = s.nextFloat();
	        				if(amt<=bl) {
	        					ps2.setFloat(1,-amt);
	        					ps2.setLong(2, hAccNo);
	        					int x = ps2.executeUpdate();
	        					            //Buffer is updated
	        					ps2.setFloat(1, +amt);
	        					ps2.setLong(2, bAccNo);
	        					int y = ps2.executeUpdate();
	        					            //Buffer is updated
	        					if(x==1 && y==1) 
	        					{
	        						System.out.println("Transaction Successfull...");
	        						con.commit();//Updated database
	        					}else 
	        					{
	        						System.out.println("Transaction failed...");
	        						con.rollback(sp);
	        					}
	        				}else {
	        					System.out.println("Insufficient fund...");
	        				}
	        			}else {
	        				System.out.println("Invalid bAccNo...");
	        			}
	        		}else {
	        			System.out.println("Invalid home AccNo...");
	        		}
	        	}catch(Exception e) {e.printStackTrace();}
	        }//end of try with resource
		}
	}


