package com.nankai.exchange.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
/*
 * bagid int not null auto_increment, posttime datetime not null, bagbrand
 * varchar(50) not null, bagtype varchar(50) not null, bagstate int not null,
 * bagmark text not null, bagresource varchar(50), uid int not null,
 */
public class Bags implements Serializable {
	private int bagid;
	private Date posttime;
	private String bagbrand;
	private String bagtype;
	private int bagstate;
	private String bagmark;
	private String bagresource;
	private int uid;

	public Bags() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bags(int bagid, Date posttime, String bagbrand, String bagtype,
			int bagstate, String bagmark, String bagresource, int uid) {
		super();
		this.bagid = bagid;
		this.posttime = posttime;
		this.bagbrand = bagbrand;
		this.bagtype = bagtype;
		this.bagstate = bagstate;
		this.bagmark = bagmark;
		this.bagresource = bagresource;
		this.uid = uid;
	}

	public int getBagid() {
		return bagid;
	}

	public void setBagid(int bagid) {
		this.bagid = bagid;
	}

	public Date getPosttime() {
		return posttime;
	}

	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}

	public String getBagbrand() {
		return bagbrand;
	}

	public void setBagbrand(String bagbrand) {
		this.bagbrand = bagbrand;
	}

	public String getBagtype() {
		return bagtype;
	}

	public void setBagtype(String bagtype) {
		this.bagtype = bagtype;
	}

	public int getBagstate() {
		return bagstate;
	}

	public void setBagstate(int bagstate) {
		this.bagstate = bagstate;
	}

	public String getBagmark() {
		return bagmark;
	}

	public void setBagmark(String bagmark) {
		this.bagmark = bagmark;
	}

	public String getBagresource() {
		return bagresource;
	}

	public void setBagresource(String bagresource) {
		this.bagresource = bagresource;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Bags [bagid=" + bagid + ", posttime=" + posttime
				+ ", bagbrand=" + bagbrand + ", bagtype=" + bagtype
				+ ", bagstate=" + bagstate + ", bagmark=" + bagmark
				+ ", bagresource=" + bagresource + ", uid=" + uid + "]";
	}

}
