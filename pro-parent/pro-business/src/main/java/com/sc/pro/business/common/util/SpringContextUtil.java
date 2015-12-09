package com.sc.pro.business.common.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringContextUtil implements ApplicationContextAware {
	
	private static final Log _log=LogFactory.getLog(SpringContextUtil.class);

	// Spring应用上下文环境
	private static ApplicationContext applicationContext;

	/**
	 * 实现ApplicationContextAware接口的回调方法，设置上下文环境
	 * 
	 * @param applicationContext
	 */
	public void setApplicationContext(ApplicationContext applicationContext) {
		_log.info("实现ApplicationContextAware接口的回调方法，设置上下文环境 ");
		SpringContextUtil.applicationContext = applicationContext;
	}

	/**
	 * @return ApplicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static ApplicationContext getSpringContext() {
		if (applicationContext != null) {
			return applicationContext;
		} else {
			_log.info("手工初始化spring配置文件 ");
			applicationContext = new ClassPathXmlApplicationContext("/conf/spring/spring-config-business.xml");
		}
		return applicationContext;
	}

	/**
	 * 获取对象
	 * 
	 * @param name
	 * @return Object
	 * @throws BeansException
	 */
	public static Object getBean(String name) throws BeansException {
		return getSpringContext().getBean(name);
	}
}
