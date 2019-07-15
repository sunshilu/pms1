package com.example.pms.system.model;

public class UserModel extends BaseModel {
	private String password;
	private String roleCode;
	private String parentCode;

	private String parentName;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	@Override
	public String toString() {
		return "UserModel [password=" + password + ", roleCode=" + roleCode + ", parentCode=" + parentCode
				+ ", parentName=" + parentName + "]";
	}
	public UserModel(String password, String roleCode, String parentCode) {
		super();
		this.password = password;
		this.roleCode = roleCode;
		this.parentCode = parentCode;
	}
	public UserModel() {
		super();
	}
}
