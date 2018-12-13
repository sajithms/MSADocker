package com.zcare.api.customer.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "[ADM_Enrollment]")
public class Enrollment {

    @Id
    @Column(name = "Enrollment_Id",updatable = false, nullable = false)
    private Integer enrollmentId;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "School_Id")
    private Site site;

    
    @Column(name="Student_Id")
    private Integer studentId;
    
  
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "StreamGrade_Id")
    private StreamGrade streamGrade;
    
    
 
    
    
    
    @Column(name="Community_Id")
    private Integer communityId;
    
    
    @Column(name="EnrollmentType")
    private Integer enrollmentType;
    
    @Column(name="EntryType")
    private Integer entryType;
    
    @Column(name="EntryDate")
    private String entryDate;
    
    @Column(name="ExitType")
    private Integer exitType;
    
    @Column(name="ExitReason")
    private String exitReason;
    
    
    @Column(name="ExitDate")
    private String exitDate;


	public Integer getEnrollmentId() {
		return enrollmentId;
	}


	public void setEnrollmentId(Integer enrollmentId) {
		this.enrollmentId = enrollmentId;
	}


	public Site getSite() {
		return site;
	}


	public void setSite(Site site) {
		this.site = site;
	}


	public Integer getStudentId() {
		return studentId;
	}


	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}


	public StreamGrade getStreamGrade() {
		return streamGrade;
	}


	public void setStreamGrade(StreamGrade streamGrade) {
		this.streamGrade = streamGrade;
	}


	public Integer getCommunityId() {
		return communityId;
	}


	public void setCommunityId(Integer communityId) {
		this.communityId = communityId;
	}


	public Integer getEnrollmentType() {
		return enrollmentType;
	}


	public void setEnrollmentType(Integer enrollmentType) {
		this.enrollmentType = enrollmentType;
	}


	public Integer getEntryType() {
		return entryType;
	}


	public void setEntryType(Integer entryType) {
		this.entryType = entryType;
	}


	public String getEntryDate() {
		return entryDate;
	}


	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}


	public Integer getExitType() {
		return exitType;
	}


	public void setExitType(Integer exitType) {
		this.exitType = exitType;
	}


	public String getExitReason() {
		return exitReason;
	}


	public void setExitReason(String exitReason) {
		this.exitReason = exitReason;
	}


	public String getExitDate() {
		return exitDate;
	}


	public void setExitDate(String exitDate) {
		this.exitDate = exitDate;
	}


	@Override
	public String toString() {
		return "Enrollment [enrollmentId=" + enrollmentId + ", site=" + site + ", studentId=" + studentId
				+ ", streamGrade=" + streamGrade + ", communityId=" + communityId + ", enrollmentType=" + enrollmentType
				+ ", entryType=" + entryType + ", entryDate=" + entryDate + ", exitType=" + exitType + ", exitReason="
				+ exitReason + ", exitDate=" + exitDate + "]";
	}
    
    

	  
}
