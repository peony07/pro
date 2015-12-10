package com.sc.pro.api.modelname.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public class SohoServiceConfigVO implements Serializable  {
	private String id;

	private String serviceCode;

	private String serviceName;

	private String serviceType;

	private String serviceAuth;

	private String serviceEnabled;

	private String serviceParam;

	private String returnType;

	private String readOnly;

	private String subQuery;

	private String multLangField;

	private String serviceContent;

	private List paramsList;// 参数列表
	
	private List multLangFieldList;
	
	private Map<String, String> subServices;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode == null ? null : serviceCode.trim();
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName == null ? null : serviceName.trim();
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType == null ? null : serviceType.trim();
	}

	public String getServiceAuth() {
		return serviceAuth;
	}

	public void setServiceAuth(String serviceAuth) {
		this.serviceAuth = serviceAuth == null ? null : serviceAuth.trim();
	}

	public String getServiceEnabled() {
		return serviceEnabled;
	}

	public void setServiceEnabled(String serviceEnabled) {
		this.serviceEnabled = serviceEnabled == null ? null : serviceEnabled.trim();
	}

	public String getServiceParam() {
		return serviceParam;
	}

	public void setServiceParam(String serviceParam) {
		this.serviceParam = serviceParam == null ? null : serviceParam.trim();
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType == null ? null : returnType.trim();
	}

	public boolean isReadOnly() {
		return "Y".equals(this.readOnly) ? true : false;
	}

	public void setReadOnly(String readOnly) {
		this.readOnly = readOnly == null ? null : readOnly.trim();
	}

	public String getSubQuery() {
		return subQuery;
	}

	public void setSubQuery(String subQuery) {
		this.subQuery = subQuery == null ? null : subQuery.trim();
	}

	public String getMultLangField() {
		return multLangField;
	}

	public void setMultLangField(String multLangField) {
		this.multLangField = multLangField == null ? null : multLangField.trim();
	}

	public String getServiceContent() {
		return serviceContent;
	}

	public void setServiceContent(String serviceContent) {
		this.serviceContent = serviceContent == null ? null : serviceContent.trim();
	}

	public List getParamsList() {
		return paramsList;
	}

	public void setParamsList(List paramsList) {
		this.paramsList = paramsList;
	}

	public List getMultLangFieldList() {
		return multLangFieldList;
	}

	public void setMultLangFieldList(List multLangFieldList) {
		this.multLangFieldList = multLangFieldList;
	}

	public Map<String, String> getSubServices() {
		return subServices;
	}

	public void setSubServices(Map<String, String> subServices) {
		this.subServices = subServices;
	}


}