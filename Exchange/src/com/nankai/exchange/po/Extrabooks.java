package com.nankai.exchange.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
/*
 * ebid int not null auto_increment, posttime datetime not null, ebname
 * varchar(50) not null, ebauthor varchar(50) not null, ebpublish varchar(50)
 * not null, ebstate int not null, ebmark text not null, ebresource varchar(50),
 * uid int not null,
 */
public class Extrabooks implements Serializable {
	private int ebid;
	private Date posttime;
	private String ebname;
	private String ebauthor;
	private String ebpublish;
	private int ebstate;
	private String ebmark;
	private String ebresource;
	private int uid;

	public Extrabooks() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Extrabooks(int ebid, Date posttime, String ebname, String ebauthor,
			String ebpublish, int ebstate, String ebmark, String ebresource,
			int uid) {
		super();
		this.ebid = ebid;
		this.posttime = posttime;
		this.ebname = ebname;
		this.ebauthor = ebauthor;
		this.ebpublish = ebpublish;
		this.ebstate = ebstate;
		this.ebmark = ebmark;
		this.ebresource = ebresource;
		this.uid = uid;
	}

	public int getEbid() {
		return ebid;
	}

	public void setEbid(int ebid) {
		this.ebid = ebid;
	}

	public Date getPosttime() {
		return posttime;
	}

	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}

	public String getEbname() {
		return ebname;
	}

	public void setEbname(String ebname) {
		this.ebname = ebname;
	}

	public String getEbauthor() {
		return ebauthor;
	}

	public void setEbauthor(String ebauthor) {
		this.ebauthor = ebauthor;
	}

	public String getEbpublish() {
		return ebpublish;
	}

	public void setEbpublish(String ebpublish) {
		this.ebpublish = ebpublish;
	}

	public int getEbstate() {
		return ebstate;
	}

	public void setEbstate(int ebstate) {
		this.ebstate = ebstate;
	}

	public String getEbmark() {
		return ebmark;
	}

	public void setEbmark(String ebmark) {
		this.ebmark = ebmark;
	}

	public String getEbresource() {
		return ebresource;
	}

	public void setEbresource(String ebresource) {
		this.ebresource = ebresource;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Extrabooks [ebid=" + ebid + ", posttime=" + posttime
				+ ", ebname=" + ebname + ", ebauthor=" + ebauthor
				+ ", ebpublish=" + ebpublish + ", ebstate=" + ebstate
				+ ", ebmark=" + ebmark + ", ebresource=" + ebresource
				+ ", uid=" + uid + "]";
	}

}
