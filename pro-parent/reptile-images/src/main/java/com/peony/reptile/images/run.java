package com.peony.reptile.images;

import com.peony.reptile.images.impl.erog;
import com.peony.reptile.images.impl.meizitu;
import com.peony.reptile.images.impl.mimiai;
import com.peony.reptile.images.impl.mm131;
import com.peony.reptile.images.impl.mzitu;
import com.peony.reptile.images.impl.mzituall;
import com.peony.reptile.images.util.UrlInfoBean;

public class run {
	public static void main(String[] args) {
		ReptileInterface reptileInterfaceImpl = new mzitu();
		UrlInfoBean urlInfoBean = new UrlInfoBean();
		try {
			urlInfoBean.setUrl("http://www.mzitu.com/page/");
			urlInfoBean.setStartPage(1);
			urlInfoBean.setEndPage(2);
			urlInfoBean.setLinkFilter("ul[id=list]>li>a");
			urlInfoBean.setImageFilter("div[class=pic]>p>a>img");
			//reptileInterfaceImpl.reptileStart(urlInfoBean);
		} catch (Exception e) {
			e.printStackTrace();
		}

		reptileInterfaceImpl = new meizitu();
		urlInfoBean = new UrlInfoBean();
		try {
			urlInfoBean.setUrl("http://www.meizitu.com/a/list_1_");
			urlInfoBean.setStartPage(1);
			urlInfoBean.setEndPage(2);
			urlInfoBean.setLinkFilter("li[class=wp-item]>div[class=con]>h3[class=tit]>a");
			urlInfoBean.setImageFilter("div[id=picture]>p>img");
			//reptileInterfaceImpl.reptileStart(urlInfoBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		reptileInterfaceImpl = new mzituall();
		urlInfoBean = new UrlInfoBean();
		try {
			urlInfoBean.setUrl("http://www.mzitu.com/all/");
			urlInfoBean.setStartPage(1);
			urlInfoBean.setEndPage(2);
			urlInfoBean.setLinkFilter("p[class=url]>a");
			urlInfoBean.setImageFilter("div[class=main-image]>p>a>img");
			reptileInterfaceImpl.reptileStart(urlInfoBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		reptileInterfaceImpl = new mm131();
		urlInfoBean = new UrlInfoBean();
		try {
			urlInfoBean.setUrl("http://www.mm131.com/qingchun/");
			urlInfoBean.setStartPage(1);
			urlInfoBean.setEndPage(2);
			urlInfoBean.setLinkFilter("dl[class=list-left public-box]>dd:not(.page)>a");
			urlInfoBean.setImageFilter("div[class=content-pic]>a>img");
			//reptileInterfaceImpl.reptileStart(urlInfoBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		reptileInterfaceImpl = new mimiai();
		urlInfoBean = new UrlInfoBean();
		try {
			urlInfoBean.setUrl("http://www.aiskys.com/forumdisplay.php?fid=70");
			urlInfoBean.setStartPage(1);
			urlInfoBean.setEndPage(2);
			urlInfoBean.setLinkFilter("a[href$=page%3D1]");
			urlInfoBean.setImageFilter("div[class=t_msgfont]>img");
			//reptileInterfaceImpl.reptileStart(urlInfoBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		reptileInterfaceImpl = new erog();
		urlInfoBean = new UrlInfoBean();
		try {
			urlInfoBean.setUrl("http://ooxx.erog.fr/");
			urlInfoBean.setStartPage(1);
			urlInfoBean.setEndPage(2);
			urlInfoBean.setLinkFilter("h2>a");
			urlInfoBean.setImageFilter("p img");
//			imgreptileInterfaceImpl.reptileStart(urlInfoBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
