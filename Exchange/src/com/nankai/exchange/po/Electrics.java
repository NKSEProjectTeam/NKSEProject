package com.nankai.exchange.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
/*
 * eleid int not null auto_increment, posttime datetime not null, elename
 * varchar(50) not null, eletype varchar(50) not null, elestate int not null,
 * elemark text not null, eleresource varchar(50), uid int not null,
 */
public class Electrics implements Serializable {
	private int eleid;
	private Date posttime;
	private String elename;
	private String eletype;
	private int elestate;
	private String elemark;
	private String eleresource;
	private int uid;

	public Electrics() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Electrics(int eleid, Date posttime, String elename, String eletype,
			int elestate, String elemark, String eleresource, int uid) {
		super();
		this.eleid = eleid;
		this.posttime = posttime;
		this.elename = elename;
		this.eletype = eletype;
		this.elestate = elestate;
		this.elemark = elemark;
		this.eleresource = eleresource;
		this.uid = uid;
	}

	public int getEleid() {
		return eleid;
	}

	public void setEleid(int eleid) {
		this.eleid = eleid;
	}

	public Date getPosttime() {
		return posttime;
	}

	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}

	public String getElename() {
		return elename;
	}

	public void setElename(String elename) {
		this.elename = elename;
	}

	public String getEletype() {
		return eletype;
	}

	public void setEletype(String eletype) {
		this.eletype = eletype;
	}

	public int getElestate() {
		return elestate;
	}

	public void setElestate(int elestate) {
		this.elestate = elestate;
	}

	public String getElemark() {
		return elemark;
	}

	public void setElemark(String elemark) {
		this.elemark = elemark;
	}

	public String getEleresource() {
		return eleresource;
	}

	public void setEleresource(String eleresource) {
		this.eleresource = eleresource;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Electrics [eleid=" + eleid + ", elename=" + elename
				+ ", eletype=" + eletype + ", elestate=" + elestate
				+ ", elemark=" + elemark + ", eleresource=" + eleresource
				+ ", uid=" + uid + "]";
	}

}
