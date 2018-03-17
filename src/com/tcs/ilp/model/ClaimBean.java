package com.tcs.ilp.model;

public class ClaimBean {
long proposalId,insuranceId;
double claimAmt;

public long getProposalId() {
	return proposalId;
}

public void setProposalId(long proposalId) {
	this.proposalId = proposalId;
}

public long getInsuranceId() {
	return insuranceId;
}

public void setInsuranceId(long insuranceId) {
	this.insuranceId = insuranceId;
}

public double getClaimAmt() {
	return claimAmt;
}

public void setClaimAmt(double claimAmt) {
	this.claimAmt = claimAmt;
}

}
