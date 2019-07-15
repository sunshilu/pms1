package com.example.pms.system.model;

public class CommunicationModel extends BaseModel {
	private String userCode;
	private String customerCode;
	private String time;
	private String content;
	
	private UserModel userModel;
	private CustomerModel customerModel;
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	public CustomerModel getCustomerModel() {
		return customerModel;
	}
	public void setCustomerModel(CustomerModel customerModel) {
		this.customerModel = customerModel;
	}
	@Override
	public String toString() {
		return "CommunicationModel [userCode=" + userCode + ", customerCode=" + customerCode + ", time=" + time
				+ ", content=" + content + ", userModel=" + userModel + ", customerModel=" + customerModel + "]";
	}
	
}
