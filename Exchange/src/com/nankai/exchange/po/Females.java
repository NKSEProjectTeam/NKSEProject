package com.nankai.exchange.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Females implements Serializable {
	private int femaleid;
	private int uid;
	private Date posttime;
	private String femaletype;
	private String femalesize;
	private int femalestate;
	private String femalemark;
	private String femaleresource;

	public Females() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Females(int femaleid, int uid, Date posttime, String femaletype,
			String femalesize, int femalestate, String femalemark,
			String femaleresource) {
		super();
		this.femaleid = femaleid;
		this.uid = uid;
		this.posttime = posttime;
		this.femaletype = femaletype;
		this.femalesize = femalesize;
		this.femalestate = femalestate;
		this.femalemark = femalemark;
		this.femaleresource = femaleresource;
	}

	public int getFemaleid() {
		return femaleid;
	}

	public void setFemaleid(int femaleid) {
		this.femaleid = femaleid;
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

	public String getFemaletype() {
		return femaletype;
	}

	public void setFemaletype(String femaletype) {
		this.femaletype = femaletype;
	}

	public String getFemalesize() {
		return femalesize;
	}

	public void setFemalesize(String femalesize) {
		this.femalesize = femalesize;
	}

	public int getFemalestate() {
		return femalestate;
	}

	public void setFemalestate(int femalestate) {
		this.femalestate = femalestate;
	}

	public String getFemalemark() {
		return femalemark;
	}

	public void setFemalemark(String femalemark) {
		this.femalemark = femalemark;
	}

	public String getFemaleresource() {
		return femaleresource;
	}

	public void setFemaleresource(String femaleresource) {
		this.femaleresource = femaleresource;
	}

	@Override
	public String toString() {
		return "Females [femaleid=" + femaleid + ", uid=" + uid + ", posttime="
				+ posttime + ", femaletype=" + femaletype + ", femalesize="
				+ femalesize + ", femalestate=" + femalestate + ", femalemark="
				+ femalemark + ", femaleresource=" + femaleresource + "]";
	}

}
