package com.zcare.api.customer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "[ATT_StudentAttendance]")
public class StudentAttendance {

    @Id
    @Column(name = "StudentAttendance_Id",updatable = false, nullable = false)
    private Integer studentAttendanceId;
    
  
 
    @Column(name = "CommunityAttendance_Id")
    private int communityAttendanceId;
	
    
    @Column(name="Student_Id")
    private Integer studentId;
    
  
    @Column(name="Excuse_Id")
    private Integer excuseId;
    
    
    @Column(name="IsAbsent")
    private Boolean ssAbsent;
    
   
    
    @Column(name="Note")
    private String note;



	public Integer getStudentAttendanceId() {
		return studentAttendanceId;
	}



	public void setStudentAttendanceId(Integer studentAttendanceId) {
		this.studentAttendanceId = studentAttendanceId;
	}





	public int getCommunityAttendanceId() {
		return communityAttendanceId;
	}



	public void setCommunityAttendanceId(int communityAttendanceId) {
		this.communityAttendanceId = communityAttendanceId;
	}



	public Integer getStudentId() {
		return studentId;
	}



	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}



	public Integer getExcuseId() {
		return excuseId;
	}



	public void setExcuseId(Integer excuseId) {
		this.excuseId = excuseId;
	}



	public Boolean getSsAbsent() {
		return ssAbsent;
	}



	public void setSsAbsent(Boolean ssAbsent) {
		this.ssAbsent = ssAbsent;
	}



	public String getNote() {
		return note;
	}



	public void setNote(String note) {
		this.note = note;
	}



	
   	  
}
