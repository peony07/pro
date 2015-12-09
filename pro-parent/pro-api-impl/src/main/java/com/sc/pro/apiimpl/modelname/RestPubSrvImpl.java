package com.sc.pro.apiimpl.modelname;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sc.pro.api.modelname.RestPubSrv;
import com.sc.pro.apiimpl.modelname.bean.Service;
import com.sc.pro.business.common.util.Constants;

public class RestPubSrvImpl implements RestPubSrv {
	Log _log = LogFactory.getLog(RestPubSrvImpl.class);

	public String service(String json) throws Exception {
		JSONObject inputValue = JSONObject.fromObject(json);
		inputValue.put("serviceAuth", Constants.NO);
		String rlt = JSONObject.fromObject(Service.excuteService(inputValue)).toString();
		return rlt;
	}

}
