package com.sc.pro.api.modelname;

import java.util.List;

public interface ArchDicItemSrv {
	public List<ArchDicItemVO> findArchDicItemByKind(String kind);
}
