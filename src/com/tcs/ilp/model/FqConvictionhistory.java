package com.tcs.ilp.model;
import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;


/**
 * The persistent class for the FQ_CONVICTIONHISTORY database table.
 * 
 */
@Entity
@Table(name="FQ_CONVICTIONHISTORY")
public class FqConvictionhistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CONVICTION_HISTORY_ID")
	private long convictionHistoryId;
	
	

	private String comments;

    @Temporal( TemporalType.DATE)
	@Column(name="DATE_OF_CONVICTION")
	private Date dateOfConviction;

	@Column(name="NATURE_OF_CONVICTION")
	private String natureOfConviction;
	
	@Transient
	private ArrayList<FqConvictionhistory> list ;

	public ArrayList<FqConvictionhistory> getList() {
		return list;
	}

	public void setList(ArrayList<FqConvictionhistory> list) {
		this.list = list;
	}

	//bi-directional many-to-one association to FqUser
    @ManyToOne
	@JoinColumn(name="USER_ID")
	private FqUser fqUser;

    public FqConvictionhistory() {
    }

	public long getConvictionHistoryId() {
		return this.convictionHistoryId;
	}

	public void setConvictionHistoryId(long convictionHistoryId) {
		this.convictionHistoryId = convictionHistoryId;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getDateOfConviction() {
		return this.dateOfConviction;
	}

	public void setDateOfConviction(Date dateOfConviction) {
		this.dateOfConviction = dateOfConviction;
	} 

	public String getNatureOfConviction() {
		return this.natureOfConviction;
	}

	public void setNatureOfConviction(String natureOfConviction) {
		this.natureOfConviction = natureOfConviction;
	}

	public FqUser getFqUser() {
		return this.fqUser;
	}

	public void setFqUser(FqUser fqUser) {
		this.fqUser = fqUser;
	}
	
}