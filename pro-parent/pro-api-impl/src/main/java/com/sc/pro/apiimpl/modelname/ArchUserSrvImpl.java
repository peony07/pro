package com.sc.pro.apiimpl.modelname;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sc.pro.api.modelname.ArchUserSrv;
import com.sc.pro.api.modelname.vo.ArchUserVO;
import com.sc.pro.business.service.ArchUserService;

/**
 * Created by Administrator on 2015/8/30 0030.
 */
@Component
public class ArchUserSrvImpl implements ArchUserSrv {

	private static Log _log = LogFactory.getLog(ArchUserSrvImpl.class);
	@Autowired
	private ArchUserService archUserService;

//	public String getArchUser(ArchUserVO archUserVO ) {
//		_log.info(json);
//		JSONObject inputValue = JSONObject.fromObject(json);
//		ArchUserVO archUserVO = (ArchUserVO) JSONObject.toBean(inputValue, ArchUserVO.class);
//		return JSONObject.fromObject(archUserService.getArchUser(archUserVO)).toString();
//	}

	public List<ArchUserVO> queryArchUser(ArchUserVO archUserVO ) {
//		_log.info(json);
//		JSONObject inputValue = JSONObject.fromObject(json);
//		ArchUserVO archUserVO = (ArchUserVO) JSONObject.toBean(inputValue, ArchUserVO.class);
		return archUserService.queryArchUser(archUserVO);
	}

	@Override
	public ArchUserVO findUserByAccount(String account) {
		return archUserService.getArchUser(account);
	}

}
