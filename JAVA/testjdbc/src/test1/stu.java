package test1;

import java.io.Serializable; //–Ú¡–ªØ
import java.sql.Date;

public class stu implements Serializable{

	private int sno;
	private String sname;
	private String ssex;
	private String sdept;
	private int sage;
	private Date date;
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public String getSdept() {
		return sdept;
	}
	public void setSdept(String sdept) {
		this.sdept = sdept;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "stu [sno=" + sno + ", sname=" + sname + ", ssex=" + ssex + ", sdept=" + sdept + ", sage=" + sage
				+ ", date=" + date + "]";
	}
	
	public stu() {
		
	}
	public stu(int sno, String sname, String ssex, String sdept, int sage, Date date) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.ssex = ssex;
		this.sdept = sdept;
		this.sage = sage;
		this.date = date;
	}
	
}
