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
@Table(name = "[COMM_AddressList]")
public class AddressList {

	@Id
	@Column(name = "[AddressList_Id]")
	private Integer addressListId;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "AddressList_Id")
	private List<Address> addressList = new ArrayList<>();

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public Integer getAddressListId() {
		return addressListId;
	}

	public void setAddressListId(Integer addressListId) {
		this.addressListId = addressListId;
	}
	
	
	
	

	
}
