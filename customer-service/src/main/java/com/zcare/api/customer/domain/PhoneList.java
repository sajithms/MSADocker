package com.zcare.api.customer.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "[COMM_PhoneList]")
public class PhoneList {


	@Id
	@Column(name = "[PhoneList_Id]")
	private Integer phoneListId;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "PhoneList_Id")
	private List<Phone> phoneList = new ArrayList<>();


	public Integer getPhoneListId() {
		return phoneListId;
	}


	public void setPhoneListId(Integer phoneListId) {
		this.phoneListId = phoneListId;
	}


	public List<Phone> getPhoneList() {
		return phoneList;
	}


	public void setPhoneList(List<Phone> phoneList) {
		this.phoneList = phoneList;
	}
	

	
}
