package com.nankai.exchange.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Sptasts implements Serializable {
	private int said;
	private Date posttime;
	private String saname;
	private String satype;
	private int sastate;
	private String samark;
	private String saresource;
	private int uid;

	public Sptasts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sptasts(int said, Date posttime, String saname, String satype,
			int sastate, String samark, String saresource, int uid) {
		super();
		this.said = said;
		this.posttime = posttime;
		this.saname = saname;
		this.satype = satype;
		this.sastate = sastate;
		this.samark = samark;
		this.saresource = saresource;
		this.uid = uid;
	}

	public int getSaid() {
		return said;
	}

	public void setSaid(int said) {
		this.said = said;
	}

	public Date getPosttime() {
		return posttime;
	}

	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}

	public String getSaname() {
		return saname;
	}

	public void setSaname(String saname) {
		this.saname = saname;
	}

	public String getSatype() {
		return satype;
	}

	public void setSatype(String satype) {
		this.satype = satype;
	}

	public int getSastate() {
		return sastate;
	}

	public void setSastate(int sastate) {
		this.sastate = sastate;
	}

	public String getSamark() {
		return samark;
	}

	public void setSamark(String samark) {
		this.samark = samark;
	}

	public String getSaresource() {
		return saresource;
	}

	public void setSaresource(String saresource) {
		this.saresource = saresource;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Sptasts [said=" + said + ", posttime=" + posttime + ", saname="
				+ saname + ", satype=" + satype + ", sastate=" + sastate
				+ ", samark=" + samark + ", saresource=" + saresource
				+ ", uid=" + uid + "]";
	}

}
