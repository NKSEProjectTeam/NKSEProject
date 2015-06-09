package com.nankai.exchange.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
/*
 * cosid int not null auto_increment, posttime datetime not null, cosname
 * varchar(50) not null, cosstate int not null, cosbrand varchar(50) not null,
 * cosmark text not null, cosresource varchar(50), costype varchar(50) not null,
 * uid int not null,
 */
public class Cosmetics implements Serializable {
	private int cosid;
	private Date posttime;
	private String cosname;
	private int cosstate;
	private String cosbrand;
	private String cosmark;
	private String cosresource;
	private String costype;
	private int uid;

	public Cosmetics() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cosmetics(int cosid, Date posttime, String cosname, int cosstate,
			String cosbrand, String cosmark, String cosresource,
			String costype, int uid) {
		super();
		this.cosid = cosid;
		this.posttime = posttime;
		this.cosname = cosname;
		this.cosstate = cosstate;
		this.cosbrand = cosbrand;
		this.cosmark = cosmark;
		this.cosresource = cosresource;
		this.costype = costype;
		this.uid = uid;
	}

	public int getCosid() {
		return cosid;
	}

	public void setCosid(int cosid) {
		this.cosid = cosid;
	}

	public Date getPosttime() {
		return posttime;
	}

	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}

	public String getCosname() {
		return cosname;
	}

	public void setCosname(String cosname) {
		this.cosname = cosname;
	}

	public int getCosstate() {
		return cosstate;
	}

	public void setCosstate(int cosstate) {
		this.cosstate = cosstate;
	}

	public String getCosbrand() {
		return cosbrand;
	}

	public void setCosbrand(String cosbrand) {
		this.cosbrand = cosbrand;
	}

	public String getCosmark() {
		return cosmark;
	}

	public void setCosmark(String cosmark) {
		this.cosmark = cosmark;
	}

	public String getCosresource() {
		return cosresource;
	}

	public void setCosresource(String cosresource) {
		this.cosresource = cosresource;
	}

	public String getCostype() {
		return costype;
	}

	public void setCostype(String costype) {
		this.costype = costype;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Cosmetics [cosid=" + cosid + ", posttime=" + posttime
				+ ", cosname=" + cosname + ", cosstate=" + cosstate
				+ ", cosbrand=" + cosbrand + ", cosmark=" + cosmark
				+ ", cosresource=" + cosresource + ", costype=" + costype
				+ ", uid=" + uid + "]";
	}

}
