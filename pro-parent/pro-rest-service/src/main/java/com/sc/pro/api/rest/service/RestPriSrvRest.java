package com.sc.pro.api.rest.service;

import java.sql.Timestamp;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sc.pro.api.modelname.RestPubSrv;
import com.sc.pro.common.util.DateStyle;
import com.sc.pro.common.util.DateUtil;
@Path("/oauth/srv")
public class RestPriSrvRest {
	Log _log = LogFactory.getLog(RestPubSrvRest.class);

	@Autowired
	public RestPubSrv restPriSrv ;

	@POST
	@Path("/route")
	@Consumes(MediaType.APPLICATION_JSON) //输入参数类型
	@Produces(MediaType.APPLICATION_JSON) //输出参数类型
	public String service(String json) throws Exception {
		Timestamp startTime=new Timestamp(System.currentTimeMillis());
		_log.debug("接口调用开始时间："+DateUtil.DateToString(new Date(), DateStyle.YYYY_MM_DD_HH_MM_SS));
		_log.info("interface input:" + json);
		String rlt =restPriSrv.service(json);
		_log.info("interface output:" + rlt);
		Timestamp endTime=new Timestamp(System.currentTimeMillis());
		_log.debug("接口调用结束时间："+ DateUtil.DateToString(new Date(), DateStyle.YYYY_MM_DD_HH_MM_SS)+",耗时："+DateUtil.getIntervalSeconds(startTime,endTime)*1000+"毫秒");
		
		return rlt;
	}
}
