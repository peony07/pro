package com.sc.pro.business.dao;

import com.sc.pro.business.model.SohoMultLangVO;
import java.util.List;

public interface SohoMultLangMapper {
    int deleteByPrimaryKey(String id);

    int insert(SohoMultLangVO record);

    SohoMultLangVO selectByPrimaryKey(String id);

    List<SohoMultLangVO> selectAll();

    int updateByPrimaryKey(SohoMultLangVO record);
}