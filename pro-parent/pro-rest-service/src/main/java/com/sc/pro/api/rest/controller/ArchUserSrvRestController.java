package com.sc.pro.api.rest.controller;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.pro.api.modelname.ArchUserSrv;
import com.sc.pro.api.modelname.vo.ArchUserVO;
import com.sc.pro.api.rest.util.JsonDateValueProcessor;

/**
 * Created by Administrator on 2015/8/30 0030.
 */

@Controller
@RequestMapping("/users")
public class ArchUserSrvRestController {

	private static Log _log = LogFactory.getLog(ArchUserSrvRestController.class);

	@Autowired
	private ArchUserSrv archUserSrv;

	@RequestMapping("/getArchUser")
	public @ResponseBody Object getArchUser(@RequestBody JSONObject jsonObj) {
		_log.info(jsonObj.toString());
		String account = jsonObj.getString("account");
		ArchUserVO archUserVO = archUserSrv.findUserByAccount(account);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());//日期格式转换
		String result =JSONObject.fromObject(archUserVO,jsonConfig).toString();
		_log.info(result);
		return result;
	}

	@RequestMapping("/queryArchUser")
	public @ResponseBody Object queryArchUser(@RequestBody JSONObject jsonObj) {
		_log.info(jsonObj.toString());
		ArchUserVO archUserVO = (ArchUserVO) JSONObject.toBean(jsonObj);
		List<ArchUserVO> list = archUserSrv.queryArchUser(archUserVO);
		return JSONObject.fromObject(list).toString();
	}

}
