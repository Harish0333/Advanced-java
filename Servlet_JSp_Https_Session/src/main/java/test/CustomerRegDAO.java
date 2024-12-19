package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerRegDAO {
	public int k=0;
	   public int register(CustomerBean cb) {
		   try {
			   Connection con = DBConnection.getCon();//Accessing DB Connection
			   PreparedStatement ps = con.prepareStatement
					   ("insert into Customerr60 values(?,?,?,?,?,?,?)");
			   ps.setString(1, cb.getuName());
			   ps.setString(2, cb.getpWord());
			   ps.setString(3, cb.getfName());
			   ps.setString(4, cb.getlName());
			   ps.setString(5, cb.getAddr());
			   ps.setString(6, cb.getmId());
			   ps.setLong(7, cb.getPhNo());
			   k = ps.executeUpdate();
		   }catch(Exception e) {e.printStackTrace();}
		   return k;
	   }

}
