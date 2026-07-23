package com.coforge.dms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "tbl_department")
public class Department {

	@Id
	@Column(name = "did", length = 5)
	@NotNull
	private int did;

	@Column(name = "dname", length = 20)
	@NotBlank
	private String dname;

	@Column(name = "dloc", length = 20)
	@NotBlank
	private String dloc;

	// Default constructor
	public Department() {
		super();
	}

	// Parameterized constructor
	public Department(int did, String dname, String dloc) {
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