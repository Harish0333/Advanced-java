package test;
import java.io.Serializable;

@SuppressWarnings("serial")
public class CustomerBean implements Serializable
{
	   private long phNo;
	   private String name,city,mId;
	   public CustomerBean()
	   {
	   }
	public long getPhNo() {
		return phNo;
	}
	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}

}
