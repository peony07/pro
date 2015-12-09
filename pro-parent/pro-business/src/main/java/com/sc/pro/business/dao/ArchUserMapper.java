package com.sc.pro.business.dao;

import java.util.List;

import com.sc.pro.business.model.ArchUserVO;


public interface ArchUserMapper {
    
	public ArchUserVO getArchUser(ArchUserVO archUserVO);
	
	public List<ArchUserVO> queryArchUser(ArchUserVO archUserVO);
	
}