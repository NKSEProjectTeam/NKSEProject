package com.nankai.exchange.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Type implements Serializable {
	private int typeid;
	private String typename;
	private int faid;

	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Type(int typeid, String typename, int faid) {
		super();
		this.typeid = typeid;
		this.typename = typename;
		this.faid = faid;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public int getFaid() {
		return faid;
	}

	public void setFaid(int faid) {
		this.faid = faid;
	}

	@Override
	public String toString() {
		return "Type [typeid=" + typeid + ", typename=" + typename + ", faid="
				+ faid + "]";
	}

}
