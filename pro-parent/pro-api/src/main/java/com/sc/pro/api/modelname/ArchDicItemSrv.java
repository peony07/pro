package com.sc.pro.api.modelname;

import java.util.List;

import com.sc.pro.api.modelname.vo.ArchDicItemVO;

public interface ArchDicItemSrv {
	public List<ArchDicItemVO> findArchDicItemByKind(String kind);
}
