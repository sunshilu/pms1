package com.example.pms.system.model;

public class CustomerModel extends BaseModel {
	private String status;
	private String email;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "CustomerModel [status=" + status + ", email=" + email + "]";
	}
}
