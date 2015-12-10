package com.sc.pro.api.rest.controller;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.pro.api.modelname.ProjectInfoSrv;

@Controller
@RequestMapping("/project")
public class ProjectSrcRestController  {

	@Autowired
	public ProjectInfoSrv projectInfoSrv;
	
	@RequestMapping("/findProjectList")
	public @ResponseBody Object FindProjectList(@RequestBody JSONObject jsonObj) {
		return projectInfoSrv.FindProjectList(jsonObj.toString());
	}

}
