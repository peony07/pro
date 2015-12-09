package com.sc.pro.apiimpl.modelname;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sc.pro.apiimpl.modelname.bean.RestRequestBean;
import com.sc.pro.apiimpl.modelname.bean.RestResponseBean;
import com.sc.pro.apiimpl.modelname.bean.RestService;
import com.sc.pro.apiimpl.modelname.bean.RestServiceException;
import com.sc.pro.apiimpl.modelname.bean.Service;
import com.sc.pro.business.common.util.DataBaseUtil;
import com.sc.pro.business.common.util.MultLangUtil;
import com.sc.pro.business.model.SohoServiceConfigVO;
import com.sc.pro.common.util.COMMON;

public class SqlRestServiceImpl implements RestService {
	Log log = LogFactory.getLog(SqlRestServiceImpl.class);

	@Override
	public RestResponseBean queryExcute(RestRequestBean restResquestBean) throws RestServiceException {
		RestResponseBean restResponseBean = new RestResponseBean();
		JSONObject iv = restResquestBean.getInputValue();
		SohoServiceConfigVO sohoServiceConfigVO = restResquestBean.getSohoServiceConfigVO();
		Map params = null;
		int start_r = -1;
		int row_s = -1;
		if (!COMMON.isEmpty(sohoServiceConfigVO.getParamsList())) {
			params = new HashMap();
			for (Object key : sohoServiceConfigVO.getParamsList()) {
				if (COMMON.isEmpty(iv.get(key))) {
					params.put(key.toString().trim(), "null");
				} else {
					if (key.equals("start_r")) {
						start_r = Integer.parseInt(iv.get(key).toString());
					} else if (key.equals("row_s")) {
						row_s = Integer.parseInt(iv.get(key).toString());
					} else {
						params.put(key.toString().trim(), iv.get(key).toString().trim());
					}
				}
			}
		}
		Object[] rs = new Object[2];
		List ls;
		try {
			ls = (List) DataBaseUtil.findBySQLToMap(sohoServiceConfigVO.getServiceContent(), params, start_r, row_s);
			if (ls == null || ls.size() == 0) {
				rs[0] = "Y";
				rs[1] = null;
			} else {
				rs[0] = "Y";
				if ("O".equals(sohoServiceConfigVO.getReturnType())) {
					rs[1] = ls.get(0);
				} else {
					rs[1] = ls;
				}
				querySqlQueues(rs[1], sohoServiceConfigVO, iv);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RestServiceException("IV00004", "IV00004");
		}

		restResponseBean.setStatus(rs[0].toString());
		restResponseBean.setResults(rs[1]);
		return restResponseBean;
	}

	private void querySqlQueues(Object data, SohoServiceConfigVO sohoServiceConfigVO, JSONObject iv) throws RestServiceException {
		if (COMMON.isEmpty(data)) {
			return;
		}
		if (sohoServiceConfigVO.getSubServices() == null || sohoServiceConfigVO.getSubServices().isEmpty()) {
			return;
		}
		for (String key : sohoServiceConfigVO.getSubServices().keySet()) {
			RestRequestBean subBean = getRestServiceForSubQuery(sohoServiceConfigVO.getSubServices().get(key), sohoServiceConfigVO.getServiceAuth());
			if (subBean == null) {
				log.info("依据服务配置信息，服务[" + sohoServiceConfigVO.getServiceCode() + "]找不到子查询服务[" + key + "]");
				throw new RestServiceException("IV00004", "IV00004");
			}
			List<Map> temp = new ArrayList<Map>();
			if ("O".equals(sohoServiceConfigVO.getReturnType())) {
				temp.add((Map) data);
			} else {
				temp.addAll((List) data);
			}
			for (Map m : temp) {
				// 将入参所需行数据暂存线程变量
				if (subBean.getSohoServiceConfigVO().getParamsList() != null) {
					for (Object o : subBean.getSohoServiceConfigVO().getParamsList()) {
						Object ro = m.get(o);
						if (!COMMON.isEmpty(ro)) {
							iv.put(o, ro);
						}
					}
					subBean.setInputValue(iv);
				}
				subBean.setLang(COMMON.isEmpty(iv.get("language"))?MultLangUtil.zh_CN:iv.get("language").toString());
				RestResponseBean restResponseBean=(RestResponseBean)Service.excuteService(subBean);
				if ("N".equals(restResponseBean.getStatus())) {
					log.info("子查询:" + subBean.getSohoServiceConfigVO().getServiceCode() + "执行错误。");
					throw new RestServiceException("IV00004", "IV00004");
				}
				querySqlQueues(restResponseBean.getResults(), subBean.getSohoServiceConfigVO(), iv);
				m.put(key, restResponseBean.getResults());
			}
		}
	}

	/**
	 * 获取子查询服务
	 * 
	 * @param code
	 *            服务代码
	 * @param auth
	 *            父查询是否需权限
	 * @return 如果父查询需要权限，那么子查询权限可有可无；如果父查询不需要权限，那么子查询必须为无权限。
	 * @throws Exception
	 */
	private RestRequestBean getRestServiceForSubQuery(String code, String auth) throws RestServiceException {
		if (COMMON.isEmpty(code) || COMMON.isEmpty(auth)) {
			return null;
		}
		RestRequestBean bean = null;
		if ("N".equalsIgnoreCase(auth)) {
			return Service.initRestRequestBean(code, auth);
		} else {
			bean = Service.initRestRequestBean(code, auth);
			if (bean == null) {
				bean = Service.initRestRequestBean(code, "N");
			}
		}
		return bean;
	}

	@Override
	public RestResponseBean excute(RestRequestBean restResquestBean) throws RestServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
