package com.zcare.api.customer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "[COMM_Phone]")
public class Phone {

	@Id
	@Column(name = "[Phone_Id]",updatable = false, nullable = false)
	private Integer phoneId;
	
	@Column(name = "[PhoneList_Id]")
	private Integer phoneListId;
	
	
	@Column(name="Name")
    private String name;
	
	@Column(name="ContactType")
    private String contactType;
	
	@Column(name="Value")
    private String value;

	public Integer getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(Integer phoneId) {
		this.phoneId = phoneId;
	}

	public Integer getPhoneListId() {
		return phoneListId;
	}

	public void setPhoneListId(Integer phoneListId) {
		this.phoneListId = phoneListId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Phone [phoneId=" + phoneId + ", phoneListId=" + phoneListId + ", name=" + name + ", contactType="
				+ contactType + ", value=" + value + "]";
	}
	
	
	
	

	
}
