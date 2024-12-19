package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO 
{
 public UserBean ub=null;
 public UserBean login(String ename,int eid)
 {
	 try
	 {
		 Connection con=DBConnection.getCon();
		 PreparedStatement ps= con.prepareStatement("selelect * from emp60 where ename=? and eid=?");
		 ps.setString(1, ename);
		 ps.setLong(2, eid);
		 ResultSet rs = ps.executeQuery();
		   if(rs.next()) 
		   {
			   ub = new UserBean();//Bean Object
			   ub.setEmpname(rs.getString(1));
			   ub.setEmpid(rs.getInt(2));
		   }
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	return ub;
	 
 }
}
