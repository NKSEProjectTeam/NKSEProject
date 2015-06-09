package com.nankai.exchange.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Trade implements Serializable {
	private int traid;
	private int userid1;
	private int userid2;
	private Date tratime;
	private int type1id1;
	private int type1id2;
	private int type2id1;
	private int type2id2;
	private String traresource;

	public Trade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trade(int traid, int userid1, int userid2, Date tratime,
			int type1id1, int type1id2, int type2id1, int type2id2,
			String traresource) {
		super();
		this.traid = traid;
		this.userid1 = userid1;
		this.userid2 = userid2;
		this.tratime = tratime;
		this.type1id1 = type1id1;
		this.type1id2 = type1id2;
		this.type2id1 = type2id1;
		this.type2id2 = type2id2;
		this.traresource = traresource;
	}

	public int getTraid() {
		return traid;
	}

	public void setTraid(int traid) {
		this.traid = traid;
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

	public Date getTratime() {
		return tratime;
	}

	public void setTratime(Date tratime) {
		this.tratime = tratime;
	}

	public int getType1id1() {
		return type1id1;
	}

	public void setType1id1(int type1id1) {
		this.type1id1 = type1id1;
	}

	public int getType1id2() {
		return type1id2;
	}

	public void setType1id2(int type1id2) {
		this.type1id2 = type1id2;
	}

	public int getType2id1() {
		return type2id1;
	}

	public void setType2id1(int type2id1) {
		this.type2id1 = type2id1;
	}

	public int getType2id2() {
		return type2id2;
	}

	public void setType2id2(int type2id2) {
		this.type2id2 = type2id2;
	}

	public String getTraresource() {
		return traresource;
	}

	public void setTraresource(String traresource) {
		this.traresource = traresource;
	}

	@Override
	public String toString() {
		return "Trade [traid=" + traid + ", userid1=" + userid1 + ", userid2="
				+ userid2 + ", tratime=" + tratime + ", type1id1=" + type1id1
				+ ", type1id2=" + type1id2 + ", type2id1=" + type2id1
				+ ", type2id2=" + type2id2 + ", traresource=" + traresource
				+ "]";
	}

}
