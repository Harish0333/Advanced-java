package test;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.annotation.WebServlet;
@WebServlet("/update")
public class UpdateDAO 
{
	 public int k=0;
		public int update(CustomerBean cb,String n)
		{
			try 
			{
				Connection con=DBConnection.getCon();
				PreparedStatement ps = con.prepareStatement
						   ("update Customer60 set phno=?,name=?,city=?,mId=? where name=?");
				   ps.setLong(1, cb.getPhNo());
				   ps.setString(2, cb.getName());
				   ps.setString(3, cb.getCity());
				   ps.setString(4, cb.getmId());
				   ps.setString(5, n);
				   k=ps.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return k;
		}
}
