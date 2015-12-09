package com.sc.pro.apiimpl.modelname.bean;

import net.sf.json.JSONObject;

public class RestResponseBean {

	private String status;
	private String errorCode;
	private Object results;

	public void RestResultBean() {
		status = "N";
		errorCode = "该接口暂未实现";
		results = null;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public Object getResults() {
		return results;
	}

	public void setResults(Object results) {
		this.results = results;
	}

	public String toJson() {
		return JSONObject.fromObject(this).toString();
	}

}
