package com.nankai.exchange.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Virtuals implements Serializable {
	private int virtualid;
	private String virtualname;
	private int virtualstate;
	private String virtualmark;
	private Date posttime;
	private String virtualresource;
	private int uid;

	public Virtuals() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Virtuals(int virtualid, String virtualname, int virtualstate,
			String virtualmark, Date posttime, String virtualresource, int uid) {
		super();
		this.virtualid = virtualid;
		this.virtualname = virtualname;
		this.virtualstate = virtualstate;
		this.virtualmark = virtualmark;
		this.posttime = posttime;
		this.virtualresource = virtualresource;
		this.uid = uid;
	}

	public int getVirtualid() {
		return virtualid;
	}

	public void setVirtualid(int virtualid) {
		this.virtualid = virtualid;
	}

	public String getVirtualname() {
		return virtualname;
	}

	public void setVirtualname(String virtualname) {
		this.virtualname = virtualname;
	}

	public int getVirtualstate() {
		return virtualstate;
	}

	public void setVirtualstate(int virtualstate) {
		this.virtualstate = virtualstate;
	}

	public String getVirtualmark() {
		return virtualmark;
	}

	public void setVirtualmark(String virtualmark) {
		this.virtualmark = virtualmark;
	}

	public Date getPosttime() {
		return posttime;
	}

	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}

	public String getVirtualresource() {
		return virtualresource;
	}

	public void setVirtualresource(String virtualresource) {
		this.virtualresource = virtualresource;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Virtuals [virtualid=" + virtualid + ", virtualname="
				+ virtualname + ", virtualstate=" + virtualstate
				+ ", virtualmark=" + virtualmark + ", posttime=" + posttime
				+ ", virtualresource=" + virtualresource + ", uid=" + uid + "]";
	}

}
