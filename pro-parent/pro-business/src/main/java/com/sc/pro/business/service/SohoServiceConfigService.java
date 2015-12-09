package com.sc.pro.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sc.pro.business.dao.SohoServiceConfigMapper;
import com.sc.pro.business.model.SohoServiceConfigVO;

public class SohoServiceConfigService {
	@Autowired
	private SohoServiceConfigMapper sohoServiceConfigMapper;

	public SohoServiceConfigVO findServerByCode(SohoServiceConfigVO sohoServiceConfigVO){
		return sohoServiceConfigMapper.findServerByCode(sohoServiceConfigVO);
	}

	public List<SohoServiceConfigVO> selectAll() {
		return sohoServiceConfigMapper.selectAll();
	}

}