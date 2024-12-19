package test;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserBean implements Serializable 
{
	private String Empname;
	private int Empid;
	
	public UserBean()
	{
	}

	public String getEmpname() {
		return Empname;
	}

	public void setEmpname(String empname) {
		Empname = empname;
	}

	public int getEmpid() {
		return Empid;
	}

	public void setEmpid(int empid) {
		Empid = empid;
	}
	
}
