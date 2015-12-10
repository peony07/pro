package com.sc.pro.api.rest.controller;

import java.sql.Timestamp;
import java.util.Date;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.pro.api.modelname.RestPubSrv;
import com.sc.pro.common.util.DateStyle;
import com.sc.pro.common.util.DateUtil;

@Controller
@RequestMapping("/open/srv")
public class RestPubSrvRestController {
	Log _log = LogFactory.getLog(RestPubSrvRestController.class);

	@Autowired
	public RestPubSrv restPubSrv;

	@RequestMapping("/route")
	public @ResponseBody Object service(@RequestBody JSONObject jsonObj) throws Exception {
		Timestamp startTime = new Timestamp(System.currentTimeMillis());
		_log.debug("接口调用开始时间：" + DateUtil.DateToString(new Date(), DateStyle.YYYY_MM_DD_HH_MM_SS));
		_log.info("interface input:" + jsonObj.toString());
		String rlt = restPubSrv.service(jsonObj.toString());
		_log.info("interface output:" + rlt);
		Timestamp endTime = new Timestamp(System.currentTimeMillis());
		_log.debug("接口调用结束时间：" + DateUtil.DateToString(new Date(), DateStyle.YYYY_MM_DD_HH_MM_SS) + ",耗时：" + DateUtil.getIntervalSeconds(startTime, endTime) * 1000 + "毫秒");
		return rlt;
	}

}
