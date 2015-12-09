package com.sc.pro.business.service;

import com.sc.pro.business.dao.DataBaseUtilMapper;
import com.sc.pro.common.util.COMMON;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DataBaseUtilService {

	@Autowired
	private DataBaseUtilMapper dataBaseUtilMapper;

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
	public List findBySQLToMap(String sql, Map params, int start, int rowCount) throws Exception {
		StringBuffer msql = new StringBuffer(sql);
		try {
			
			if(!COMMON.isEmpty(params)){
				Iterator iterator=params.keySet().iterator();
				while(iterator.hasNext()){
					String key=iterator.next().toString().trim();
					if(msql.toString().indexOf(":"+key)!=-1){
						msql=new StringBuffer(msql.toString().replaceAll(":"+key, "#{"+key+"}"));
					}
				}
			}
			
			if(start!=-1&&rowCount!=-1){
				msql.append(" limit #{start},#{rowCount} ");
			}
			params.put("selectSql", msql.toString());
			params.put("start", start);
			params.put("rowCount", rowCount);
			return dataBaseUtilMapper.findBySQLToMap(params);
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
	public Object excuteBySQL(String sql, Map params) throws Exception {
		try {
			params.put("noSelectSql", sql);
			return dataBaseUtilMapper.excuteBySQL(params);
		} catch (Exception e) {
			throw e;
		}
	}

}
