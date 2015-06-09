package com.nankai.exchange.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Males implements Serializable {
	private int maleid;
	private Date posttime;
	private String maletype;
	private String malesize;
	private int malestate;
	private String malemark;
	private String maleresource;
	private int uid;

	public Males() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Males(int maleid, Date posttime, String maletype, String malesize,
			int malestate, String malemark, String maleresource, int uid) {
		super();
		this.maleid = maleid;
		this.posttime = posttime;
		this.maletype = maletype;
		this.malesize = malesize;
		this.malestate = malestate;
		this.malemark = malemark;
		this.maleresource = maleresource;
		this.uid = uid;
	}

	public int getMaleid() {
		return maleid;
	}

	public void setMaleid(int maleid) {
		this.maleid = maleid;
	}

	public Date getPosttime() {
		return posttime;
	}

	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}

	public String getMaletype() {
		return maletype;
	}

	public void setMaletype(String maletype) {
		this.maletype = maletype;
	}

	public String getMalesize() {
		return malesize;
	}

	public void setMalesize(String malesize) {
		this.malesize = malesize;
	}

	public int getMalestate() {
		return malestate;
	}

	public void setMalestate(int malestate) {
		this.malestate = malestate;
	}

	public String getMalemark() {
		return malemark;
	}

	public void setMalemark(String malemark) {
		this.malemark = malemark;
	}

	public String getMaleresource() {
		return maleresource;
	}

	public void setMaleresource(String maleresource) {
		this.maleresource = maleresource;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Males [maleid=" + maleid + ", posttime=" + posttime
				+ ", maletype=" + maletype + ", malesize=" + malesize
				+ ", malestate=" + malestate + ", malemark=" + malemark
				+ ", maleresource=" + maleresource + ", uid=" + uid + "]";
	}

}
