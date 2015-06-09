package com.nankai.exchange.po;

import java.util.Date;

public class Msg {

	private String type;
	private int id;
	private String name;
	private Date posttime;
	public Msg() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Msg(String type, int id, String name, Date posttime) {
		super();
		this.type = type;
		this.id = id;
		this.name = name;
		this.posttime = posttime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getPosttime() {
		return posttime;
	}
	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}
	@Override
	public String toString() {
		return "Msg [type=" + type + ", id=" + id + ", name=" + name
				+ ", posttime=" + posttime + "]";
	}
	
}
