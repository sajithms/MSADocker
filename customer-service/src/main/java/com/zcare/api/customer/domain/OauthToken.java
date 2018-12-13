package com.zcare.api.customer.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OauthToken implements Serializable{
	
	@JsonProperty("access_token")
	String accessToken;
	
	@JsonProperty("token_type")
	String tokenType;
	
	@JsonProperty("refresh_token")
	String refreshToken;
	
	@JsonProperty("expires_in")
	String expiresIn;
	
	@JsonProperty("scope")
	String scope;
	
	@JsonProperty("number_of_failedlogins")
	int numberofFailedLogins;
	
	@JsonProperty("user_name")
	String userName;
	
	@JsonProperty("user_id")
	String userId;
	
	@JsonProperty("error")
	String error;
	
	@JsonProperty("error_description")
	String errorDescription;
	

	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public int getNumberofFailedLogins() {
		return numberofFailedLogins;
	}

	public void setNumberofFailedLogins(int numberofFailedLogins) {
		this.numberofFailedLogins = numberofFailedLogins;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "OauthToken [accessToken=" + accessToken + ", tokenType=" + tokenType + ", refreshToken=" + refreshToken
				+ ", expiresIn=" + expiresIn + ", scope=" + scope + ", numberofFailedLogins=" + numberofFailedLogins
				+ ", userName=" + userName + ", userId=" + userId + "]";
	}
	
	

}
