package com.example.pms.system.model;

public class RootModel extends BaseModel {
	private String roleCode;
	private String menuCode;
	private RoleModel roleModel;
	private MenuModel menuModel;
	
	private String orderBy;
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public RoleModel getRoleModel() {
		return roleModel;
	}
	public void setRoleModel(RoleModel roleModel) {
		this.roleModel = roleModel;
	}
	public MenuModel getMenuModel() {
		return menuModel;
	}
	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}
	
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	@Override
	public String toString() {
		return "RootModel [roleCode=" + roleCode + ", menuCode=" + menuCode + ", roleModel=" + roleModel
				+ ", menuModel=" + menuModel + ", orderBy=" + orderBy + "]";
	}
	

}
