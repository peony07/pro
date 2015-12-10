package com.sc.pro.api.modelname;

import java.util.List;

import com.sc.pro.api.modelname.vo.ArchUserVO;

public interface ArchUserSrv {

	public ArchUserVO findUserByAccount(String account);

	public List<ArchUserVO> queryArchUser(ArchUserVO archUserVO);
}