package com.sc.pro.business.dao;

import java.util.List;

import com.sc.pro.api.modelname.vo.SohoServiceConfigVO;

public interface SohoServiceConfigMapper {
    int deleteByPrimaryKey(String id);

    int insert(SohoServiceConfigVO record);

    SohoServiceConfigVO selectByPrimaryKey(String id);

    List<SohoServiceConfigVO> selectAll();

    int updateByPrimaryKey(SohoServiceConfigVO record);

	SohoServiceConfigVO findServerByCode(SohoServiceConfigVO sohoServiceConfigVO);
}