package com.sc.pro.apiimpl.modelname;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sc.pro.api.modelname.ArchDicItemSrv;
import com.sc.pro.api.modelname.ArchDicItemVO;
import com.sc.pro.business.service.ArchDicItemService;

public class ArchDicItemSrvImpl implements ArchDicItemSrv {

	@Autowired
	private ArchDicItemService archDicItemService;

	public List<ArchDicItemVO> findArchDicItemByKind(String kind) {
		List list = archDicItemService.getList(kind);
		return list;
	}
}
