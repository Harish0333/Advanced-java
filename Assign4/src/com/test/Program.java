package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
	       try(s;){
	    	   try {
	    		   Class.forName("oracle.jdbc.driver.OracleDriver");
	    		   Connection con = DriverManager.getConnection
	    				   ("jdbc:oracle:thin:@localhost:1521:orcl","system","root");
	    		   PreparedStatement ps1 = con.prepareStatement
	    				   ("insert into student60 values(?,?,?,?,?,?)");//Compilation
	    		   PreparedStatement ps2 = con.prepareStatement
	    				   ("select * from student60");
	    		   PreparedStatement ps3 = con.prepareStatement
	    				   ("select * from student60 where rno=?");
	    		   PreparedStatement ps4 = con.prepareStatement
	    				   ("delete from student60 where rno=?");
	    		   while(true) 
	    		   {
	    			   System.out.println("*****Choice*****");
	    			   System.out.println("\t1.Add student details"
	    			   		+ "\n\t2.ViewAll student details"
	    			   		+ "\n\t3.ViewAll student details ByRollno"
	    			   		+ "\n\t4.Delete student details ByCode"
	    			   		+ "\n\t5.Exit");
	    			   System.out.println("Enter the Choice:");
	    			   int choice = s.nextInt();
	    			   switch(choice) 
	    			   {
	    			   case 1:
	    				   System.out.println("======Student Details======");
	    				   System.out.println("Enter the Student-Roll:");
	    				   int rno = s.nextInt();
	    				   s.nextLine();
	    				   System.out.println("Enter the Student-Name:");
	    				   String name = s.nextLine();
	    				   System.out.println("Enter the Branch-Name:");
	    				   String branch = s.nextLine();
	    				   System.out.println("Enter the student marks:");
	    				   int tmarks = s.nextInt();
	    				   double per = ((double)tmarks / 600) * 100;
	    				   String grade;
	    				 
	    				   if (per >= 90) {
	    					    grade = "A";
	    					} else if (per >= 80) {
	    					    grade = "B";
	    					} else if (per >= 70) {
	    					    grade = "C";
	    					} else {
	    					    grade = "D";
	    					}				      				  
	    				   //Loading data to PreparedStatement Object
	    				   ps1.setInt(1, rno);
	    				   ps1.setString(2, name);
	    				   ps1.setString(3, branch);
	    				   ps1.setInt(4, tmarks);
	    				   ps1.setDouble(5, per);
	    				   ps1.setString(6, grade);
	    				   
	    				   int k = ps1.executeUpdate();//Execution of query with values
	    				   if(k>0) 
	    				   {
	    					   System.out.println("Student Added Succesfully...");
	    				   }
	    				   break;
	    			   case 2:
	    				   ResultSet rs = ps2.executeQuery();
	    				   System.out.println("******Student Details*****");
	    				   while(rs.next()) 
	    				   {
	    					   System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+rs.getString(3)
					           +"\t"+rs.getInt(4)+"\t"+rs.getInt(5)+"\t"+rs.getString(6));
	    				   }
	    				   break;
	    			   case 3:
	    				   System.out.println("Enter the Book-Code to view details:");
	    				   int pC = s.nextInt();
	    				   
	    				   ps3.setInt(1, pC);
	    				   ResultSet rs2 = ps3.executeQuery();
	    				   if(rs2.next()) 
	    				   {
	    					   System.out.println(rs2.getInt(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3)
						        +"\t"+rs2.getInt(4)+"\t"+rs2.getInt(5));
	    				   }
	    				   else 
	    				   {
	    					   System.out.println("Invalid Book Code....");
	    				   }
	    				   break;
	    			   case 4:
	    				   System.out.println("Enter the Book-Code to perform Update Operation:");
	    				   int pC2 = s.nextInt();
	    				   ps3.setInt(1, pC2);
	    				   ResultSet rs3 = ps3.executeQuery();
	    				   if(rs3.next()) 
	    				   {
	    					   System.out.println("Old Book-Price:"+rs3.getInt(4));
	    					   System.out.println("Enter the New price for Book:");
	    					   int nPrice = s.nextInt();
	    					   System.out.println("Existing Book Qty:"+rs3.getInt(5));
	    					   System.out.println("Enter the new qty:(stock)");
	    					   int nQty = s.nextInt();
	    					   
	    					   ps4.setInt(1, nPrice);
	    					   ps4.setInt(2, nQty);
	    					   ps4.setInt(3, pC2);
	    					   
	    					   int k2 = ps4.executeUpdate();
	    					   if(k2>0) {
	    						   System.out.println("Book Updated Successfully....");
	    					   }
	    				   }else {
	    					   System.out.println("Invalid Book-Code...");
	    				   }
	    				   break;
	    			   case 5:
	    				   System.out.println("Enter the Book-Code to delete product:");
	    				   int pC3 = s.nextInt();
	    				   ps3.setInt(1, pC3);
	    				   ResultSet rs4 = ps3.executeQuery();
	    				   if(rs4.next()) 
	    				   {
	    					   ps4.setInt(1, pC3);
	    					   int k3 = ps4.executeUpdate();
	    					   if(k3>0) {
	    						   System.out.println("Book deleted Successfully...");
	    					   }
	    				   }else {
	    					   System.out.println("Invalid Book-Code...");
	    				   }
	    				   break;
	    			   case 6:
	    				   System.out.println("Operation Stopped....");
	    				   System.exit(0);
	    			   default:
	    				   System.out.println("Invalid Choice...");
	    			   }//end of switch
	    		   }//end of loop
	    	   }catch(Exception e) {e.printStackTrace();}
	       }//end of try

	}

}
