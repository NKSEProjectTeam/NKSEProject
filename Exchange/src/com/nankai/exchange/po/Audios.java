package com.nankai.exchange.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Audios implements Serializable {
	private int audioid;
	private Date posttime;
	private String audioname;
	private String audiopublish;
	private int audiostate;
	private String audiomark;
	private String audioresource;
	private int uid;

	public Audios() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Audios(int audioid, Date posttime, String audioname,
			String audiopublish, int audiostate, String audiomark,
			String audioresource, int uid) {
		super();
		this.audioid = audioid;
		this.posttime = posttime;
		this.audioname = audioname;
		this.audiopublish = audiopublish;
		this.audiostate = audiostate;
		this.audiomark = audiomark;
		this.audioresource = audioresource;
		this.uid = uid;
	}

	public int getAudioid() {
		return audioid;
	}

	public void setAudioid(int audioid) {
		this.audioid = audioid;
	}

	public Date getPosttime() {
		return posttime;
	}

	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}

	public String getAudioname() {
		return audioname;
	}

	public void setAudioname(String audioname) {
		this.audioname = audioname;
	}

	public String getAudiopublish() {
		return audiopublish;
	}

	public void setAudiopublish(String audiopublish) {
		this.audiopublish = audiopublish;
	}

	public int getAudiostate() {
		return audiostate;
	}

	public void setAudiostate(int audiostate) {
		this.audiostate = audiostate;
	}

	public String getAudiomark() {
		return audiomark;
	}

	public void setAudiomark(String audiomark) {
		this.audiomark = audiomark;
	}

	public String getAudioresource() {
		return audioresource;
	}

	public void setAudioresource(String audioresource) {
		this.audioresource = audioresource;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Audios [audioid=" + audioid + ", posttime=" + posttime
				+ ", audioname=" + audioname + ", audiopublish=" + audiopublish
				+ ", audiostate=" + audiostate + ", audiomark=" + audiomark
				+ ", audioresource=" + audioresource + ", uid=" + uid + "]";
	}

}
