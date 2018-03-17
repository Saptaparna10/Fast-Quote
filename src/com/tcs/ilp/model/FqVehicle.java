package com.tcs.ilp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the FQ_VEHICLE database table.
 * 
 */
@Entity
@Table(name="FQ_VEHICLE")
public class FqVehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="VEHICLE_ID")
	private long vehicleId;

	private String make;

	private String model;

	@Column(name="ON_ROAD_PRICE")
	private double onRoadPrice;

	@Column(name="TYPE_IN")
	private String typeIn;

	@Column(name="USER_ID")
	private java.math.BigDecimal userId;

	@Column(name="YEAR_OF_MANUFACTURE")
	private int yearOfManufacture;

	//bi-directional many-to-one association to FqAccidenthistory
	@OneToMany(mappedBy="fqVehicle")
	private Set<FqAccidenthistory> fqAccidenthistories;

    public FqVehicle() {
    }

	public long getVehicleId() {
		return this.vehicleId;
	}

	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getMake() {
		return this.make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getOnRoadPrice() {
		return this.onRoadPrice;
	}

	public void setOnRoadPrice(double onRoadPrice) {
		this.onRoadPrice = onRoadPrice;
	}

	public String getTypeIn() {
		return this.typeIn;
	}

	public void setTypeIn(String typeIn) {
		this.typeIn = typeIn;
	}

	public java.math.BigDecimal getUserId() {
		return this.userId;
	}

	public void setUserId(java.math.BigDecimal userId) {
		this.userId = userId;
	}

	public int getYearOfManufacture() {
		return this.yearOfManufacture;
	}

	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}

	public Set<FqAccidenthistory> getFqAccidenthistories() {
		return this.fqAccidenthistories;
	}

	public void setFqAccidenthistories(Set<FqAccidenthistory> fqAccidenthistories) {
		this.fqAccidenthistories = fqAccidenthistories;
	}
	
}