package com.sc.pro.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sc.pro.api.modelname.vo.ArchDicItemVO;
import com.sc.pro.business.dao.ArchDicItemMapper;

public class ArchDicItemService {
	
	@Autowired
	private ArchDicItemMapper archDicItemMapper;

	public List<ArchDicItemVO> getList(ArchDicItemVO archDicItemVO){
		return archDicItemMapper.getList(archDicItemVO);
	}
	 
	
	public List<ArchDicItemVO> getList(String kind){
		ArchDicItemVO archDicItemVO = new ArchDicItemVO();
		archDicItemVO.setKind(kind);
		return getList(archDicItemVO);
	}
	
}