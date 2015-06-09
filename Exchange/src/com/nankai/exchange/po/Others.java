package com.nankai.exchange.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Others implements Serializable {
	private int otherid;
	private Date posttime;
	private String othersname;
	private String othertype;
	private int othersstate;
	private String othermark;
	private String otherresource;
	private int uid;

	public Others() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Others(int otherid, Date posttime, String othersname,
			String othertype, int othersstate, String othermark,
			String otherresource, int uid) {
		super();
		this.otherid = otherid;
		this.posttime = posttime;
		this.othersname = othersname;
		this.othertype = othertype;
		this.othersstate = othersstate;
		this.othermark = othermark;
		this.otherresource = otherresource;
		this.uid = uid;
	}

	public int getOtherid() {
		return otherid;
	}

	public void setOtherid(int otherid) {
		this.otherid = otherid;
	}

	public Date getPosttime() {
		return posttime;
	}

	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}

	public String getOthersname() {
		return othersname;
	}

	public void setOthersname(String othersname) {
		this.othersname = othersname;
	}

	public String getOthertype() {
		return othertype;
	}

	public void setOthertype(String othertype) {
		this.othertype = othertype;
	}

	public int getOthersstate() {
		return othersstate;
	}

	public void setOthersstate(int othersstate) {
		this.othersstate = othersstate;
	}

	public String getOthermark() {
		return othermark;
	}

	public void setOthermark(String othermark) {
		this.othermark = othermark;
	}

	public String getOtherresource() {
		return otherresource;
	}

	public void setOtherresource(String otherresource) {
		this.otherresource = otherresource;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Others [otherid=" + otherid + ", posttime=" + posttime
				+ ", othersname=" + othersname + ", othertype=" + othertype
				+ ", othersstate=" + othersstate + ", othermark=" + othermark
				+ ", otherresource=" + otherresource + ", uid=" + uid + "]";
	}

}
