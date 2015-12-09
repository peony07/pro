/**
 * ProjectName:splider
 * Description:（用一句话描述这个类）
 * Author: 张涛
 * @version V1.0
 * Date: 2012-09-2323:15:12
 * E-Mail:zhangtao107@gmail.com
 */
package com.peony.reptile.images.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.peony.reptile.images.util.CommonUtil;
import com.peony.reptile.images.util.ThreadPictures;

public class baidu_bizhi  {

	private static final Log log = LogFactory.getLog(baidu_bizhi.class);

	private static String url = "http://image.baidu.com/";

	private String uid = "0";

	private static int startPage = 0;

	private static int endPage = 1;
	
	private static int rn = 100;

	/**
	 * 抓取图片存放目录
	 */
	private static String PIC_DIR = "D:/yunpan/pictures";

	/**
	 * 网站域名目录
	 */
	private static String dirString = "";

	/**
	 * 链接超时
	 */
	private final int TIME_OUT = 10000000;

	public static void main(String[] args) throws Exception {
		baidu_bizhi aa = new baidu_bizhi();
		dirString = url.substring(url.indexOf("://") + 3);
		dirString = dirString.substring(0, dirString.indexOf("/"));// 获取域名目录
		PIC_DIR = PIC_DIR + "/" + dirString;// 将文件放在新建的域名目录下
		String categoryUrl=url+"channel/wallpaper";
		List list=aa.getCategory(categoryUrl); 
		for(int i=0;i<list.size();i++){
			Map map=(Map)list.get(i);
			String tag3Url=url+"data/imgs?width=1366&height=768&ic=0&ie=utf8&oe=utf-8&image_id=&fr=channel&p=channel&from=1&app=img.browse.channel.wallpaper&t=0.20754214553989037";
			tag3Url+="&col="+map.get("col").toString()+"&tag="+map.get("tag2").toString()+"&tag3="+map.get("tag3").toString();
			long totalNum=aa.getTotalNum(tag3Url+"&pn=0&rn=1");
			log.info(map.get("col_name").toString()+">"+map.get("tag2_name").toString()+">"+map.get("tag3_name").toString()+"("+totalNum+"):"+tag3Url);
			
			if("全部".equals(map.get("tag3_name").toString())||"网络热图".equals(map.get("tag3_name").toString())){
				continue ;
			}
			
			if("全部".equals(map.get("tag2_name").toString())||"热门推荐".equals(map.get("tag2_name").toString())){
				continue ;
			}
			
			int startIndex=0;
			// 开始抓取图片
			log.info("----开始抓取图片----,totalNum="+totalNum);
			for (int j = startPage; j <= totalNum/rn; j++) {
				startIndex=j*rn;
				aa.forum(tag3Url + "&pn="+startIndex+"&rn="+rn,map.get("tag2_name").toString(),map.get("tag3_name").toString().trim());
			}
		}
		log.info("----图片抓取完毕----");
	}

	 
	public List getCategory(String categoryUrl) throws Exception {
		Connection conn_col;
		conn_col = Jsoup.connect(categoryUrl).timeout(TIME_OUT);
		Document doc_col = conn_col.get();
		Elements alinks_col = doc_col.select("li.x-item>a:not(.btn-more):not(.x-index),li.m-item>a:not(.btn-more):not(.x-index)");
		List<Map> alinks_col_list=new ArrayList<Map>();
		for (int i = 0; i < alinks_col.size(); i++) {
			Element alink_col = alinks_col.get(i);
			// 取得帖子的名称
			String name = alink_col.text();
			if(!"壁纸".equals(name))continue ;
			String[] dataNsclicks=alink_col.attr("data-nsclick").split("&");
			Map map=new HashMap();
			log.info(alink_col.text());
			log.info(alink_col.attr("data-nsclick"));
			for(int j=0;j<dataNsclicks.length;j++){
				String[] params=dataNsclicks[j].split("=");
				map.put(params[0], params[1]);
			}
			
			map.put("col_name", name);
			// 取得帖子的链接
			String href = alink_col.attr("href");
			map.put("col_href", href);
			alinks_col_list.add(map);
		}
		
		List result=new ArrayList();
		for(int p=0;p<alinks_col_list.size();p++){
			Map col_map=alinks_col_list.get(p);
			String col_href = col_map.get("col_href").toString();
			Connection conn_tag2 = Jsoup.connect("http://image.baidu.com"+col_href).timeout(TIME_OUT);
			Document doc_tag2 = conn_tag2.get();
			Elements alinks_tag2 = doc_tag2.select("ul>li>a[class=menu-item]");
			if(alinks_tag2.size()==0){
				alinks_tag2=doc_tag2.select("ul[class=tags-box]>li[class^=tag]>a");
			}
			for (int i = 0; i < alinks_tag2.size(); i++) {
				Element alink_tag2 = alinks_tag2.get(i);
				String[] dataNsclicks=alink_tag2.attr("data-nsclick").split("&");
				Map map_tag2=new HashMap();
				for(int j=0;j<dataNsclicks.length;j++){
					String[] params=dataNsclicks[j].split("=");
					map_tag2.put(params[0], params[1]);
				}
				String tag2_name = alink_tag2.text();
				
				Elements alinks_tag3 = doc_tag2.select("div[id=tags-container]>div[class=view-con]>ul[class=tags-box][label="+tag2_name+"]>li[class^=tag]>a");
				for (int j = 0; j < alinks_tag3.size(); j++) {
					Element alink_tag3 = alinks_tag3.get(j);
					String[] dataNsclicks_tag3=alink_tag3.attr("data-nsclick").split("&");
					Map map_tag3=new HashMap();
					for(int k=0;k<dataNsclicks_tag3.length;k++){
						String[] params=dataNsclicks_tag3[k].split("=");
						if(params.length==1){
							map_tag3.put(params[0], "");
						}else{
							map_tag3.put(params[0], params[1]);
						}
					}
					String tag3_name = alink_tag3.text();
					 
					Map map_result=new HashMap();
					map_result.putAll(col_map);
					map_result.put("tag2", map_tag3.get("tag2").toString());
					map_result.put("tag2_name",tag2_name);
					map_result.put("tag3", map_tag3.get("tag3").toString());
					map_result.put("tag3_name",tag3_name);
					result.add(map_result);
				}
			}
		}
		return result;
	}
	
	 
	public void forum(String targetURL,String tag2Name,String tag3Name) throws Exception {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		try {
			HttpPost postRequest = new HttpPost(targetURL);
			//postRequest.setHeader("User-Agent: Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)
			/*
			StringEntity input = new StringEntity("{\"qty\":100,\"name\":\"iPad 4\"}");
			input.setContentType("application/json");
			postRequest.setEntity(input);
			*/
			HttpResponse httpResponse = httpclient.execute(postRequest);
			HttpEntity entity = httpResponse.getEntity();
			/*
			Header[] headers = httpResponse.getAllHeaders();
			for (int i = 0; i < headers.length; i++) {
				System.out.println(headers[i]);
			}
			*/
			if (entity != null) {
				JSONObject jsonObj = JSONObject.fromObject(EntityUtils.toString(entity , "UTF-8"));
				JSONArray imgs=JSONArray.fromObject(jsonObj.getString("imgs"));
				String col=jsonObj.getString("col");
				for (int j=0;j<imgs.size();j++){
					JSONObject thisImg=JSONObject.fromObject(imgs.get(j));
					if(thisImg.toString().length()>3){
//						String width=thisImg.getString("imageWidth");
//						String height=thisImg.getString("imageHeight");
//						if(!"1366".equals(width)||!"768".equals(height)){
//							continue ;
//						}
						String downUrl =thisImg.getString("downloadUrl");
						String id=thisImg.getString("id");
						log.info("id="+id+",downUrl="+downUrl);
						post(col,tag2Name,tag3Name,downUrl,id);
						Thread.sleep(500);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
	}

 
	public long getTotalNum(String targetURL) throws Exception {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		long totalNum=0;
		try {
			HttpPost postRequest = new HttpPost(targetURL);
			HttpResponse httpResponse = httpclient.execute(postRequest);
			HttpEntity entity = httpResponse.getEntity();
			if (entity != null) {
				JSONObject jsonObj = JSONObject.fromObject(EntityUtils.toString(entity , "UTF-8"));
				totalNum=new Long(jsonObj.getString("totalNum"));
				return totalNum ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return totalNum;
	}
	
 
	public void post(String name,String tag2Name,String tag3Name,String picURL,String picName) throws Exception {
		if (picURL.indexOf("http://") == -1) {
			picURL = "http://" + dirString + "/" + picURL;
		}
		ThreadPictures threadPictures = new ThreadPictures();
		threadPictures.setPIC_DIR(PIC_DIR+"/"+CommonUtil.getNewDirName(name)+"/"+CommonUtil.getNewDirName(tag2Name)+"/"+CommonUtil.getNewDirName(tag3Name));
		threadPictures.setPicURL(picURL);
		threadPictures.setTIME_OUT(this.TIME_OUT);
		threadPictures.setPic_name(picName);
		threadPictures.setBaseUrl(dirString);
		threadPictures.start();
	 }
}
