package com.sc.pro.business.common.util;

import java.util.List;
import java.util.Map;

import com.sc.pro.business.service.DataBaseUtilService;

public class DataBaseUtil {

	private static DataBaseUtilService dataBaseUtilService = (DataBaseUtilService) SpringContextUtil.getBean("dataBaseUtilService");

	/**
	 * 执行查询的sql语句
	 * 
	 * @param sql
	 *            sql
	 * @param params
	 *            参数集合
	 * @param start
	 *            开始记录，-1表示不分页
	 * @param rowCount
	 *            一页最大显示记录数，-1表示不分页
	 * @return List 可以通过Map获取里面的信息
	 * @author peony zhangtao@misquest.com
	 * @throws Exception
	 */
	public static List findBySQLToMap(String sql, Map params, int start, int rowCount) throws Exception {
		try {
			return dataBaseUtilService.findBySQLToMap(sql, params, start, rowCount);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 执行 除select以外的sql语句
	 * 
	 * @param sql
	 *            sql
	 * @param params
	 *            参数集合
	 * @return Object
	 * @author peony zhangtao@misquest.com
	 * @throws Exception
	 */
	public static Object excuteBySQL(String sql, Map params) throws Exception {
		try {
			return dataBaseUtilService.excuteBySQL(sql, params);
		} catch (Exception e) {
			throw e;
		}
	}

}
