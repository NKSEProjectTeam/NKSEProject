package com.nankai.exchange.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Textbooks implements Serializable {
	private int tbid;
	private int uid;
	private Date posttime;
	private String tbname;
	private String tbauthor;
	private String tbpublish;
	private String tbversion;
	private int tbstate;
	private String tbmark;
	private String tbresource;

	public Textbooks() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Textbooks(int tbid, int uid, Date posttime, String tbname,
			String tbauthor, String tbpublish, String tbversion, int tbstate,
			String tbmark, String tbresource) {
		super();
		this.tbid = tbid;
		this.uid = uid;
		this.posttime = posttime;
		this.tbname = tbname;
		this.tbauthor = tbauthor;
		this.tbpublish = tbpublish;
		this.tbversion = tbversion;
		this.tbstate = tbstate;
		this.tbmark = tbmark;
		this.tbresource = tbresource;
	}

	public int getTbid() {
		return tbid;
	}

	public void setTbid(int tbid) {
		this.tbid = tbid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Date getPosttime() {
		return posttime;
	}

	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}

	public String getTbname() {
		return tbname;
	}

	public void setTbname(String tbname) {
		this.tbname = tbname;
	}

	public String getTbauthor() {
		return tbauthor;
	}

	public void setTbauthor(String tbauthor) {
		this.tbauthor = tbauthor;
	}

	public String getTbpublish() {
		return tbpublish;
	}

	public void setTbpublish(String tbpublish) {
		this.tbpublish = tbpublish;
	}

	public String getTbversion() {
		return tbversion;
	}

	public void setTbversion(String tbversion) {
		this.tbversion = tbversion;
	}

	public int getTbstate() {
		return tbstate;
	}

	public void setTbstate(int tbstate) {
		this.tbstate = tbstate;
	}

	public String getTbmark() {
		return tbmark;
	}

	public void setTbmark(String tbmark) {
		this.tbmark = tbmark;
	}

	public String getTbresource() {
		return tbresource;
	}

	public void setTbresource(String tbresource) {
		this.tbresource = tbresource;
	}

	@Override
	public String toString() {
		return "Textbooks [tbid=" + tbid + ", uid=" + uid + ", posttime="
				+ posttime + ", tbname=" + tbname + ", tbauthor=" + tbauthor
				+ ", tbpublish=" + tbpublish + ", tbversion=" + tbversion
				+ ", tbstate=" + tbstate + ", tbmark=" + tbmark
				+ ", tbresource=" + tbresource + "]";
	}

}
