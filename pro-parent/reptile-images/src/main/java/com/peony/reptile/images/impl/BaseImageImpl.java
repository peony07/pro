package com.peony.reptile.images.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.peony.reptile.images.ReptileInterface;
import com.peony.reptile.images.util.CommonUtil;
import com.peony.reptile.images.util.ThreadPictures;
import com.peony.reptile.images.util.UrlInfoBean;

public class BaseImageImpl implements ReptileInterface {
	private static final Log log = LogFactory.getLog(BaseImageImpl.class);
	protected UrlInfoBean urlInfoBean;
 
	protected void getFormUrlList(){
		// 开始抓取图片
		for (int i = urlInfoBean.getStartPage(); i <= urlInfoBean.getEndPage(); i++) {
			urlInfoBean.getUrlList().add(appendUrl(i));
		}
	}
	
	protected String appendUrl(int num){
		return urlInfoBean.getUrl() + num ;
	}
	
	protected void forum(List<String> list) throws Exception {
		for(int i = 0; i < list.size(); i++){
			Connection conn = Jsoup.connect(list.get(i)).timeout(urlInfoBean.getTimeOut()).header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
			Document doc = conn.get();
			Elements alinks = doc.select(urlInfoBean.getLinkFilter());
			log.info("帖子页数：" + alinks.size());
			for (int j = 0; j < alinks.size(); j++) {
				Element alink = alinks.get(j);
				// 取得帖子的名称
				String name = getaname(alink); 
				if ("".equals(name)) {
					continue;
				}
				// 取得帖子的链接
				String href = alink.attr("href");
				File urlDir = new File(urlInfoBean.getImageRootDir()+"/"+CommonUtil.getNewDirName(name));
	 			if (urlDir.exists()) {
	 				log.info("帖子：[" + name+"]已经存在，跳过。 ");
	 				continue;
	 			}
	 			if (href.indexOf("http://") == -1) {
					href = "http://"+urlInfoBean.getDomainName() +"/"+ href;
				}
				Map map=new HashMap();
				map.put("name", name);
				map.put("href", href);
				aLinkListExpend(map);
			}
		}
	}	
	
	protected String getaname(Element alink){
		 return alink.text();
	}
	
	protected void aLinkListExpend(Map map)throws Exception{
		urlInfoBean.getaLinkList().add(map);
	}
	
	/**
	 * 处理帖子URL
	 * 
	 * @param url
	 * @throws Exception
	 */
	protected void post(List<Map> list) throws Exception {
		for(int p = 0; p < list.size(); p++){
			Map map= list.get(p);
			// JSOP创建链接
			Connection conn = Jsoup.connect(map.get("href").toString()).timeout(urlInfoBean.getTimeOut()).header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
			log.info("当页每个帖子：" + map.get("href").toString());
			// 请求返回整个文档对象
			Document doc = conn.get();
			// 选择所有class=zoom 的img标签对象
			Elements imgs = doc.select(urlInfoBean.getImageFilter());
			// 循环每个img标签
			for (int i = 0; i < imgs.size(); i++) {
				// 不能请求的太快了...
				Thread.sleep(500);
				Element img = imgs.get(i);
				// 取得图片的下载地址
				String picURL = img.attr("data-original");
				if (picURL.equals("")) {
					picURL = img.attr("src");
				}
				if (picURL.indexOf("http://") == -1) {
					picURL = "http://" + urlInfoBean.getDomainName() + "/" + picURL;
				}
				ThreadPictures threadPictures = new ThreadPictures();
				threadPictures.setPIC_DIR(urlInfoBean.getImageRootDir()+"/"+CommonUtil.getNewDirName(map.get("name").toString()));
				threadPictures.setPicURL(picURL);
				threadPictures.setTIME_OUT(urlInfoBean.getTimeOut());
				threadPictures.setBaseUrl(urlInfoBean.getImageRootDir());
				threadPictures.start();
			}
		}
	}

	@Override
	public void reptileStart(UrlInfoBean urlInfoBean) throws Exception {
		this.urlInfoBean=urlInfoBean;
		getFormUrlList();
		forum(urlInfoBean.getUrlList());
		post(urlInfoBean.getaLinkList());
	}
}
