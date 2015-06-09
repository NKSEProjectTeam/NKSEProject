package com.nankai.exchange.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
/*
 * dpid int not null auto_increment, dpname varchar(50) not null, dptype
 * varchar(50) not null, posttime datetime not null, dpstate int not null,
 * dpmark text not null, dpresource varchar(50), uid int not null,
 */
public class Dailypros implements Serializable {
	private int dpid;
	private String dpname;
	private String dptype;
	private Date posttime;
	private int dpstate;
	private String dpmark;
	private String dpresource;
	private int uid;
	public Dailypros() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dailypros(int dpid, String dpname, String dptype, Date posttime,
			int dpstate, String dpmark, String dpresource, int uid) {
		super();
		this.dpid = dpid;
		this.dpname = dpname;
		this.dptype = dptype;
		this.posttime = posttime;
		this.dpstate = dpstate;
		this.dpmark = dpmark;
		this.dpresource = dpresource;
		this.uid = uid;
	}
	public int getDpid() {
		return dpid;
	}
	public void setDpid(int dpid) {
		this.dpid = dpid;
	}
	public String getDpname() {
		return dpname;
	}
	public void setDpname(String dpname) {
		this.dpname = dpname;
	}
	public String getDptype() {
		return dptype;
	}
	public void setDptype(String dptype) {
		this.dptype = dptype;
	}
	public Date getPosttime() {
		return posttime;
	}
	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}
	public int getDpstate() {
		return dpstate;
	}
	public void setDpstate(int dpstate) {
		this.dpstate = dpstate;
	}
	public String getDpmark() {
		return dpmark;
	}
	public void setDpmark(String dpmark) {
		this.dpmark = dpmark;
	}
	public String getDpresource() {
		return dpresource;
	}
	public void setDpresource(String dpresource) {
		this.dpresource = dpresource;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "Dailypros [dpid=" + dpid + ", dpname=" + dpname + ", dptype="
				+ dptype + ", posttime=" + posttime + ", dpstate=" + dpstate
				+ ", dpmark=" + dpmark + ", dpresource=" + dpresource
				+ ", uid=" + uid + "]";
	}

	
}
