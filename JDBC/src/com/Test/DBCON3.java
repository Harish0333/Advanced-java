package com.Test;

import java.sql.Connection;
import java.sql.*;
import java.util.Scanner;

public class DBCON3 
{
	public static void main(String[] args) 
	{
       Scanner s = new Scanner(System.in);
       try(s;){
    	   try {
    		   Class.forName("oracle.jdbc.driver.OracleDriver");
    		   Connection con = DriverManager.getConnection
    				   ("jdbc:oracle:thin:@localhost:1521:orcl","system","root");
    		   PreparedStatement ps1 = con.prepareStatement
    				   ("insert into Product60 values(?,?,?,?)");//Compilation
    		   PreparedStatement ps2 = con.prepareStatement
    				   ("select * from Product60");
    		   PreparedStatement ps3 = con.prepareStatement
    				   ("select * from Product60 where code=?");
    		   PreparedStatement ps4 = con.prepareStatement
    				   ("update Product60 set price=?,qty=qty+? where code=?");
    		   PreparedStatement ps5 = con.prepareStatement
    				   ("delete from Product60 where code=?");
    		   while(true) {
    			   System.out.println("*****Choice*****");
    			   System.out.println("\t1.AddProduct"
    			   		+ "\n\t2.ViewAllProducts"
    			   		+ "\n\t3.ViewProductByCode"
    			   		+ "\n\t4.UpdateProductByCode(price-qty)"
    			   		+ "\n\t5.DeleteProductByCode"
    			   		+ "\n\t6.Exit");
    			   System.out.println("Enter the Choice:");
    			   int choice = Integer.parseInt(s.nextLine());
    			   switch(choice) {
    			   case 1:
    				   System.out.println("======ProductDetails======");
    				   System.out.println("Enter the Prod-Code:");
    				   String code = s.nextLine();
    				   System.out.println("Enter the Prod-Name:");
    				   String name = s.nextLine();
    				   System.out.println("Enter the Prod-Price:");
    				   float price = Float.parseFloat(s.nextLine());
    				   System.out.println("Enter the Prod-Qty:");
    				   int qty = Integer.parseInt(s.nextLine());
    				   
    				   //Loading data to PreparedStatement Object
    				   ps1.setString(1, code);
    				   ps1.setString(2, name);
    				   ps1.setFloat(3, price);
    				   ps1.setInt(4, qty);
    				   
    				   int k = ps1.executeUpdate();//Execution of query with values
    				   if(k>0) {
    					   System.out.println("Product Added Succesfully...");
    				   }
    				   break;
    			   case 2:
    				   ResultSet rs = ps2.executeQuery();
    				   System.out.println("******ProductDetails*****");
    				   while(rs.next()) {
    					   System.out.println(rs.getString(1)+"\t"+rs.getString(2)
    					        +"\t"+rs.getFloat(3)+"\t"+rs.getInt(4));
    				   }
    				   break;
    			   case 3:
    				   System.out.println("Enter the Prod-Code to view details:");
    				   String pC = s.nextLine();
    				   
    				   ps3.setString(1, pC);
    				   ResultSet rs2 = ps3.executeQuery();
    				   if(rs2.next()) {
    					   System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)
					        +"\t"+rs2.getFloat(3)+"\t"+rs2.getInt(4));
    				   }else {
    					   System.out.println("Invalid Product Code....");
    				   }
    				   break;
    			   case 4:
    				   System.out.println("Enter the Prod-Code to perform Update Operation:");
    				   String pC2 = s.nextLine();
    				   ps3.setString(1, pC2);
    				   ResultSet rs3 = ps3.executeQuery();
    				   if(rs3.next()) {
    					   System.out.println("Old Prod-Price:"+rs3.getFloat(3));
    					   System.out.println("Enter the New price for Product:");
    					   float nPrice = Float.parseFloat(s.nextLine());
    					   System.out.println("Existing Product Qty:"+rs3.getInt(4));
    					   System.out.println("Enter the new qty:(stock)");
    					   int nQty = Integer.parseInt(s.nextLine());
    					   
    					   ps4.setFloat(1, nPrice);
    					   ps4.setInt(2, nQty);
    					   ps4.setString(3, pC2);
    					   
    					   int k2 = ps4.executeUpdate();
    					   if(k2>0) {
    						   System.out.println("Product Updated Successfully....");
    					   }
    				   }else {
    					   System.out.println("Invalid Prod-Code...");
    				   }
    				   break;
    			   case 5:
    				   System.out.println("Enter the Prod-Code to delete product:");
    				   String pC3 = s.nextLine();
    				   ps3.setString(1, pC3);
    				   ResultSet rs4 = ps3.executeQuery();
    				   if(rs4.next()) {
    					   ps5.setString(1, pC3);
    					   int k3 = ps5.executeUpdate();
    					   if(k3>0) {
    						   System.out.println("Product deleted Successfully...");
    					   }
    				   }else {
    					   System.out.println("Invalid Prod-Code...");
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
