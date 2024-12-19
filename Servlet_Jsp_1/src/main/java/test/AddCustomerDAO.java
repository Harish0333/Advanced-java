package test;
import java.sql.*;
public class AddCustomerDAO {
   public int k=0;
   public int insert(CustomerBean cb) {
	   try {
		   Connection con = DBConnection.getCon();//Accessing DB Connection
		   PreparedStatement ps = con.prepareStatement
				   ("insert into Customer60 values(?,?,?,?)");
		   ps.setLong(1, cb.getPhNo());
		   ps.setString(2, cb.getName());
		   ps.setString(3, cb.getCity());
		   ps.setString(4, cb.getmId());
		   k = ps.executeUpdate();
	   }catch(Exception e) {e.printStackTrace();}
	   return k;
   }
}

