package com.nankai.exchange.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class TradeOrder implements Serializable {

	private int userid2;
	private String username2;
	private Date tradetime;
	private int type1id1;
	private int type1id2;
	private String proname1;
	private int type2id1;
	private int type2id2;
	private String proname2;
	private String traresource;
	public TradeOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TradeOrder(int userid2, String username2, Date tradetime,
			int type1id1, int type1id2, String proname1, int type2id1,
			int type2id2, String proname2, String traresource) {
		super();
		this.userid2 = userid2;
		this.username2 = username2;
		this.tradetime = tradetime;
		this.type1id1 = type1id1;
		this.type1id2 = type1id2;
		this.proname1 = proname1;
		this.type2id1 = type2id1;
		this.type2id2 = type2id2;
		this.proname2 = proname2;
		this.traresource = traresource;
	}
	public int getUserid2() {
		return userid2;
	}
	public void setUserid2(int userid2) {
		this.userid2 = userid2;
	}
	public String getUsername2() {
		return username2;
	}
	public void setUsername2(String username2) {
		this.username2 = username2;
	}
	public Date getTradetime() {
		return tradetime;
	}
	public void setTradetime(Date tradetime) {
		this.tradetime = tradetime;
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
	public String getProname1() {
		return proname1;
	}
	public void setProname1(String proname1) {
		this.proname1 = proname1;
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
	public String getProname2() {
		return proname2;
	}
	public void setProname2(String proname2) {
		this.proname2 = proname2;
	}
	public String getTraresource() {
		return traresource;
	}
	public void setTraresource(String traresource) {
		this.traresource = traresource;
	}
	@Override
	public String toString() {
		return "TradeOrder [userid2=" + userid2 + ", username2=" + username2
				+ ", tradetime=" + tradetime + ", type1id1=" + type1id1
				+ ", type1id2=" + type1id2 + ", proname1=" + proname1
				+ ", type2id1=" + type2id1 + ", type2id2=" + type2id2
				+ ", proname2=" + proname2 + ", traresource=" + traresource
				+ "]";
	}
	
}
