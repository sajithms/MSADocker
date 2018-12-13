package com.zcare.api.customer.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "[ATT_CommunityAttendance]")
public class CommunityAttendance {

    @Id
    @Column(name = "[CommunityAttendance_Id]",updatable = false, nullable = false)
    private Integer communityAttendanceId;
    
    

  
    @Column(name="Community_Id")
    private Integer communityId;
    
    @Column(name="ReportingUser_Id")
    private Integer reportingUserId;
    
    
    @Column(name="AttendanceDate")
    private String attendanceDateString;
    
    @Column(name="ReportingDate")
    private String reportingDate;
    
    @Column(name="CoursePeriod_Id")
    private Integer coursePeriodId;
    
    
    @Column(name="ActivitySession_Id")
    private Integer activitySessionId;

    @Transient
    private Date attendanceDate;
    
    @OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CommunityAttendance_Id")
	private List<StudentAttendance> studentAttendanceList = new ArrayList<>();
    

	public List<StudentAttendance> getStudentAttendanceList() {
		return studentAttendanceList;
	}


	public void setStudentAttendanceList(List<StudentAttendance> studentAttendanceList) {
		this.studentAttendanceList = studentAttendanceList;
	}


	public Integer getCommunityAttendanceId() {
		return communityAttendanceId;
	}


	public void setCommunityAttendanceId(Integer communityAttendanceId) {
		this.communityAttendanceId = communityAttendanceId;
	}


	public Integer getCommunityId() {
		return communityId;
	}


	public void setCommunityId(Integer communityId) {
		this.communityId = communityId;
	}


	public Integer getReportingUserId() {
		return reportingUserId;
	}


	public void setReportingUserId(Integer reportingUserId) {
		this.reportingUserId = reportingUserId;
	}


	

	public String getAttendanceDateString() {
		return attendanceDateString;
	}


	public void setAttendanceDateString(String attendanceDateString) {
		this.attendanceDateString = attendanceDateString;
	}


	public String getReportingDate() {
		return reportingDate;
	}


	public void setReportingDate(String reportingDate) {
		this.reportingDate = reportingDate;
	}


	public Integer getCoursePeriodId() {
		return coursePeriodId;
	}


	public void setCoursePeriodId(Integer coursePeriodId) {
		this.coursePeriodId = coursePeriodId;
	}


	public Integer getActivitySessionId() {
		return activitySessionId;
	}


	public void setActivitySessionId(Integer activitySessionId) {
		this.activitySessionId = activitySessionId;
	}
	

	public Date getAttendanceDate() {
		if(attendanceDateString != null) {
			 try {
				return new SimpleDateFormat("yyyyMMdd").parse(attendanceDateString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		}
		
		return attendanceDate;
	}


	public void setAttendanceDate(Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}


	@Override
	public String toString() {
		return "CommunityAttendance [communityAttendanceId=" + communityAttendanceId + ", communityId=" + communityId
				+ ", reportingUserId=" + reportingUserId + ", attendanceDateString=" + attendanceDateString + ", reportingDate="
				+ reportingDate + ", coursePeriodId=" + coursePeriodId + ", activitySessionId=" + activitySessionId
				+ "]";
	}
    
    

	  
}
