package com.nankai.exchange.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Spteqpts implements Serializable {
	private int seid;
	private Date posttime;
	private String sename;
	private String setype;
	private int sestate;
	private String semark;
	private String seresource;
	private int uid;

	public Spteqpts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Spteqpts(int seid, Date posttime, String sename, String setype,
			int sestate, String semark, String seresource, int uid) {
		super();
		this.seid = seid;
		this.posttime = posttime;
		this.sename = sename;
		this.setype = setype;
		this.sestate = sestate;
		this.semark = semark;
		this.seresource = seresource;
		this.uid = uid;
	}

	public int getSeid() {
		return seid;
	}

	public void setSeid(int seid) {
		this.seid = seid;
	}

	public Date getPosttime() {
		return posttime;
	}

	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}

	public String getSename() {
		return sename;
	}

	public void setSename(String sename) {
		this.sename = sename;
	}

	public String getSetype() {
		return setype;
	}

	public void setSetype(String setype) {
		this.setype = setype;
	}

	public int getSestate() {
		return sestate;
	}

	public void setSestate(int sestate) {
		this.sestate = sestate;
	}

	public String getSemark() {
		return semark;
	}

	public void setSemark(String semark) {
		this.semark = semark;
	}

	public String getSeresource() {
		return seresource;
	}

	public void setSeresource(String seresource) {
		this.seresource = seresource;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Spteqpts [seid=" + seid + ", posttime=" + posttime
				+ ", sename=" + sename + ", setype=" + setype + ", sestate="
				+ sestate + ", semark=" + semark + ", seresource=" + seresource
				+ ", uid=" + uid + "]";
	}

}
