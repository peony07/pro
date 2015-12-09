/**
 * ProjectName:splider
 * Description:（用一句话描述这个类）
 * Author: 张涛
 * @version V1.0
 * Date: 2012-09-2323:15:12
 * E-Mail:zhangtao107@gmail.com
 */
package com.peony.reptile.images.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.peony.reptile.images.ReptileInterface;

public class meizitu extends BaseImageImpl implements ReptileInterface {
	private static final Log log = LogFactory.getLog(meizitu.class);
	protected String appendUrl(int num){
		return urlInfoBean.getUrl() + num+ ".html" ;
	}
}
