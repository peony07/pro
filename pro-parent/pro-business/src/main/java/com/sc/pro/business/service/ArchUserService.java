package com.sc.pro.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sc.pro.api.modelname.vo.ArchUserVO;
import com.sc.pro.business.dao.ArchUserMapper;

public class ArchUserService {

	@Autowired
	private ArchUserMapper archUserMapper;

	public ArchUserVO getArchUser(String account) {
		return archUserMapper.getArchUser(account);
	}

	public List<ArchUserVO> queryArchUser(ArchUserVO archUserVO) {
		return archUserMapper.queryArchUser(archUserVO);
	}
}
