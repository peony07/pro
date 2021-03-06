/**
 * ProjectName:splider
 * Description:（用一句话描述这个类）
 * Author: 张涛
 * @version V1.0
 * Date: 2012-09-2323:15:12
 * E-Mail:zhangtao107@gmail.com
 */
package com.peony.reptile.images.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.peony.reptile.images.ReptileInterface;

public class mm131  extends BaseImageImpl implements ReptileInterface {

	private static final Log log = LogFactory.getLog(mm131.class);
 
	protected String appendUrl(int num){
		if(num==1){
			return urlInfoBean.getUrl();
		}else{
			return urlInfoBean.getUrl()+"list_6_"+num+".html" ;
		}
	}
	
	protected void aLinkListExpend(Map map) throws Exception {
		// 取得帖子的链接
		String href = map.get("href").toString();
		Connection conn2 = Jsoup.connect(href).timeout(urlInfoBean.getTimeOut()).header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
		Document doc2 = conn2.get();
		Elements alinks2 = doc2.select("div[class=content-page]>a[class=page-en]");
		Element alink2 = alinks2.get(alinks2.size() - 2);
		int num = new Integer(alink2.select("span").last().text().trim());
		log.info("帖子[" + map.get("name").toString() + "]：" + num);
		for (int j = 1; j < num; j++) {
			Map thisMap=new HashMap();
			thisMap.put("name", map.get("name").toString());
			if(j==1){
				map.put("href", href);
			}else{
				map.put("href", urlInfoBean.getUrl()+alinks2.get(j-2).attr("href"));
			}
			urlInfoBean.getaLinkList().add(thisMap);
		}
	}
	
	protected String getaname(Element alink){
		 return alink.text().replaceAll("\\?", "_");
	}
}
