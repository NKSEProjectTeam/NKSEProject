package com.nankai.exchange.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Hire implements Serializable {
	private int hireid;
	private int userid1;
	private int userid2;
	private Date hiretime;
	private int typeid1;
	private int typeid2;
	private String hireresource;

	public Hire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hire(int hireid, int userid1, int userid2, Date hiretime,
			int typeid1, int typeid2, String hireresource) {
		super();
		this.hireid = hireid;
		this.userid1 = userid1;
		this.userid2 = userid2;
		this.hiretime = hiretime;
		this.typeid1 = typeid1;
		this.typeid2 = typeid2;
		this.hireresource = hireresource;
	}

	public int getHireid() {
		return hireid;
	}

	public void setHireid(int hireid) {
		this.hireid = hireid;
	}

	public int getUserid1() {
		return userid1;
	}

	public void setUserid1(int userid1) {
		this.userid1 = userid1;
	}

	public int getUserid2() {
		return userid2;
	}

	public void setUserid2(int userid2) {
		this.userid2 = userid2;
	}

	public Date getHiretime() {
		return hiretime;
	}

	public void setHiretime(Date hiretime) {
		this.hiretime = hiretime;
	}

	public int getTypeid1() {
		return typeid1;
	}

	public void setTypeid1(int typeid1) {
		this.typeid1 = typeid1;
	}

	public int getTypeid2() {
		return typeid2;
	}

	public void setTypeid2(int typeid2) {
		this.typeid2 = typeid2;
	}

	public String getHireresource() {
		return hireresource;
	}

	public void setHireresource(String hireresource) {
		this.hireresource = hireresource;
	}

	@Override
	public String toString() {
		return "Hire [hireid=" + hireid + ", userid1=" + userid1 + ", userid2="
				+ userid2 + ", hiretime=" + hiretime + ", typeid1=" + typeid1
				+ ", typeid2=" + typeid2 + ", hireresource=" + hireresource
				+ "]";
	}

}
