package com.redox.mobile.service.model;

public class AppRequest {
	private String email;
	private String mobile;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "AppRequest [email=" + email + ", mobile=" + mobile + "]";
	}

}
