package com.br.julianfernando.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="project")
public class Project implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Project() {
		super();
	}
	
	@Id
	private int pnumber;
	
	private String pname;
	
	private String plocation;
	
	@Column(name="depto_no")
	private int deptoNo;

	public int getPnumber() {
		return pnumber;
	}

	public void setPnumber(int pnumber) {
		this.pnumber = pnumber;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPlocation() {
		return plocation;
	}

	public void setPlocation(String plocation) {
		this.plocation = plocation;
	}

	public int getDeptoNo() {
		return deptoNo;
	}

	public void setDeptoNo(int deptoNo) {
		this.deptoNo = deptoNo;
	}

	@Override
	public String toString() {
		return "Project [pnumber=" + pnumber + ", pname=" + pname
				+ ", plocation=" + plocation + ", deptoNo=" + deptoNo + "]";
	}
	
	
	
}
