package com.zcare.api.customer.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Class representing a person in the Almanhal application. The person can be student, parent, teacher or staff (school as well as Ministry")
@Entity
@Table(name = "COMM_Person")
public class Person {
	@ApiModelProperty(notes = "Unique identifier of the person. No two persons can have the same id.", example = "1", required = true, position = 0)
    @Id
    @Column(name = "Person_Id",updatable = false, nullable = false)
    private Integer personId;

  
    @Column(name="EnglishFirstName")
    private String englishFirstName;
    
    @Column(name="EnglishSecondName")
    private String englishSecondName;
    
    
    @Column(name="EnglishThirdName")
    private String englishThirdName;
    
    @Column(name="EnglishFourthName")
    private String englishFourthName;
    
    
    @Column(name="EnglishFamilyName")
    private String englishFamilyName;
    
    
    @Column(name="Civility")
    private String civility;
    
    
    @Column(name="IDNumber")
    private String idNumber;
    
    @Column(name="FirstName")
    private String firstName;
    
    @Column(name="SecondName")
    private String secondName;
    
    
    @Column(name="ThirdName")
    private String thirdName;
    

    @Column(name="BirthName")
    private String birthName;
    
    @Column(name="BirthDate")
    private String birthDate;
    
    @Column(name="BirthCity")
    private String birthCity;
    
    @Column(name="EnglishBirthCity")
    private String englishBirthCity;
    
    @Column(name="BirthCountry")
    private String birthCountry;
    
    @Column(name="Nationality")
    private String nationality;
    
    @Column(name="Gender")
    private Integer gender;
 
    @Column(name="MaritalStatus")
    private Integer maritalStatus;
    
    @Column(name="Photo_Id")
    private Integer photo_Id;
    
    @Column(name="Religion")
    private Integer religion;
    
    @Column(name="ReligionSector")
    private Integer religionSector;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AddressList_Id")
    private AddressList addressList;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PhoneList_Id")
    private PhoneList phoneList;
 
    
    public PhoneList getPhoneList() {
		return phoneList;
	}


	public void setPhoneList(PhoneList phoneList) {
		this.phoneList = phoneList;
	}


	public AddressList getAddressList() {
		return addressList;
	}


	public void setAddressList(AddressList addressList) {
		this.addressList = addressList;
	}


	@Column(name="OtherIdList_Id")
    private Integer otherIdListId;
    
    
    @Column(name="User_Id")
    private Integer userId;
    
    @Column(name="UserStamp")
    private Integer userStamp;
    
    
    @Column(name="TimeStamp")
    private String timeStamp;
    
    @Column(name="ExternalID")
    private String externalId;
 
    
    @Column(name="IsDeleted")
    private boolean isDeleted;
    

    
   
    


	public Integer getPersonId() {
		return personId;
	}


	public void setPersonId(Integer personId) {
		this.personId = personId;
	}


	public String getEnglishFirstName() {
		return englishFirstName;
	}


	public void setEnglishFirstName(String englishFirstName) {
		this.englishFirstName = englishFirstName;
	}


	public String getEnglishSecondName() {
		return englishSecondName;
	}


	public void setEnglishSecondName(String englishSecondName) {
		this.englishSecondName = englishSecondName;
	}


	public String getEnglishThirdName() {
		return englishThirdName;
	}


	public void setEnglishThirdName(String englishThirdName) {
		this.englishThirdName = englishThirdName;
	}


	public String getEnglishFourthName() {
		return englishFourthName;
	}


	public void setEnglishFourthName(String englishFourthName) {
		this.englishFourthName = englishFourthName;
	}


	public String getEnglishFamilyName() {
		return englishFamilyName;
	}


	public void setEnglishFamilyName(String englishFamilyName) {
		this.englishFamilyName = englishFamilyName;
	}


	public String getCivility() {
		return civility;
	}


	public void setCivility(String civility) {
		this.civility = civility;
	}


	public String getIdNumber() {
		return idNumber;
	}


	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getSecondName() {
		return secondName;
	}


	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}


	public String getThirdName() {
		return thirdName;
	}


	public void setThirdName(String thirdName) {
		this.thirdName = thirdName;
	}


	public String getBirthName() {
		return birthName;
	}


	public void setBirthName(String birthName) {
		this.birthName = birthName;
	}


	public String getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}


	public String getBirthCity() {
		return birthCity;
	}


	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}


	public String getEnglishBirthCity() {
		return englishBirthCity;
	}


	public void setEnglishBirthCity(String englishBirthCity) {
		this.englishBirthCity = englishBirthCity;
	}


	public String getBirthCountry() {
		return birthCountry;
	}


	public void setBirthCountry(String birthCountry) {
		this.birthCountry = birthCountry;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	public Integer getGender() {
		return gender;
	}


	public void setGender(Integer gender) {
		this.gender = gender;
	}


	public Integer getMaritalStatus() {
		return maritalStatus;
	}


	public void setMaritalStatus(Integer maritalStatus) {
		this.maritalStatus = maritalStatus;
	}


	public Integer getPhoto_Id() {
		return photo_Id;
	}


	public void setPhoto_Id(Integer photo_Id) {
		this.photo_Id = photo_Id;
	}


	public Integer getReligion() {
		return religion;
	}


	public void setReligion(Integer religion) {
		this.religion = religion;
	}


	public Integer getReligionSector() {
		return religionSector;
	}


	public void setReligionSector(Integer religionSector) {
		this.religionSector = religionSector;
	}



	public Integer getOtherIdListId() {
		return otherIdListId;
	}


	public void setOtherIdListId(Integer otherIdListId) {
		this.otherIdListId = otherIdListId;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getUserStamp() {
		return userStamp;
	}


	public void setUserStamp(Integer userStamp) {
		this.userStamp = userStamp;
	}


	public String getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}


	public String getExternalId() {
		return externalId;
	}


	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}


	public boolean isDeleted() {
		return isDeleted;
	}


	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}


	@Override
	public String toString() {
		return "Person [personId=" + personId + ", englishFirstName=" + englishFirstName + ", englishSecondName="
				+ englishSecondName + ", englishThirdName=" + englishThirdName + ", firstName=" + firstName
				+ ", secondName=" + secondName + ", nationality=" + nationality + ", gender=" + gender
				+ ", maritalStatus=" + maritalStatus + ", userId=" + userId + ", externalId=" + externalId + "]";
	}




	
  
}
