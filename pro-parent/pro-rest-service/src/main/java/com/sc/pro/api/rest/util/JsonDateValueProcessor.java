package com.sc.pro.api.rest.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class JsonDateValueProcessor implements JsonValueProcessor {
	private String dateFormat = "yyyy-MM-dd";
	private String timeFormat = "yyyy-MM-dd HH:mm:ss";
	

	public JsonDateValueProcessor() {
		super();
	}

	public JsonDateValueProcessor(String dateFormat) {
		super();
		this.dateFormat = dateFormat;
	}

	@Override
	public Object processArrayValue(Object paramObject, JsonConfig paramJsonConfig) {
		return process(paramObject);
	}

	@Override
	public Object processObjectValue(String paramString, Object paramObject, JsonConfig paramJsonConfig) {
		return process(paramObject);
	}

	private Object process(Object value) {
		if (value instanceof Date) {
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.CHINA);
			return sdf.format(value);
		}else if(value instanceof Timestamp) {
			SimpleDateFormat sdf = new SimpleDateFormat(timeFormat, Locale.CHINA);
			return sdf.format(value);
		}
		return value == null ? "" : value.toString();
	}

}
