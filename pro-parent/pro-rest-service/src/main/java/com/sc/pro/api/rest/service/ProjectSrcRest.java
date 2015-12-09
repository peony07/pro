package com.sc.pro.api.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.sc.pro.api.modelname.ProjectInfoSrv;
@Path("/project")
public class ProjectSrcRest  {

	@Autowired
	public ProjectInfoSrv projectInfoSrv;
	
	@POST
	@Path("/findProjectList")
	@Consumes(MediaType.APPLICATION_JSON)
	// 输入参数类型
	@Produces(MediaType.APPLICATION_JSON)
	// 输出参数类型
	public String FindProjectList(String requestJson) {
		return projectInfoSrv.FindProjectList(requestJson);
	}

}
