package com.zcare.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

@Entity
//@Table(name = "users")
@Table(name = "[SYS_User]")
public class User {
	 @Id
    @Column(name = "User_Id",updatable = false, nullable = false)
	private Integer userId;
   
    public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "UserName",updatable = false, nullable = false)
    private String username;

    @Column(name="UserPassword")
    private String password;

 
    @Transient
    private boolean activated=true;

    
    @Column(name="LastLoginDate")
    private String lastLoginDate;
    
    
    @Column(name="LastFailedLoginDate")
    private String lastFailedLoginDate;
    
    
    @Column(name="NumberOfFailedLogins")
    private int numberOfFailedLogins;
    
    
    

 

   

	public String getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLastFailedLoginDate() {
		return lastFailedLoginDate;
	}

	public void setLastFailedLoginDate(String lastFailedLoginDate) {
		this.lastFailedLoginDate = lastFailedLoginDate;
	}

	public int getNumberOfFailedLogins() {
		return numberOfFailedLogins;
	}

	public void setNumberOfFailedLogins(int numberOfFailedLogins) {
		this.numberOfFailedLogins = numberOfFailedLogins;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

   

   

    @Override
    public boolean equals(Object o) {
    	boolean resullt = true;
        if (this != o) resullt= false;
        if (o == null || getClass() != o.getClass()) resullt= false;

        User user = (User) o;

        if (user != null && !username.equals(user.username)) resullt= false;

        return resullt;
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", activated="
				+ activated + ", lastLoginDate=" + lastLoginDate + ", lastFailedLoginDate=" + lastFailedLoginDate
				+ ", numberOfFailedLogins=" + numberOfFailedLogins + "]";
	}

	
  
}
