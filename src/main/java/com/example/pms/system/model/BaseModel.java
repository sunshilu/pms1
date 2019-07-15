package com.example.pms.system.model;

import com.example.pms.util.Pager;

public class BaseModel extends Pager {
	private Integer id;
	private String createTime;
	private String updateTime;
	private Integer createBy;//创建人（一般为用户表主键）
	private Integer updateBy;//更新人（用户表主键）
	private Integer deleted=0;//删除标志（0未删除，1已经删除）
	private Integer state =1;//状态标志（0禁用，1可用）
	private Double order;//排序序号（小数类型）
	private String name;
	private String code;
	private String description;
	private Integer type;//类型（一般为字典表主键）
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	public Integer getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Double getOrder() {
		return order;
	}
	public void setOrder(Double order) {
		this.order = order;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "BaseModel [id=" + id + ", createTime=" + createTime + ", updateTime=" + updateTime + ", createBy="
				+ createBy + ", updateBy=" + updateBy + ", deleted=" + deleted + ", state=" + state + ", order=" + order
				+ ", name=" + name + ", code=" + code + ", description=" + description + ", type=" + type + "]";
	}
	

}
