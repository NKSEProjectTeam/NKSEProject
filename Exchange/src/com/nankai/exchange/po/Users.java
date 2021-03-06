package com.nankai.exchange.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Users implements Serializable {
	private int userid;
	private String username;
	private String userpwd;
	private String usernum;
	private String usermail;
	private int sex;
	private Date regtime;
	private int score;
	private String resource;
	private String mark;
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int userid, String username, String userpwd, String usernum,
			String usermail, int sex, Date regtime, int score, String resource,
			String mark) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
		this.usernum = usernum;
		this.usermail = usermail;
		this.sex = sex;
		this.regtime = regtime;
		this.score = score;
		this.resource = resource;
		this.mark = mark;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUsernum() {
		return usernum;
	}
	public void setUsernum(String usernum) {
		this.usernum = usernum;
	}
	public String getUsermail() {
		return usermail;
	}
	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public Date getRegtime() {
		return regtime;
	}
	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	@Override
	public String toString() {
		return "Users [userid=" + userid + ", username=" + username
				+ ", userpwd=" + userpwd + ", usernum=" + usernum
				+ ", usermail=" + usermail + ", sex=" + sex + ", regtime="
				+ regtime + ", score=" + score + ", resource=" + resource
				+ ", mark=" + mark + "]";
	}
	

}
