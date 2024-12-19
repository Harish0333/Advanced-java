package test;
import java.sql.*;
import java.util.*;
public class ViewAllCustomersDAO 
{
    public ArrayList<CustomerBean> al = new ArrayList<CustomerBean>();
    public ArrayList<CustomerBean> retrieve()
    {
    	try {
    		Connection con = DBConnection.getCon();//Accessing DB Connection
    		PreparedStatement ps = con.prepareStatement("select * from Customer60");
    		ResultSet rs = ps.executeQuery();
    		while(rs.next()) {
    			CustomerBean cb = new CustomerBean();
    			cb.setPhNo(rs.getLong(1));
    			cb.setName(rs.getString(2));
    			cb.setCity(rs.getString(3));
    			cb.setmId(rs.getString(4));
    			al.add(cb);//CustomerBean Object added to ArrayList
    		}//end of loop
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return al;
    }
}
