package com.sc.pro.business.dao;

import java.util.List;

import com.sc.pro.api.modelname.vo.ArchDicItemVO;

public interface ArchDicItemMapper {
	public int deleteByPrimaryKey(String rid);

	public int insert(ArchDicItemVO record);

	public ArchDicItemVO selectByPrimaryKey(String rid);

	public List<ArchDicItemVO> selectAll();

	public int updateByPrimaryKey(ArchDicItemVO record);
	
	public List<ArchDicItemVO> getList(ArchDicItemVO archDicItemVO);
}