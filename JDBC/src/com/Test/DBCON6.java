package com.Test;
/*create or replace function RetrieveTotSal60
(id varchar2) return number as ts number;
begin
    select torsal into ts from EmpSalary60 where eid=id;
    return ts;
end;
/
*/import java.util.*;
import java.sql.*;
public class DBCON6 {
	public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       try(s;){
    	   try {
    		   Class.forName("oracle.jdbc.driver.OracleDriver");
       		Connection con = DriverManager.getConnection
       				("jdbc:oracle:thin:@localhost:1521:orcl","system","root");
       		CallableStatement cs = con.prepareCall
       		("{call ?:=RetrieveTotSal60(?)}");
       		
       		System.out.println("Enter the EmpId to retrieve totSal:");
       		String id = s.nextLine();
       		
       		cs.registerOutParameter(1, Types.FLOAT);
       		cs.setString(2, id);
       		cs.execute();
       		System.out.println("Emp-Id:"+id);
       		System.out.println("Emp-TotSal:"+cs.getFloat(1));
       		con.close();
    	   }catch(Exception e) {e.printStackTrace();}
       }//end of try with resource
	}

}
