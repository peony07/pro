package com.sc.pro.business.dao;

import com.sc.pro.business.model.ArchDicItemVO;
import java.util.List;

public interface ArchDicItemMapper {
	public int deleteByPrimaryKey(String rid);

	public int insert(ArchDicItemVO record);

	public ArchDicItemVO selectByPrimaryKey(String rid);

	public List<ArchDicItemVO> selectAll();

	public int updateByPrimaryKey(ArchDicItemVO record);
	
	public List<ArchDicItemVO> getList(ArchDicItemVO archDicItemVO);
}