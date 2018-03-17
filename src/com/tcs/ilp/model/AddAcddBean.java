package com.tcs.ilp.model;
public class AddAcddBean {
	
	
	private long acc_id,user_id,veh_id;
	private String doa,nac,comments;
	public long getAcc_id() {
		return acc_id;
	}
	public void setAcc_id(long acc_id) {
		this.acc_id = acc_id;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public long getVeh_id() {
		return veh_id;
	}
	public void setVeh_id(long veh_id) {
		this.veh_id = veh_id;
	}
	public String getDoa() {
		return doa;
	}
	public void setDoa(String doa) {
		this.doa = doa;
	}
	public String getNac() {
		return nac;
	}
	public void setNac(String nac) {
		this.nac = nac;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

}
