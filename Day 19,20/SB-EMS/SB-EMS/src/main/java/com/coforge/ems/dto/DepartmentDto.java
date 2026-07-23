package com.coforge.ems.dto;


public class DepartmentDto {


	private int did;

	private String dname;


	private String dloc;

	// Default constructor
	public DepartmentDto() {
		super();
	}

	// Parameterized constructor
	public DepartmentDto(int did, String dname, String dloc) {
		super();
		this.did = did;
		this.dname = dname;
		this.dloc = dloc;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDloc() {
		return dloc;
	}

	public void setDloc(String dloc) {
		this.dloc = dloc;
	}

	@Override
	public String toString() {
		return "Department [did=" + did + ", dname=" + dname + ", dloc=" + dloc + "]";
	}

}