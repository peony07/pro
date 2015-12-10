package com.sc.pro.business.dao;

import java.util.List;

import com.sc.pro.api.modelname.vo.ArchUserVO;


public interface ArchUserMapper {
    
	public ArchUserVO getArchUser(String account);
	
	public List<ArchUserVO> queryArchUser(ArchUserVO archUserVO);
	
}