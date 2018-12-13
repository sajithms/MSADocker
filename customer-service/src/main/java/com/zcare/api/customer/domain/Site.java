package com.zcare.api.customer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "[STRUCT_Site]")
public class Site {

    @Id
    @Column(name = "Site_Id",updatable = false, nullable = false)
    private Integer siteId;
    
    

  
    @Column(name="Name")
    private String name;
    
    @Column(name="EnglishName")
    private String englishName;
    
    
    @Column(name="ShortName")
    private String shortName;
    
    @Column(name="Manager_Id")
    private Integer managerId;

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "Site [siteId=" + siteId + ", name=" + name + ", englishName=" + englishName + ", shortName=" + shortName
				+ ", managerId=" + managerId + "]";
	}

	

  
}
