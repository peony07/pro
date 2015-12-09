package com.sc.pro.api.rest;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.glassfish.jersey.server.ResourceConfig;


public  class RestApplication extends ResourceConfig {
	Log _log = LogFactory.getLog(RestApplication.class);

	public RestApplication() {
		packages("com.sc.pro.api.rest.service");
		register(JacksonJsonProvider.class);
		_log.info("com.sc.pro.api.rest.service");
	}

}
