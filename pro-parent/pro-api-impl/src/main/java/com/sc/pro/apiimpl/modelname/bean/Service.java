package com.sc.pro.apiimpl.modelname.bean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.sc.pro.api.modelname.vo.SohoServiceConfigVO;
import com.sc.pro.business.common.util.Constants;
import com.sc.pro.business.common.util.MultLangUtil;
import com.sc.pro.business.common.util.SpringContextUtil;
import com.sc.pro.business.service.SohoServiceConfigService;
import com.sc.pro.common.util.COMMON;

public class Service {

	public static SohoServiceConfigService sohoServiceConfigService = (SohoServiceConfigService) SpringContextUtil.getBean("sohoServiceConfigService");

	public static Object excuteService(JSONObject inputValue) throws RestServiceException {
		RestResponseBean restResponseBean = null;
		RestRequestBean restResquestBean = null;
		try {
			restResquestBean = readRequestInput(inputValue);
			if (restResquestBean.getSohoServiceConfigVO().isReadOnly()) {
				restResponseBean = restResquestBean.getServiceClass().queryExcute(restResquestBean);
			} else {
				restResponseBean = restResquestBean.getServiceClass().excute(restResquestBean);
			}
		} catch (RestServiceException e) {
			restResponseBean = new RestResponseBean();
			restResponseBean.setStatus(Constants.NO);
			restResponseBean.setErrorCode(e.getMessage());
			restResponseBean.setResults(null);
			e.printStackTrace();
		} catch (Exception e) {
			restResponseBean = new RestResponseBean();
			restResponseBean.setStatus(Constants.NO);
			restResponseBean.setErrorCode("IV00004");
			restResponseBean.setResults(null);
			e.printStackTrace();
		}
		transRestResponseBean(restResquestBean, restResponseBean);
		return restResponseBean;
	}

	public static Object excuteService(RestRequestBean restResquestBean) throws RestServiceException {
		RestResponseBean restResponseBean = null;
		try {
			if (restResquestBean.getSohoServiceConfigVO().isReadOnly()) {
				restResponseBean = restResquestBean.getServiceClass().queryExcute(restResquestBean);
			} else {
				restResponseBean = restResquestBean.getServiceClass().excute(restResquestBean);
			}
		} catch (RestServiceException e) {
			restResponseBean = new RestResponseBean();
			restResponseBean.setStatus(Constants.NO);
			restResponseBean.setErrorCode(e.getMessage());
			restResponseBean.setResults(null);
			e.printStackTrace();
		} catch (Exception e) {
			restResponseBean = new RestResponseBean();
			restResponseBean.setStatus(Constants.NO);
			restResponseBean.setErrorCode("IV00004");
			restResponseBean.setResults(null);
			e.printStackTrace();
		}
		transRestResponseBean(restResquestBean, restResponseBean);
		return restResponseBean;
	}

	/**
	* 此方法描述的是：接口返回前对国际化字段做转译
	* @author: peony zhangtao@misquest.com
	* @param restResquestBean
	* @param restResponseBean
	*/
		
	public static void transRestResponseBean(RestRequestBean restResquestBean, RestResponseBean restResponseBean) {
		if(null!=restResquestBean&&null!=restResquestBean.getSohoServiceConfigVO()){
			SohoServiceConfigVO sohoServiceConfigVO = restResquestBean.getSohoServiceConfigVO();
			if(null!= sohoServiceConfigVO){
				List list = sohoServiceConfigVO.getMultLangFieldList();
				if (!COMMON.isEmpty(list)) {
					Map keys = new HashMap();
					for (int i = 0; i < list.size(); i++) {
						String multLangField = (String) list.get(i);
						keys.put(multLangField, multLangField);
					}
					try {
						// 翻译结果集
						transResutl(restResponseBean.getResults(),keys,restResquestBean.getLang());
					} catch (Exception e) {
						restResponseBean = new RestResponseBean();
						restResponseBean.setStatus(Constants.NO);
						restResponseBean.setErrorCode("SERVICE_RESULT_TRANS_LANG_ERRORS");
						restResponseBean.setResults(null);
						e.printStackTrace();
					}
					// 翻译错误代码
					if(!COMMON.isEmpty(restResponseBean.getErrorCode())){
						restResponseBean.setErrorCode(MultLangUtil.transString(restResponseBean.getErrorCode(), restResquestBean.getLang()));
					}
				}
			}
		}
	}
	
	/**
	* 此方法描述的是：翻译结果集
	* @author: peony zhangtao@misquest.com
	* @param object
	* @param keys
	* @param language
	*/
		
	public static void transResutl(Object object,Map keys,String language){
		if(object instanceof java.util.Map){
			Map map=(Map)object;
			Iterator iterator = map.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next().toString().trim();
				Object thisObject=map.get(key);
				if(thisObject instanceof java.util.Map){
					transResutl(thisObject,keys,language);
				}else if(thisObject instanceof java.util.List){
					transResutl(thisObject,keys,language);
				}else if(!COMMON.isEmpty(thisObject)){
					if (keys.containsKey(key)) {
						String value = MultLangUtil.transString(map.get(key).toString().trim(), language);
						map.put(key, value);
					}
				}
			}
		}else if(object instanceof java.util.List){
			List list=(List)object;
			for(int i=0;i<list.size();i++){
				Map map=(Map)list.get(i);
				transResutl(map,keys,language);
			}
		}
	}

	public static RestRequestBean readRequestInput(JSONObject inputValue) throws RestServiceException {
		String serviceCode = (String) inputValue.get("service_code");
		String serviceAuth = (String) inputValue.get("serviceAuth");
		RestRequestBean restRequestBean = initRestRequestBean(serviceCode, serviceAuth);
		restRequestBean.setInputValue(inputValue);
		restRequestBean.setLang(COMMON.isEmpty(inputValue.get("language")) ? MultLangUtil.zh_CN : inputValue.get("language").toString().trim());

		return restRequestBean;
	}

	public static RestRequestBean initRestRequestBean(String serviceCode, String serviceAuth) throws RestServiceException {
		RestRequestBean restRequestBean = new RestRequestBean();
		SohoServiceConfigVO paramModel = new SohoServiceConfigVO();
		SohoServiceConfigVO sohoServiceConfigVO = null;
		paramModel.setServiceCode(serviceCode);
		paramModel.setServiceAuth(serviceAuth);
		try {
			sohoServiceConfigVO = sohoServiceConfigService.findServerByCode(paramModel);
			if (!COMMON.isEmpty(sohoServiceConfigVO.getReturnType())) {
				sohoServiceConfigVO.setReturnType(sohoServiceConfigVO.getReturnType().trim().toUpperCase());
			}
			if (!COMMON.isEmpty(sohoServiceConfigVO.getServiceParam())) {
				sohoServiceConfigVO.setParamsList(Arrays.asList(sohoServiceConfigVO.getServiceParam().trim().toLowerCase().split(",")));
			}
			if (!COMMON.isEmpty(sohoServiceConfigVO.getMultLangField())) {
				sohoServiceConfigVO.setMultLangFieldList(Arrays.asList(sohoServiceConfigVO.getMultLangField().trim().toLowerCase().split(",")));
			}
			if (!COMMON.isEmpty(sohoServiceConfigVO.getSubQuery())) {
				Map sqParams = new HashMap();
				JSONArray sqa = JSONArray.fromObject(sohoServiceConfigVO.getSubQuery());
				for (Iterator iter = sqa.iterator(); iter.hasNext();) {
					JSONObject e = (JSONObject) iter.next();
					sqParams.put(e.get("name").toString().trim(), e.get("code").toString().trim());
				}
				sohoServiceConfigVO.setSubServices(sqParams);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RestServiceException("AUTH003", "查询接口配置信息报错。");
		}

		restRequestBean.setSohoServiceConfigVO(sohoServiceConfigVO);

		RestService service = null;
		if ("class".equals(sohoServiceConfigVO.getServiceType())) {
			try {
				Class<? extends RestService> clazz = (Class<? extends RestService>) Class.forName(sohoServiceConfigVO.getServiceContent().toString().trim());
				restRequestBean.setServiceClass(clazz.newInstance());
			} catch (Exception e) {
				e.printStackTrace();
				throw new RestServiceException("AUTH003", "接口服务配置错误。");
			}
		} else if ("sql".equals(sohoServiceConfigVO.getServiceType())) {
			service = (RestService) SpringContextUtil.getBean("sqlRestServiceImpl");
			sohoServiceConfigVO.setReadOnly(Constants.YES);// sql类型只读
			restRequestBean.setServiceClass(service);
		} else {
			service = (RestService) SpringContextUtil.getBean(sohoServiceConfigVO.getServiceContent());
			restRequestBean.setServiceClass(service);
		}
		return restRequestBean;
	}
}
