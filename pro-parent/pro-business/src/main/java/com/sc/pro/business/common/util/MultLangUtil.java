package com.sc.pro.business.common.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sc.pro.api.modelname.vo.SohoMultLangVO;
import com.sc.pro.business.service.RedisClientTemplate;
import com.sc.pro.common.util.COMMON;

public class MultLangUtil {
	private static Log _log = LogFactory.getLog(MultLangUtil.class);
	public static final String zh_CN = "zh_CN";
	public static final String en_US = "en_US";
	private static RedisClientTemplate redisClientTemplate = (RedisClientTemplate) SpringContextUtil.getBean("redisClientTemplate");

	/**
	 * 翻译code
	 * @param code
	 * @param lang
	 * @return
	 */
	public static String transString(String code, String lang) {
		if (COMMON.isEmpty(code)) {
			return "";
		}
		SohoMultLangVO po = transByCodeAndLang(code, lang);
		if (po == null) {
			po = transByCodeAndLang(code, "zh_CN");
		}
		if (po == null) {
			return code;
		}
		return po.getContext();
	}

	/**
	 * 翻译
	 * @param code
	 * @param lang
	 * @return
	 */
	public static SohoMultLangVO transByCodeAndLang(String code, String lang) {
		SohoMultLangVO po = null;
		if (po == null) {
			po = getByCodeAndLang(code, lang);
			if (po != null) {
				return po;
			}
			return null;
		}
		return po;
	}

	/**
	 * 翻译
	 * @param code
	 * @param lang
	 * @return
	 */
	public static SohoMultLangVO getByCodeAndLang(String code, String lang) {
		SohoMultLangVO sohoMultLangVO = null;
		sohoMultLangVO = getMultLangByCodeAndLanguageFromCache(code, lang);
		if (null != sohoMultLangVO) {
			return sohoMultLangVO;
		}
		String sql = "select * from soho_mult_lang where code = :code and lang = :lang";
		Map params = new HashMap();
		params.put("code", code);
		params.put("lang", lang);
		List rlt = null;
		try {
			rlt = (List) DataBaseUtil.findBySQLToMap(sql, params, -1, -1);
			if (rlt == null || rlt.isEmpty()) {
				return null;
			}
			SohoMultLangVO po = getMultLangFromMap((Map) rlt.get(0));
			cacheMultLang(po);
			return po;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 删除国际化数据
	 * @param code
	 * @param lang
	 * @throws Exception
	 */
	private static void deleteByCodeAndLang(String code, String lang) throws Exception {
		String sql = "delete from soho_mult_lang where code = :code and lang = :lang";
		Map params = new HashMap();
		params.put("code", code);
		params.put("lang", lang);
		DataBaseUtil.excuteBySQL(sql, params);
		delCacheMultLang(code, lang);
	}

	/**
	 * 国际化数据map-object转换
	 * @param m
	 * @return
	 */
	private static SohoMultLangVO getMultLangFromMap(Map m) {
		if (m == null) {
			return null;
		}
		_log.info(m);
		SohoMultLangVO po = new SohoMultLangVO();
		po.setId((String) m.get("id"));
		po.setCode((String) m.get("code"));
		po.setLang((String) m.get("lang"));
		po.setContext((String) m.get("context"));
		po.setBusinessField((String) m.get("business_id"));
		po.setBusinessField((String) m.get("business_field"));
		po.setModelName((String) m.get("model_name"));
		return po;
	}

	/**
	 * 新增国际化数据
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public static SohoMultLangVO insertMultLang(SohoMultLangVO po) throws Exception {
		String sql = "insert into soho_mult_lang (id, code, lang, context, business_id, business_field, model_name) values (:id, :code, :lang, :context, :business_id, :business_field, :model_name)";
		Map params = new HashMap();
		params.put("id", UUID.randomUUID().toString());
		params.put("code", po.getCode());
		params.put("lang", po.getLang());
		params.put("context", COMMON.isEmpty(po.getContext()) ? "" : po.getContext());
		params.put("business_id", COMMON.isEmpty(po.getBusinessId()) ? "" : po.getBusinessId());
		params.put("business_field", COMMON.isEmpty(po.getBusinessField()) ? "" : po.getBusinessField());
		params.put("model_name", COMMON.isEmpty(po.getModelName()) ? "" : po.getModelName());
		DataBaseUtil.excuteBySQL(sql, params);
		po = getMultLangFromMap(params);
		cacheMultLang(po);
		return po;
	}

	/**
	 * 更新国际化数据
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public static SohoMultLangVO updateMultLang(SohoMultLangVO po) throws Exception {
		String sql = "update soho_mult_lang set code = :code, lang = :lang, context = :context, business_id=:business_id,business_field=:business_field,model_name=:model_name where id = :id";
		Map params = new HashMap();
		params.put("id", po.getId());
		params.put("code", po.getCode());
		params.put("lang", po.getLang());
		params.put("context", COMMON.isEmpty(po.getContext()) ? "" : po.getContext());
		params.put("business_id", COMMON.isEmpty(po.getBusinessId()) ? "" : po.getBusinessId());
		params.put("business_field", COMMON.isEmpty(po.getBusinessField()) ? "" : po.getBusinessField());
		params.put("model_name", COMMON.isEmpty(po.getModelName()) ? "" : po.getModelName());
		DataBaseUtil.excuteBySQL(sql, params);
		po = getByCodeAndLang(po.getCode(), po.getLang());
		cacheMultLang(po);
		return po;
	}

	/**
	 * 缓存国际化数据对象
	 * @param po
	 */
	public static void cacheMultLang(SohoMultLangVO po) {
		if (po == null) {
			return;
		}
		redisClientTemplate.set(getKey(po), JSONObject.fromObject(po).toString());
		_log.debug("缓存数据:" + JSONObject.fromObject(po).toString());
	}

	/**
	 * 从缓存获取国际化值
	 * @param po
	 * @return
	 */
	public static String getValueByMultLangFromCache(SohoMultLangVO po) {
		return getValueByCodeAndLanguageFromCache(po.getCode(), po.getLang());
	}

	/**
	 * 从缓存获取国际化值
	 * @param code
	 * @param language
	 * @return
	 */
	public static String getValueByCodeAndLanguageFromCache(String code, String language) {
		SohoMultLangVO po = getMultLangByCodeAndLanguageFromCache(code, language);
		return po == null ? "" : po.getContext();
	}

	/**
	 * 从缓存获取国际化对象
	 * @param po
	 * @return
	 */
	public static SohoMultLangVO getMultLangByCodeAndLanguageFromCache(SohoMultLangVO po) {
		return getMultLangByCodeAndLanguageFromCache(po.getCode(), po.getLang());
	}

	/**
	 * 从缓存获取国际化对象
	 * @param code
	 * @param language
	 * @return
	 */
	public static SohoMultLangVO getMultLangByCodeAndLanguageFromCache(String code, String language) {
		String value = redisClientTemplate.get(getKey(code, language));
		if (COMMON.isEmpty(value)) {
			return null;
		}
		_log.debug("从缓存获取数据:" + value);
		return (SohoMultLangVO) JSONObject.toBean(JSONObject.fromObject(value), SohoMultLangVO.class);
	}

	/**
	 * 清除缓存
	 * @param po
	 */
	public static void delCacheMultLang(SohoMultLangVO po) {
		if (po == null) {
			return;
		}
		delCacheMultLang(po.getCode(), po.getLang());
	}

	/**
	 * 清除缓存
	 * @param code
	 * @param lang
	 */
	public static void delCacheMultLang(String code, String lang) {
		redisClientTemplate.del(getKey(code, lang));
		_log.debug("清除缓存数据:" + getKey(code, lang));
	}

	/**
	 *
	 * @param po
	 * @return
	 */
	public static String getKey(SohoMultLangVO po) {
		return getKey(po.getCode(), po.getLang());
	}

	/**
	 *
	 * @param code
	 * @param language
	 * @return
	 */
	public static String getKey(String code, String language) {
		return code + "." + language;
	}
}
