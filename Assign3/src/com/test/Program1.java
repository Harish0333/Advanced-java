package com.test;

import java.sql.*;
import java.util.Scanner;

public class Program1
{
	public static void main(String []args)
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
	    				   ("insert into bookdetails60 values(?,?,?,?,?)");//Compilation
	    		   PreparedStatement ps2 = con.prepareStatement
	    				   ("select * from bookdetails60");
	    		   PreparedStatement ps3 = con.prepareStatement
	    				   ("select * from bookdetails60 where code=?");
	    		   PreparedStatement ps4 = con.prepareStatement
	    				   ("update bookdetails60 set price=?,qty=qty+? where code=?");
	    		   PreparedStatement ps5 = con.prepareStatement
	    				   ("delete from bookdetails60 where code=?");
	    		   while(true) 
	    		   {
	    			   System.out.println("*****Choice*****");
	    			   System.out.println("\t1.Add Book details"
	    			   		+ "\n\t2.ViewAllBook details"
	    			   		+ "\n\t3.ViewAllBook detailsByCode"
	    			   		+ "\n\t4.UpdateBook detailstByCode(price-qty)"
	    			   		+ "\n\t5.DeleteBook detailsByCode"
	    			   		+ "\n\t6.Exit");
	    			   System.out.println("Enter the Choice:");
	    			   int choice = s.nextInt();
	    			   switch(choice) 
	    			   {
	    			   case 1:
	    				   System.out.println("======Book Details======");
	    				   
	    				   System.out.println("Enter the Book-Code:");
	    				   int code = s.nextInt();
	    				   s.nextLine(); 
	    				   System.out.println("Enter the Book Author-Name:");
	    				   String Author = s.nextLine();
	    				   
	    				   System.out.println("Enter the Book Name:");
	    				   String Name = s.nextLine();
	    				   
	    				   System.out.println("Enter the Book-Price:");
	    				   int price = Integer.parseInt(s.nextLine());
	    				  
	    				   System.out.println("Enter the Book-Qty:");
	    				   int qty = Integer.parseInt(s.nextLine());
	    				   
	    				   //Loading data to PreparedStatement Object
	    				   ps1.setInt(1, code);
	    				   ps1.setString(2, Name);
	    				   ps1.setString(3, Author);
	    				   ps1.setInt(4, price);
	    				   ps1.setInt(5, qty);
	    				   
	    				   int k = ps1.executeUpdate();//Execution of query with values
	    				   if(k>0) 
	    				   {
	    					   System.out.println("Book Added Succesfully...");
	    				   }
	    				   break;
	    			   case 2:
	    				   ResultSet rs = ps2.executeQuery();
	    				   System.out.println("******Book Details*****");
	    				   while(rs.next()) {
	    					   System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+rs.getString(3)
   					           +"\t"+rs.getInt(4)+"\t"+rs.getInt(5));
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
	    				   }
	    				   else
	    				   {
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
	    					   ps5.setInt(1, pC3);
	    					   int k3 = ps5.executeUpdate();
	    					   if(k3>0)
	    						   System.out.println("Book deleted Successfully...");
	    				   }
	    				   else
	    					   System.out.println("Invalid Book-Code...");
	    				   
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
