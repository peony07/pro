package com.sc.pro.apiimpl.modelname.bean;

/**
 * 接口异常类
 * 
 */
public class RestServiceException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;

	public RestServiceException(){
		
	}
	
	public RestServiceException(String code) {
		super();
		this.code = code;
	}

	public RestServiceException(String code, String message) {
		super(message);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
