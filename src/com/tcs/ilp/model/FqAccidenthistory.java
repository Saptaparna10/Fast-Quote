package com.tcs.ilp.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;


/**
 * The persistent class for the FQ_ACCIDENTHISTORY database table.
 * 
 */
@Entity
@Table(name="FQ_ACCIDENTHISTORY")
public class FqAccidenthistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ACCIDENT_HISTORY_ID")
	private long accidentHistoryId;

	private String comments;

	@Transient
	private ArrayList<FqAccidenthistory> list ;
	
    public ArrayList<FqAccidenthistory> getList() {
		return list;
	}

	public void setList(ArrayList<FqAccidenthistory> list) {
		this.list = list;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Temporal( TemporalType.DATE)
	@Column(name="DATE_OF_ACCIDENT")
	private Date dateOfAccident;

	@Column(name="NATURE_OF_ACCIDENT")
	private String natureOfAccident;

	//bi-directional many-to-one association to FqUser
    @ManyToOne
	@JoinColumn(name="USER_ID")
	private FqUser fqUser;

	//bi-directional many-to-one association to FqVehicle
    @ManyToOne
	@JoinColumn(name="VEHICLE_ID")
	private FqVehicle fqVehicle;

    public FqAccidenthistory() {
    }

	public long getAccidentHistoryId() {
		return this.accidentHistoryId;
	}

	public void setAccidentHistoryId(long accidentHistoryId) {
		this.accidentHistoryId = accidentHistoryId;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getDateOfAccident() {
		return this.dateOfAccident;
	}

	public void setDateOfAccident(Date dateOfAccident) {
		this.dateOfAccident = dateOfAccident;
	}

	public String getNatureOfAccident() {
		return this.natureOfAccident;
	}

	public void setNatureOfAccident(String natureOfAccident) {
		this.natureOfAccident = natureOfAccident;
	}

	public FqUser getFqUser() {
		return this.fqUser;
	}

	public void setFqUser(FqUser fqUser) {
		this.fqUser = fqUser;
	}
	
	public FqVehicle getFqVehicle() {
		return this.fqVehicle;
	}

	public void setFqVehicle(FqVehicle fqVehicle) {
		this.fqVehicle = fqVehicle;
	}
	
}