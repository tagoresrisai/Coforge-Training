package com.coforge.pms.dto;


public class SupplierDto {

	private int sid;
	
	private String sname;

	private String scity;
	public SupplierDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SupplierDto(int sid, String sname, String scity) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.scity = scity;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getScity() {
		return scity;
	}
	public void setScity(String scity) {
		this.scity = scity;
	}
	@Override
	public String toString() {
		return "Supplier [sid=" + sid + ", sname=" + sname + ", scity=" + scity + "]";
	}
	
}
