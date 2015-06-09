package com.nankai.exchange.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
/*
 * enterid int not null auto_increment, posttime datetime not null, entername
 * varchar(50) not null, entertype varchar(50) not null, enterstate int not
 * null, entermark text not null, enterresource varchar(50), uid int not null,
 */
public class Entertainments implements Serializable {
	private int enterid;
	private Date posttime;
	private String entername;
	private String entertype;
	private int enterstate;
	private String entermark;
	private String enterresource;
	private int uid;

	public Entertainments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Entertainments(int enterid, Date posttime, String entername,
			String entertype, int enterstate, String entermark,
			String enterresource, int uid) {
		super();
		this.enterid = enterid;
		this.posttime = posttime;
		this.entername = entername;
		this.entertype = entertype;
		this.enterstate = enterstate;
		this.entermark = entermark;
		this.enterresource = enterresource;
		this.uid = uid;
	}

	public int getEnterid() {
		return enterid;
	}

	public void setEnterid(int enterid) {
		this.enterid = enterid;
	}

	public Date getPosttime() {
		return posttime;
	}

	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}

	public String getEntername() {
		return entername;
	}

	public void setEntername(String entername) {
		this.entername = entername;
	}

	public String getEntertype() {
		return entertype;
	}

	public void setEntertype(String entertype) {
		this.entertype = entertype;
	}

	public int getEnterstate() {
		return enterstate;
	}

	public void setEnterstate(int enterstate) {
		this.enterstate = enterstate;
	}

	public String getEntermark() {
		return entermark;
	}

	public void setEntermark(String entermark) {
		this.entermark = entermark;
	}

	public String getEnterresource() {
		return enterresource;
	}

	public void setEnterresource(String enterresource) {
		this.enterresource = enterresource;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Entertainments [enterid=" + enterid + ", posttime=" + posttime
				+ ", entername=" + entername + ", entertype=" + entertype
				+ ", enterstate=" + enterstate + ", entermark=" + entermark
				+ ", enterresource=" + enterresource + ", uid=" + uid + "]";
	}

}
