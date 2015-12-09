package com.sc.pro.apiimpl.modelname.bean;

import java.util.List;
import java.util.Map;

public class RestServiceBean {
	private String code;
	private String name;
	private String type;// class|sql|bean
	private String service;// 服务路径或sql text
	private RestService serviceClass;// 服务对象实例
	private String auth;// 是否需要权限
	private List params;// 参数列表
	private String flag;// 是否启用
	private String returnType;// 返回类型
	private boolean readonly;// 是否只读
	private Map<String, String> subServices;
	private List multLangField;// 国际化语言字段

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public RestService getServiceClass() {
		return serviceClass;
	}

	public void setServiceClass(RestService serviceClass) {
		this.serviceClass = serviceClass;
	}

	public List getParams() {
		return params;
	}

	public void setParams(List params) {
		this.params = params;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public boolean isReadonly() {
		return readonly;
	}

	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}

	public Map<String, String> getSubServices() {
		return subServices;
	}

	public void setSubServices(Map<String, String> subServices) {
		this.subServices = subServices;
	}

	public List getMultLangField() {
		return multLangField;
	}

	public void setMultLangField(List multLangField) {
		this.multLangField = multLangField;
	}

}
