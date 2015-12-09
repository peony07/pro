package com.sc.pro.api.rest.service;

import javax.ws.rs.Consumes;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.sc.pro.api.modelname.RegistrySrv;
 
@Path("/registry")
public class RegistrySrvRest  {

	@Autowired
	public RegistrySrv registrySrv;

	@POST
	@Path("/getName")
	@Consumes(MediaType.APPLICATION_JSON)
	// 输入参数类型
	@Produces(MediaType.APPLICATION_JSON)
	// 输出参数类型
	public String getName(String json) {
		JSONObject inputValue = JSONObject.fromObject(json);
		String name=inputValue.getString("name");
		return registrySrv.getName(name);
	}

	@POST
	@Path("/getValue")
	@Consumes(MediaType.APPLICATION_JSON)
	// 输入参数类型
	@Produces(MediaType.APPLICATION_JSON)
	// 输出参数类型
	public String getValue(String value) {
		return registrySrv.getValue(value);
	}

}
