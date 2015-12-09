package com.sc.pro.apiimpl.modelname;

import net.sf.json.JSONObject;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sc.pro.api.modelname.RestPriSrv;
import com.sc.pro.apiimpl.modelname.bean.Service;
import com.sc.pro.business.common.util.Constants;


public class RestPriSrvImpl implements RestPriSrv {
	Log _log = LogFactory.getLog(RestPubSrvImpl.class);

	public String service(String json) throws Exception {
		JSONObject inputValue = JSONObject.fromObject(json);
		inputValue.put("serviceAuth", Constants.YES);
		String rlt = JSONObject.fromObject(Service.excuteService(inputValue)).toString();
		return rlt;
	}
}
