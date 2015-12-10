package com.sc.pro.business.dao;

import java.util.List;

import com.sc.pro.api.modelname.vo.SohoMultLangVO;

public interface SohoMultLangMapper {
    int deleteByPrimaryKey(String id);

    int insert(SohoMultLangVO record);

    SohoMultLangVO selectByPrimaryKey(String id);

    List<SohoMultLangVO> selectAll();

    int updateByPrimaryKey(SohoMultLangVO record);
}