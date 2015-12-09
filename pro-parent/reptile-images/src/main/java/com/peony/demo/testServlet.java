package com.peony.demo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class testServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public testServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		String key = request.getParameter("key");
		String name = request.getParameter("name");

		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("checkInTime".equals(cookie.getName())) {
				System.out.println("上次" + cookie.getName() + "=" + cookie.getValue());
			}
		}

		HttpSession session =request.getSession();
		ServletContext sc= session.getServletContext();
		PrintWriter  out=response.getWriter();
		 
		
		String checkInTime = DateUtil.date2Str("yyyy-MM-dd HH:mm:ss", new Date());
		System.out.println("新的checkInTime=" + checkInTime);
		Cookie cookie = new Cookie("checkInTime", checkInTime);
		cookie.setMaxAge(-30);
		response.addCookie(cookie);

		String ip = getRemoteAddress(request);
		System.out.println(ip);
		//System.out.println(getMACAddress(ip));

		Locale languageType = request.getLocale();// 获取用户语言
		String localIp = request.getLocalAddr();// 获取本地ip
		int localPort = request.getLocalPort();// 获取本地的端口
		String localName = request.getLocalName();// 获取本地计算机的名字
		String remoteIp = request.getRemoteAddr();// 获取客户端的ip搜索
		int remotePort = request.getRemotePort();// 获取客户端的端口号
		String serverName = request.getRemoteHost();// 获取远程计算机的名字
		System.out.println("语言类型->" + languageType);
		System.out.println(localName + " " + serverName);
		System.out.println(localIp + ":" + localPort + " " + remoteIp + ":" + remotePort);

		request.setAttribute("key", key);
		request.setAttribute("name", name);
		request.getRequestDispatcher("/index.jsp").forward(request, response);// RequestDispatcher.forward()跳转是报务器端跳转
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

	public String getRemoteAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public String getMACAddress(String ip) {
		String str = "";
		String macAddress = "";
		try {
			Process p = Runtime.getRuntime().exec("cmd /c C:\\Windows\\sysnative\\nbtstat -A " + ip);
			InputStreamReader ir = new InputStreamReader(p.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			for (int i = 1; i < 100; i++) {
				str = input.readLine();
				if (str != null) {
					if (str.indexOf("MAC Address") > 1) {
						macAddress = str.substring(str.indexOf("MAC Address") + 14, str.length());
						break;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
		return macAddress;
	}
}
