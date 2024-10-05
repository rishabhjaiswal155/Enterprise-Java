package com.app.pojos;
import javax.persistence.*;
@Entity
@Table(name="address")
public class Address extends BaseEntity {
	@Column(name="address_line1",length = 30)
	private String addressLine1;
	@Column(name="address_line2",length = 30)
	private String addressLine2;
	@Column(length = 30)
	private String city;
	@Column(length = 30)
	private String state;
	@Column(length = 30)
	private String country;
	@Column(name="zip_code" ,length = 30)
	private String zipCode;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id",nullable=false)
	@MapsId
    private User user;
    public Address() {
		// TODO Auto-generated constructor stub
	}
    
	public Address(String addressLine1, String addressLine2, String city, String state, String country,
			String zipCode) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}

	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "AddressId="+getId()+",addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", zipCode=" + zipCode;
	}
    
}