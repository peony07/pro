package com.sc.pro.business;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sc.pro.business.model.ArchUserVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.pro.business.common.util.Constants;
import com.sc.pro.business.common.util.SpringContextUtil;
import com.sc.pro.business.model.ArchDicItemVO;
import com.sc.pro.business.model.SohoServiceConfigVO;
import com.sc.pro.business.service.ArchDicItemService;
import com.sc.pro.business.service.ArchUserService;
import com.sc.pro.business.service.DataBaseUtilService;
import com.sc.pro.business.service.SohoServiceConfigService;


public class test {

	private static final Log _log = LogFactory.getLog(test.class);

	/**
	 * 此方法描述的是：main
	 * 
	 * @author: peony zhangtao@misquest.com
	 * @param args
	 */

	public static void main(String[] args) {
		ArchUserService archUserService = (ArchUserService) SpringContextUtil.getBean("archUserService");
		ArchUserVO archUserVO = new ArchUserVO();
		archUserVO.setAccount("admin");
		archUserVO = archUserService.getArchUser(archUserVO);
		_log.info(archUserVO.getUserName());

		archUserVO = new ArchUserVO();
		archUserVO.setEmail("misquest");
		// 获取第1页，5条内容，默认查询总数count
		PageHelper.startPage(1, 5);
		List<ArchUserVO> list = archUserService.queryArchUser(archUserVO);
		for (ArchUserVO item : list) {
			_log.info(item.getUserName());
		}

		Page page = (Page) list;
		_log.info(page.getTotal());

		PageHelper.startPage(2, 5);
		list = archUserService.queryArchUser(archUserVO);
		for (ArchUserVO item : list) {
			_log.info(item.getUserName());
		}

		PageInfo pageInfo = new PageInfo(list);
		_log.info(pageInfo.getTotal());
		_log.info(pageInfo.getPageNum());
		_log.info(pageInfo.getPageSize());
		_log.info(pageInfo.getPages());
		_log.info(pageInfo.isIsFirstPage());
		_log.info(pageInfo.isIsLastPage());
		_log.info(pageInfo.isHasNextPage());
		_log.info(pageInfo.isHasPreviousPage());

		ArchDicItemService archDicItemService = (ArchDicItemService) SpringContextUtil.getBean("archDicItemService");
		ArchDicItemVO archDicItemVO = new ArchDicItemVO();
		archDicItemVO.setKind("ORDER_STATUS");
		List<ArchDicItemVO> list2 = archDicItemService.getList(archDicItemVO);
		for (ArchDicItemVO item : list2) {
			_log.info(item.getDetail());
		}

		SohoServiceConfigService sohoServiceConfigService = (SohoServiceConfigService) SpringContextUtil.getBean("sohoServiceConfigService");
		SohoServiceConfigVO paramModel = new SohoServiceConfigVO();
		paramModel.setServiceCode("SOHO_APP_CONFERENCE_DETAILS");
		paramModel.setServiceAuth(Constants.YES);
		SohoServiceConfigVO sohoServiceConfigVO = sohoServiceConfigService.findServerByCode(paramModel);
		_log.info(sohoServiceConfigVO.getServiceName());

		DataBaseUtilService dataBaseUtilService = (DataBaseUtilService) SpringContextUtil.getBean("dataBaseUtilService");
		Map paramMap = new HashMap();
		paramMap.put("account", "admin");
		paramMap.put("flag", Constants.YES);
		try {
			list = dataBaseUtilService.findBySQLToMap(" select * from arch_user where account=#{account} and flag=#{flag} ", paramMap, 0, 10);
			_log.info(list.size());
			for (int i = 0; i < list.size(); i++) {
				Map item = (Map) list.get(i);
				Iterator iterator = item.keySet().iterator();
				while (iterator.hasNext()) {
					String key = iterator.next().toString();
					_log.info("key=" + key + "&value=" + item.get(key).toString());
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
