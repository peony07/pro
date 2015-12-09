package com.sc.pro.business.dao;

import java.util.List;
import java.util.Map;

public interface DataBaseUtilMapper {
 
  	
		/**
		 * 执行查询的sql语句
		 * @param sql sql
		 * @param params 参数集合
		 * @param start 开始记录，-1表示不分页
		 * @param rowCount 一页最大显示记录数，-1表示不分页
		 * @return List 可以通过Map获取里面的信息
		 * @author peony zhangtao@misquest.com
		 * @throws Exception
		 */
	    List<Map> findBySQLToMap(Map params);
	    
	    /**
		 * 执行 除select以外的sql语句
		 * @param sql sql
		 * @param params 参数集合
		 * @return Object
		 * @author peony zhangtao@misquest.com
		 * @throws Exception
		 */
        Object excuteBySQL(Map params) throws Exception;
 
	
}
