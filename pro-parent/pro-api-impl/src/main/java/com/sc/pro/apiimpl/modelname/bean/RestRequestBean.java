package com.sc.pro.apiimpl.modelname.bean;

import net.sf.json.JSONObject;

import com.sc.pro.api.modelname.vo.SohoServiceConfigVO;

public class RestRequestBean {

	private JSONObject inputValue;
	private SohoServiceConfigVO sohoServiceConfigVO;
	private RestService serviceClass;// 服务对象实例
	private String lang;

	public JSONObject getInputValue() {
		return inputValue;
	}

	public void setInputValue(JSONObject inputValue) {
		this.inputValue = inputValue;
	}

	public SohoServiceConfigVO getSohoServiceConfigVO() {
		return sohoServiceConfigVO;
	}

	public void setSohoServiceConfigVO(SohoServiceConfigVO sohoServiceConfigVO) {
		this.sohoServiceConfigVO = sohoServiceConfigVO;
	}

	public RestService getServiceClass() {
		return serviceClass;
	}

	public void setServiceClass(RestService serviceClass) {
		this.serviceClass = serviceClass;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}
	
}
 