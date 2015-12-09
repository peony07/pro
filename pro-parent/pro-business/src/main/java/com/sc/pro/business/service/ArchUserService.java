package com.sc.pro.business.service;

import java.util.List;

import com.sc.pro.business.model.ArchUserVO;
import org.springframework.beans.factory.annotation.Autowired;

import com.sc.pro.business.dao.ArchUserMapper;

public class ArchUserService {

	@Autowired
	private ArchUserMapper archUserMapper;

	public ArchUserVO getArchUser(ArchUserVO archUserVO) {
		return archUserMapper.getArchUser(archUserVO);
	}

	public List<ArchUserVO> queryArchUser(ArchUserVO archUserVO) {
		return archUserMapper.queryArchUser(archUserVO);
	}
}
