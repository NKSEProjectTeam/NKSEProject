package com.nankai.exchange.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Pc implements Serializable {
	private int pcid;
	private Date posttime;
	private String pcbrand;
	private String pcmodel;
	private String pctype;
	private int pcstate;
	private String pcresource;
	private int uid;
	private String pcmark;

	public Pc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pc(int pcid, Date posttime, String pcbrand, String pcmodel,
			String pctype, int pcstate, String pcresource, int uid,
			String pcmark) {
		super();
		this.pcid = pcid;
		this.posttime = posttime;
		this.pcbrand = pcbrand;
		this.pcmodel = pcmodel;
		this.pctype = pctype;
		this.pcstate = pcstate;
		this.pcresource = pcresource;
		this.uid = uid;
		this.pcmark = pcmark;
	}

	public int getPcid() {
		return pcid;
	}

	public void setPcid(int pcid) {
		this.pcid = pcid;
	}

	public Date getPosttime() {
		return posttime;
	}

	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}

	public String getPcbrand() {
		return pcbrand;
	}

	public void setPcbrand(String pcbrand) {
		this.pcbrand = pcbrand;
	}

	public String getPcmodel() {
		return pcmodel;
	}

	public void setPcmodel(String pcmodel) {
		this.pcmodel = pcmodel;
	}

	public String getPctype() {
		return pctype;
	}

	public void setPctype(String pctype) {
		this.pctype = pctype;
	}

	public int getPcstate() {
		return pcstate;
	}

	public void setPcstate(int pcstate) {
		this.pcstate = pcstate;
	}

	public String getPcresource() {
		return pcresource;
	}

	public void setPcresource(String pcresource) {
		this.pcresource = pcresource;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getPcmark() {
		return pcmark;
	}

	public void setPcmark(String pcmark) {
		this.pcmark = pcmark;
	}

	@Override
	public String toString() {
		return "Pc [pcid=" + pcid + ", posttime=" + posttime + ", pcbrand="
				+ pcbrand + ", pcmodel=" + pcmodel + ", pctype=" + pctype
				+ ", pcstate=" + pcstate + ", pcresource=" + pcresource
				+ ", uid=" + uid + ", pcmark=" + pcmark + "]";
	}

}
