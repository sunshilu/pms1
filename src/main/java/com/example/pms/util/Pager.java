package com.example.pms.util;

public class Pager {

	private int pageIndex = 1;
	private int pageLimit = 10;
	private int rowStart;// limit 参数，
	private int rowCount;// limit 参数
	private boolean pageOn = false;// 是否分页
	private String orderby;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}

	public int getRowStart() {
		rowStart = (pageIndex - 1) * pageLimit;
		return rowStart;
	}

	public void setRowStart(int rowStart) {
		this.rowStart = rowStart;
	}

	public int getRowCount() {
		return pageLimit;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public boolean isPageOn() {
		return pageOn;
	}

	public void setPageOn(boolean pageOn) {
		this.pageOn = pageOn;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

}
