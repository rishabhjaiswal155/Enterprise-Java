package pojos;

import java.time.LocalDate;

import javax.persistence.*;
@Embeddable
public class Passport {
	@Column(name = "passport_number",length=30,unique=true)
	private String passportNumber;
	@Column(name="creation_date")
	private LocalDate creationDate;
	@Column(length=30)
	private String location;
	@Column(name="expiry_date")
	private LocalDate expiryDate;
	@Column(name="issuing_country",length=40)
	private String issuingCountry;
	public Passport() {
		// TODO Auto-generated constructor stub
	}
	public Passport(String passportNumber, LocalDate creationDate, String location, LocalDate expiryDate,
			String issuingCountry) {
		super();
		this.passportNumber = passportNumber;
		this.creationDate = creationDate;
		this.location = location;
		this.expiryDate = expiryDate;
		this.issuingCountry = issuingCountry;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getIssuingCountry() {
		return issuingCountry;
	}
	public void setIssuingCountry(String issuingCountry) {
		this.issuingCountry = issuingCountry;
	}
	@Override
	public String toString() {
		return "Passport [passportNumber=" + passportNumber + ", creationDate=" + creationDate + ", location="
				+ location + ", expiryDate=" + expiryDate + ", issuingCountry=" + issuingCountry + "]";
	}
	

}
