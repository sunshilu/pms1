package com.example.pms.system.model;

public class OrderModel extends BaseModel {
	private String userCode;
	private String customerCode;
	private String productCode;
	private String count;
	private String time;
	private String status;
	
	private UserModel userModel;
	private CustomerModel customerModel;
	private ProductModel productModel;
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
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	
	public ProductModel getProductModel() {
		return productModel;
	}
	public void setProductModel(ProductModel productModel) {
		this.productModel = productModel;
	}
	@Override
	public String toString() {
		return "OrderModel [userCode=" + userCode + ", customerCode=" + customerCode + ", productCode=" + productCode
				+ ", count=" + count + ", time=" + time + ", status=" + status + ", userModel=" + userModel
				+ ", customerModel=" + customerModel + ", productModel=" + productModel + "]";
	}
}
