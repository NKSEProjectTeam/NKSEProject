package com.nankai.exchange.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Sppros implements Serializable {
	private int spid;
	private String spname;
	private String sptype;
	private Date posttime;
	private String splocation;
	private int spstate;
	private String spmark;
	private String spresource;
	private int uid;

	public Sppros() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sppros(int spid, String spname, String sptype, Date posttime,
			String splocation, int spstate, String spmark, String spresource,
			int uid) {
		super();
		this.spid = spid;
		this.spname = spname;
		this.sptype = sptype;
		this.posttime = posttime;
		this.splocation = splocation;
		this.spstate = spstate;
		this.spmark = spmark;
		this.spresource = spresource;
		this.uid = uid;
	}

	public int getSpid() {
		return spid;
	}

	public void setSpid(int spid) {
		this.spid = spid;
	}

	public String getSpname() {
		return spname;
	}

	public void setSpname(String spname) {
		this.spname = spname;
	}

	public String getSptype() {
		return sptype;
	}

	public void setSptype(String sptype) {
		this.sptype = sptype;
	}

	public Date getPosttime() {
		return posttime;
	}

	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}

	public String getSplocation() {
		return splocation;
	}

	public void setSplocation(String splocation) {
		this.splocation = splocation;
	}

	public int getSpstate() {
		return spstate;
	}

	public void setSpstate(int spstate) {
		this.spstate = spstate;
	}

	public String getSpmark() {
		return spmark;
	}

	public void setSpmark(String spmark) {
		this.spmark = spmark;
	}

	public String getSpresource() {
		return spresource;
	}

	public void setSpresource(String spresource) {
		this.spresource = spresource;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Sppros [spid=" + spid + ", spname=" + spname + ", sptype="
				+ sptype + ", posttime=" + posttime + ", splocation="
				+ splocation + ", spstate=" + spstate + ", spmark=" + spmark
				+ ", spresource=" + spresource + ", uid=" + uid + "]";
	}

}
