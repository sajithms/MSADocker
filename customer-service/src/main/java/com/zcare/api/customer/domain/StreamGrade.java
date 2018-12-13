package com.zcare.api.customer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "[ADM_StreamGrade]")
public class StreamGrade {

    @Id
    @Column(name = "StreamGrade_Id",updatable = false, nullable = false)
    private Integer streamGradeId;
    
    
   

  
    @Column(name="Name")
    private String name;
    
    @Column(name="Title")
    private String title;
    
    
    @Column(name="Position")
    private String position;


	public Integer getStreamGradeId() {
		return streamGradeId;
	}


	public void setStreamGradeId(Integer streamGradeId) {
		this.streamGradeId = streamGradeId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	@Override
	public String toString() {
		return "StreamGrade [streamGradeId=" + streamGradeId + ", name=" + name + ", title=" + title + ", position="
				+ position + "]";
	}
    
   

  
}
