package com.example.pms.system.model;

import java.util.ArrayList;
import java.util.List;

public class MenuModel extends BaseModel {
	private String url;
	private String parentCode;
	private String level;
	
	private String parentName;
	
	private List<MenuModel> child=new ArrayList<>();

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	

	public List<MenuModel> getChild() {
		return child;
	}

	public void setChild(List<MenuModel> child) {
		this.child = child;
	}
	

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	@Override
	public String toString() {
		return "MenuModel [url=" + url + ", parentCode=" + parentCode + ", level=" + level + ", parentName="
				+ parentName + ", child=" + child + "]";
	}

}
