package com.tcs.ilp.model;
import java.util.Date;

public class AddConvcBean {
	private long uid;
	private String doc;
	private String noc;
	private String comments;
	private long convictionid;
	public long getConvictionid() {
		return convictionid;
	}
	public void setConvictionid(long convictionid) {
		this.convictionid = convictionid;
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public String getDoc() {
		return doc;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}
	public String getNoc() {
		return noc;
	}
	public void setNoc(String noc) {
		this.noc = noc;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	
	

}