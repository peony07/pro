package com.sc.pro.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sc.pro.web.common.RestFulClientUtil;


/**
 * Created by Administrator on 2015/8/22 0022.
 */
@Controller
@RequestMapping("/index")
public class IndexController {
	private static Log _log = LogFactory.getLog(IndexController.class);

	@RequestMapping(value = "/")
	public ModelAndView index() {
		_log.info("/index/");
		// 创建模型跟视图，用于渲染页面。并且指定要返回的页面为index页面
		ModelAndView mav = new ModelAndView("index");

		String url = "http://localhost:8009/restservice/services/open/srv/route/";
		String params = " {\"service_code\":\"SOHO_APP_PROJECT_LIST\",\"language\":\"zh_CN\"}";
		String result = RestFulClientUtil.sendPost(url, params);
		_log.info(result);

		mav.addObject("result", result);
		return mav;
	}

}
