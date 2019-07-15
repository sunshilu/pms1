package com.example.pms.system.model;

public class ProductModel extends BaseModel {
	private String sum;
	private String cost;
	public String getSum() {
		return sum;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "ProductModel [sum=" + sum + ", cost=" + cost + "]";
	}
}
