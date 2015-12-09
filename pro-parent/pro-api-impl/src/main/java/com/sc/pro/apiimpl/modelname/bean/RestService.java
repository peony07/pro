package com.sc.pro.apiimpl.modelname.bean;


public interface RestService {
	public RestResponseBean excute(RestRequestBean restResquestBean) throws RestServiceException;

	/**
	 * 只读事务
	 */
	public RestResponseBean queryExcute(RestRequestBean restResquestBean) throws RestServiceException;
}
