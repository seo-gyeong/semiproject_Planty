package com.planty.jsp.user.model.dto;

public class AuthDTO {

	
	private int authNo;
	private String authName;
	
	public AuthDTO() {}

	public AuthDTO(int authNo, String authName) {
		super();
		this.authNo = authNo;
		this.authName = authName;
	}

	public int getAuthNo() {
		return authNo;
	}

	public void setAuthNo(int authNo) {
		this.authNo = authNo;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	@Override
	public String toString() {
		return "AuthDTO [authNo=" + authNo + ", authName=" + authName + "]";
	}
	
	
}
