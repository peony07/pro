package com.sc.pro.web.common;

import com.sc.pro.common.util.COMMON;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2015/9/7 0007.
 */
public class RestFulClientUtil {
	private static Log _log= LogFactory.getLog(RestFulClientUtil.class);
	public static String sendGet(String url, String param){
		String result="";
		InputStream in = null;
		try {
			if(!COMMON.isEmpty(param)){
					url=url+"?"+param;
			}

			URL restServiceURL = new URL(url);
			HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();
			httpConnection.setRequestMethod("GET");
			httpConnection.setRequestProperty("Accept", "*/*");
			int HttpRequestConnectTimeOut=600000;
			httpConnection.setConnectTimeout(HttpRequestConnectTimeOut);

			if (httpConnection.getResponseCode() != 200) {
				throw new RuntimeException("HTTP GET Request Failed with Error code : " + httpConnection.getResponseCode());
			}

			in=httpConnection.getInputStream();
			int all = in.available();
			while (all > 0) {
				byte[] b = new byte[all];
				in.read(b);
				result+= new String(b, "UTF-8");
				all = in.available();
				Thread.sleep(2000);//给它点下载的时间，每两秒钟读取一次
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception ef) {
				ef.printStackTrace();
			}
		}
		return result;
	}

	public static String sendPost(String url, String param){
		String result="";
		InputStream in = null;
		PrintWriter out = null;
		try {
			URL restServiceURL = new URL(url);
			HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();
			httpConnection.setRequestMethod("POST");
			httpConnection.setRequestProperty("Accept", "application/json");
			httpConnection.setRequestProperty("connection", "Keep-Alive");
			httpConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			int HttpRequestConnectTimeOut=600000;
			httpConnection.setConnectTimeout(HttpRequestConnectTimeOut);
		// 发送POST请求必须设置如下两行
			httpConnection.setDoOutput(true);
			httpConnection.setDoInput(true);
			httpConnection.setUseCaches(false);
			httpConnection.setReadTimeout(HttpRequestConnectTimeOut);
			httpConnection.setRequestProperty("Charset", "UTF-8");


			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(httpConnection.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();

			in=httpConnection.getInputStream();
			int all = in.available();
			while (all > 0) {
				byte[] b = new byte[all];
				in.read(b);
				result+= new String(b, "UTF-8");
				all = in.available();
				Thread.sleep(2000);//给它点下载的时间，每两秒钟读取一次
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception ef) {
				ef.printStackTrace();
			}
		}
		return result;
	}

	private static final String targetURL = "http://localhost:8009/services/open/srv/route/";

	public static void main(String[] args) {
		System.out.println(sendPost("http://localhost:8009/services/open/srv/route/","{\"service_code\":\"SOHO_APP_PROJECT_LIST\",\"language\":\"zh_CN\"}"));
	}
}
