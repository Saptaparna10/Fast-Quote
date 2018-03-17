package com.tcs.ilp.model;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the FQ_USER database table.
 * 
 */
@Entity
@Table(name="FQ_USER")
public class FqUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private long userId;

	@Column(name="AGE_WHEN_FIRST_LICENSED")
	private int ageWhenFirstLicensed;

	@Column(name="ANNUAL_INCOME")
	private double annualIncome;

	@Column(name="CURRENT_US_LICENSE_STATUS")
	private String currentUsLicenseStatus;

    @Temporal( TemporalType.DATE)
	@Column(name="DATE_OF_BIRTH")
	private Date dateOfBirth;

	private String gender;

	@Column(name="HIGHEST_LEVEL_OF_EDUCATION")
	private String highestLevelOfEducation;

	@Column(name="MAILING_ADDRESS")
	private String mailingAddress;

	private String name;

	private String occupation;

	private long ssn;

	//bi-directional many-to-one association to FqAccidenthistory
	//@OneToMany(mappedBy="fqUser")
//	private Set<FqAccidenthistory> fqAccidenthistories;

	//bi-directional many-to-one association to FqConvictionhistory
	@OneToMany(mappedBy="fqUser")
	private Set<FqConvictionhistory> fqConvictionhistories;

    public FqUser() {
    }

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getAgeWhenFirstLicensed() {
		return this.ageWhenFirstLicensed;
	}

	public void setAgeWhenFirstLicensed(int ageWhenFirstLicensed) {
		this.ageWhenFirstLicensed = ageWhenFirstLicensed;
	}

	public double getAnnualIncome() {
		return this.annualIncome;
	}

	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getCurrentUsLicenseStatus() {
		return this.currentUsLicenseStatus;
	}

	public void setCurrentUsLicenseStatus(String currentUsLicenseStatus) {
		this.currentUsLicenseStatus = currentUsLicenseStatus;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHighestLevelOfEducation() {
		return this.highestLevelOfEducation;
	}

	public void setHighestLevelOfEducation(String highestLevelOfEducation) {
		this.highestLevelOfEducation = highestLevelOfEducation;
	}

	public String getMailingAddress() {
		return this.mailingAddress;
	}

	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public long getSsn() {
		return this.ssn;
	}

	public void setSsn(long ssn) {
		this.ssn = ssn;
	}

	/*public Set<FqAccidenthistory> getFqAccidenthistories() {
		return this.fqAccidenthistories;
	}

	public void setFqAccidenthistories(Set<FqAccidenthistory> fqAccidenthistories) {
		this.fqAccidenthistories = fqAccidenthistories;
	} */
	
	public Set<FqConvictionhistory> getFqConvictionhistories() {
		return this.fqConvictionhistories;
	}

	public void setFqConvictionhistories(Set<FqConvictionhistory> fqConvictionhistories) {
		this.fqConvictionhistories = fqConvictionhistories;
	} 
	
}