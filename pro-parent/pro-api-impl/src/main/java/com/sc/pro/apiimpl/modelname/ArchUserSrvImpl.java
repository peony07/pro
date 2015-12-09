package com.sc.pro.apiimpl.modelname;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sc.pro.api.modelname.ArchUserSrv;
import com.sc.pro.business.model.ArchUserVO;
import com.sc.pro.business.service.ArchUserService;

/**
 * Created by Administrator on 2015/8/30 0030.
 */
@Component
public class ArchUserSrvImpl implements ArchUserSrv {

	private static Log _log = LogFactory.getLog(ArchUserSrvImpl.class);
	@Autowired
	private ArchUserService archUserService;

	public String getArchUser(String json) {
		_log.info(json);
		JSONObject inputValue = JSONObject.fromObject(json);
		ArchUserVO archUserVO = (ArchUserVO) JSONObject.toBean(inputValue, ArchUserVO.class);
		return JSONObject.fromObject(archUserService.getArchUser(archUserVO)).toString();
	}

	public String queryArchUser(String json) {
		_log.info(json);
		JSONObject inputValue = JSONObject.fromObject(json);
		ArchUserVO archUserVO = (ArchUserVO) JSONObject.toBean(inputValue, ArchUserVO.class);
		return JSONObject.fromObject(archUserService.queryArchUser(archUserVO)).toString();
	}

}
