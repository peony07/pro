package com.peony.reptile.images.mongodb;

import java.util.Date;

public class PictureVO {

	private String picURL ;
	private String PIC_DIR ;
	private String pic_name;
	private Date createDate;
	private String fromUrl;
	
	public String getPic_name() {
		return pic_name;
	}

	public void setPic_name(String pic_name) {
		this.pic_name = pic_name;
	}


	public String getPicURL() {
		return picURL;
	}

	public void setPicURL(String picURL) {
		this.picURL = picURL;
	}

	public String getPIC_DIR() {
		return PIC_DIR;
	}

	public void setPIC_DIR(String pIC_DIR) {
		PIC_DIR = pIC_DIR;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getFromUrl() {
		return fromUrl;
	}

	public void setFromUrl(String fromUrl) {
		this.fromUrl = fromUrl;
	}
	
	
}
