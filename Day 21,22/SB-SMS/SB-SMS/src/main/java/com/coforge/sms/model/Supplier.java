package com.coforge.sms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_supplier")
public class Supplier {
	@Id
	@Column(name="sid", length = 5)
	private int sid;
	
	@Column(name="sname", length = 20)
	private String sname;
	
	@Column(name="scity", length = 20)
	private String scity;
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Supplier(int sid, String sname, String scity) {
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
