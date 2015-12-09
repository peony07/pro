package com.sc.pro.business.dao;

import com.sc.pro.business.model.SohoServiceConfigVO;
import java.util.List;

public interface SohoServiceConfigMapper {
    int deleteByPrimaryKey(String id);

    int insert(SohoServiceConfigVO record);

    SohoServiceConfigVO selectByPrimaryKey(String id);

    List<SohoServiceConfigVO> selectAll();

    int updateByPrimaryKey(SohoServiceConfigVO record);

	SohoServiceConfigVO findServerByCode(SohoServiceConfigVO sohoServiceConfigVO);
}