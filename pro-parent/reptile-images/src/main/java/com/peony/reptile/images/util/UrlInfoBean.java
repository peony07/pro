package com.peony.reptile.images.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UrlInfoBean {
   
	/**
	 * 爬去网站URL
	 */
	private  String url = "";
	/**
	 * 开始页
	 */
	private  int startPage = 0;
	/**
	 * 截止页
	 */
	private  int endPage = 1;
	/**
	 * 
	 */
	private  int rn = 100;

	/**
	 * 抓取图片存放目录
	 */
	private  String imageRootDir = "D:/yunpan/pictures";

	/**
	 * 网站域名目录
	 */
	private  String domainName = "";

	/**
	 * 链接超时
	 */
	private int timeOut = 1000*60*60;
	
	/**
	 * 超链接过滤条件
	 */
	private String linkFilter="";
	
	/**
	 * 图片过滤条件
	 */
	private String imageFilter="";
	
	/**
	 * UrlList
	 */
	private List<String> urlList=new ArrayList<String>() ;
	
	/**
	 * AList
	 */
	private List<Map> aLinkList=new ArrayList<Map>() ; 
	
	private String header="";
	
	/**
	 * ImageList
	 */
	private List<Map> iamgeUrlList=new ArrayList<Map>()  ; 

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getRn() {
		return rn;
	}

	public void setRn(int rn) {
		this.rn = rn;
	}

	public String getLinkFilter() {
		return linkFilter;
	}

	public void setLinkFilter(String linkFilter) {
		this.linkFilter = linkFilter;
	}

	public String getImageRootDir() {
		if("".equals(this.domainName)){
			getDomainName();
		} 
		return  imageRootDir + "/" + this.domainName;
	}

	public void setImageRootDir(String imageRootDir) {
		this.imageRootDir = imageRootDir;
	}

	public String getDomainName() {
		this.domainName=url.substring(url.indexOf("://") + 3);
		 return this.domainName=this.domainName.substring(0, this.domainName.indexOf("/"));
	}

	public int getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}

	public String getImageFilter() {
		return imageFilter;
	}

	public void setImageFilter(String imageFilter) {
		this.imageFilter = imageFilter;
	}

	public List<String> getUrlList() {
		return urlList;
	}

	public void setUrlList(List<String> urlList) {
		this.urlList = urlList;
	}

	public List<Map> getaLinkList() {
		return aLinkList;
	}

	public void setaLinkList(List<Map> aLinkList) {
		this.aLinkList = aLinkList;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public List<Map> getIamgeUrlList() {
		return iamgeUrlList;
	}

	public void setIamgeUrlList(List<Map> iamgeUrlList) {
		this.iamgeUrlList = iamgeUrlList;
	}
	
}
