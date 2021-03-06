package com.nankai.exchange.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class WaitOrder implements Serializable {
	private int typeid1;
	private int id1;
	private String name1;
	private String resource1;
	
	private int typeid2;
	private int id2;
	private String name2;
	private String resource2;
	private Date posttime;
	
	private int userid;
	private String username;
	//待确认交易编号
	private int bid;
	
	public WaitOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public WaitOrder(int typeid1, int id1, String name1, String resource1,
			int typeid2, int id2, String name2, String resource2,
			Date posttime, int userid, String username, int bid) {
		super();
		this.typeid1 = typeid1;
		this.id1 = id1;
		this.name1 = name1;
		this.resource1 = resource1;
		this.typeid2 = typeid2;
		this.id2 = id2;
		this.name2 = name2;
		this.resource2 = resource2;
		this.posttime = posttime;
		this.userid = userid;
		this.username = username;
		this.bid = bid;
	}

	public int getTypeid1() {
		return typeid1;
	}

	public void setTypeid1(int typeid1) {
		this.typeid1 = typeid1;
	}

	public int getId1() {
		return id1;
	}

	public void setId1(int id1) {
		this.id1 = id1;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getResource1() {
		return resource1;
	}

	public void setResource1(String resource1) {
		this.resource1 = resource1;
	}

	public int getTypeid2() {
		return typeid2;
	}

	public void setTypeid2(int typeid2) {
		this.typeid2 = typeid2;
	}

	public int getId2() {
		return id2;
	}

	public void setId2(int id2) {
		this.id2 = id2;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getResource2() {
		return resource2;
	}

	public void setResource2(String resource2) {
		this.resource2 = resource2;
	}

	public Date getPosttime() {
		return posttime;
	}

	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	@Override
	public String toString() {
		return "WaitOrder [typeid1=" + typeid1 + ", id1=" + id1 + ", name1="
				+ name1 + ", resource1=" + resource1 + ", typeid2=" + typeid2
				+ ", id2=" + id2 + ", name2=" + name2 + ", resource2="
				+ resource2 + ", posttime=" + posttime + ", userid=" + userid
				+ ", username=" + username + ", bid=" + bid + "]" + "\n";
	}

	
}
