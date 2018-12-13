package com.zcare.api.customer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMM_Address")
public class Address {

	@Id
	@Column(name = "[Address_Id]",updatable = false, nullable = false)
	private Integer addressId;
	
	@Column(name = "[AddressList_Id]")
	private Integer addressListId;
	
	
	@Column(name="AddressLine1")
    private String addressLine1;
	
	@Column(name="AddressLine2")
    private String addressLine2;
	
	@Column(name="City")
    private String city;
	
	@Column(name="ZipCode")
    private String zipCode;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Integer getAddressListId() {
		return addressListId;
	}

	public void setAddressListId(Integer addressListId) {
		this.addressListId = addressListId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressListId=" + addressListId + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + ", city=" + city + ", zipCode=" + zipCode + "]";
	}

	
	

	
}
