package com.tcs.ilp.model;

public class QuoteBean {
	long quote_id,proposal_id,insurance_id,accident_history_id, conviction_history_id,user_id;
	
	public long getQuote_id() {
		return quote_id;
	}
	public void setQuote_id(long quote_id) {
		this.quote_id = quote_id;
	}
	String status;
	boolean isValid=false;
	double quote,deduction,claim;
	
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public long getProposal_id() {
		return proposal_id;
	}
	public boolean isValid() {
		return isValid;
	}
	public double getClaim() {
		return claim;
	}
	public void setClaim(double claim) {
		this.claim = claim;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public void setProposal_id(long proposalId) {
		proposal_id = proposalId;
	}
	public long getInsurance_id() {
		return insurance_id;
	}
	public void setInsurance_id(long insuranceId) {
		insurance_id = insuranceId;
	}
	public long getAccident_history_id() {
		return accident_history_id;
	}
	public void setAccident_history_id(long accidentHistoryId) {
		accident_history_id = accidentHistoryId;
	}
	public long getConviction_history_id() {
		return conviction_history_id;
	}
	public void setConviction_history_id(long convictionHistoryId) {
		conviction_history_id = convictionHistoryId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getQuote() {
		return quote;
	}
	public void setQuote(double quote) {
		this.quote = quote;
	}
	public double getDeduction() {
		return deduction;
	}
	public void setDeduction(double deduction) {
		this.deduction = deduction;
	}
	
}
