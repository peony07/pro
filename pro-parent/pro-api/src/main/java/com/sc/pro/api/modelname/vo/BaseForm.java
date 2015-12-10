package com.sc.pro.api.modelname.vo;

import java.io.Serializable;


public class BaseForm implements Serializable  {

	private static final long serialVersionUID = 1L;

	private String actionType;

	private String functionType;

	private int currentPage = 1;

	private int pageCount;

	private int rowCount = returnRowCount();

	private long totalCount;

	private String formName;

	private int startPos;

	private int endPos;

	private String orderCol;

	private String order;

	private boolean showQuery = true;

	private boolean readonly;

	private Object busineseObject;

	public int getCurrentPage() {
		return currentPage;
	}

	private int returnRowCount() {
		return 10;
	}

	public void setCurrentPage(int currentPage) {
		if (currentPage <= 0) {
			this.currentPage = 1;
		} else {
			this.currentPage = currentPage;
		}
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public int getPageCount() {
		return (int) (totalCount % rowCount == 0 ? totalCount / rowCount : totalCount / rowCount + 1);
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		if (rowCount <= 0) {
			this.rowCount = 10;
		} else {
			this.rowCount = rowCount;
		}
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getFunctionType() {
		return functionType;
	}

	public void setFunctionType(String functionType) {
		this.functionType = functionType;
	}

	public int getEndPos() {
		// return endPos;
		return currentPage * rowCount;
	}

	public void setEndPos(int endPos) {
		this.endPos = endPos;
	}

	public int getStartPos() {
		// return startPos;
		return (currentPage - 1) * rowCount + 0;
	}

	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}

	public String getOrderCol() {
		if (this.orderCol != null) {
			return orderCol;
		} else {
			return "";
		}
	}

	public void setOrderCol(String orderCol) {
		this.orderCol = orderCol;
	}


	public void setOrder(String order) {
		this.order = order;
	}

	public Object getBusineseObject() {
		return busineseObject;
	}

	public void setBusineseObject(Object busineseObject) {
		this.busineseObject = busineseObject;
	}

	public boolean isShowQuery() {
		return showQuery;
	}

	public void setShowQuery(boolean showQuery) {
		this.showQuery = showQuery;
	}

	public boolean isReadonly() {
		return readonly;
	}

	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}
 
}
