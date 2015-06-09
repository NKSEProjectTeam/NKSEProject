package com.nankai.exchange.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
/*
 * decid int not null auto_increment, posttime datetime not null, decname
 * varchar(50) not null, dectype varchar(50) not null, decstate int not null,
 * decmark text not null, decresource varchar(50), uid int not null,
 */
public class Decorations implements Serializable {
	private int decid;
	private Date posttime;
	private String decname;
	private String dectype;
	private int decstate;
	private String decmark;
	private String decresource;
	private int uid;

	public Decorations() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Decorations(int decid, Date posttime, String decname,
			String dectype, int decstate, String decmark, String decresource,
			int uid) {
		super();
		this.decid = decid;
		this.posttime = posttime;
		this.decname = decname;
		this.dectype = dectype;
		this.decstate = decstate;
		this.decmark = decmark;
		this.decresource = decresource;
		this.uid = uid;
	}
	public int getDecid() {
		return decid;
	}

	public void setDecid(int decid) {
		this.decid = decid;
	}

	public Date getPosttime() {
		return posttime;
	}

	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}

	public String getDecname() {
		return decname;
	}

	public void setDecname(String decname) {
		this.decname = decname;
	}

	public String getDectype() {
		return dectype;
	}

	public void setDectype(String dectype) {
		this.dectype = dectype;
	}

	public int getDecstate() {
		return decstate;
	}

	public void setDecstate(int decstate) {
		this.decstate = decstate;
	}

	public String getDecmark() {
		return decmark;
	}

	public void setDecmark(String decmark) {
		this.decmark = decmark;
	}

	public String getDecresource() {
		return decresource;
	}

	public void setDecresource(String decresource) {
		this.decresource = decresource;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Decorations [decid=" + decid + ", posttime=" + posttime
				+ ", decname=" + decname + ", dectype=" + dectype
				+ ", decstate=" + decstate + ", decmark=" + decmark
				+ ", decresource=" + decresource + ", uid=" + uid + "]";
	}

	

	
}
