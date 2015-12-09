package com.sc.pro.api.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sc.pro.api.modelname.ArchUserSrv;

/**
 * Created by Administrator on 2015/8/30 0030.
 */

@Path("/users")
public class ArchUserSrvRest {

	private static Log _log = LogFactory.getLog(ArchUserSrvRest.class);
	
	@Autowired
	private ArchUserSrv archUserSrv;

	@POST
	@Path("/getArchUser")
	@Consumes(MediaType.APPLICATION_JSON)
	// 输入参数类型
	@Produces(MediaType.APPLICATION_JSON)
	// 输出参数类型
	public String getArchUser(String json) {
		_log.info(json);
		return archUserSrv.getArchUser(json);
	}

	@POST
	@Path("/queryArchUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String queryArchUser(String json) {
		_log.info(json);
		return archUserSrv.queryArchUser(json);
	}

}
