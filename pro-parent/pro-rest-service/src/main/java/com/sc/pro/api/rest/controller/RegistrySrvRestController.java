package com.sc.pro.api.rest.controller;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.pro.api.modelname.RegistrySrv;
 
@Controller
@RequestMapping("/registry")
public class RegistrySrvRestController  {

	@Autowired
	public RegistrySrv registrySrv;

	@RequestMapping("/getName")
	public @ResponseBody Object getName(@RequestBody JSONObject jsonObj) {
		String name=jsonObj.getString("name");
		return registrySrv.getName(name);
	}

	@RequestMapping("/getValue")
	public @ResponseBody Object getValue(@RequestBody JSONObject jsonObj) {
		String value=jsonObj.getString("value");
		return registrySrv.getValue(value);
	}

}
