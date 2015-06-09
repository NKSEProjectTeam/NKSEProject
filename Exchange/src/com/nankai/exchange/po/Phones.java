package com.nankai.exchange.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Phones implements Serializable {
	private int phoneid;
	private Date posttime;
	private String phonebrand;
	private String phonemodel;
	private String phonetype;
	private int phonestate;
	private String phonemark;
	private String phoneresource;
	private int uid;

	public Phones() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Phones(int phoneid, Date posttime, String phonebrand,
			String phonemodel, String phonetype, int phonestate,
			String phonemark, String phoneresource, int uid) {
		super();
		this.phoneid = phoneid;
		this.posttime = posttime;
		this.phonebrand = phonebrand;
		this.phonemodel = phonemodel;
		this.phonetype = phonetype;
		this.phonestate = phonestate;
		this.phonemark = phonemark;
		this.phoneresource = phoneresource;
		this.uid = uid;
	}

	public int getPhoneid() {
		return phoneid;
	}

	public void setPhoneid(int phoneid) {
		this.phoneid = phoneid;
	}

	public Date getPosttime() {
		return posttime;
	}

	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}

	public String getPhonebrand() {
		return phonebrand;
	}

	public void setPhonebrand(String phonebrand) {
		this.phonebrand = phonebrand;
	}

	public String getPhonemodel() {
		return phonemodel;
	}

	public void setPhonemodel(String phonemodel) {
		this.phonemodel = phonemodel;
	}

	public String getPhonetype() {
		return phonetype;
	}

	public void setPhonetype(String phonetype) {
		this.phonetype = phonetype;
	}

	public int getPhonestate() {
		return phonestate;
	}

	public void setPhonestate(int phonestate) {
		this.phonestate = phonestate;
	}

	public String getPhonemark() {
		return phonemark;
	}

	public void setPhonemark(String phonemark) {
		this.phonemark = phonemark;
	}

	public String getPhoneresource() {
		return phoneresource;
	}

	public void setPhoneresource(String phoneresource) {
		this.phoneresource = phoneresource;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Phones [phoneid=" + phoneid + ", posttime=" + posttime
				+ ", phonebrand=" + phonebrand + ", phonemodel=" + phonemodel
				+ ", phonetype=" + phonetype + ", phonestate=" + phonestate
				+ ", phonemark=" + phonemark + ", phoneresource="
				+ phoneresource + ", uid=" + uid + "]";
	}

}
