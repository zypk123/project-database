package com.itek.util;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

public class ResponseUtil {

	/**
	 * 利用打印流将对象写到前台页面上
	 * 
	 * @param response
	 * @param o
	 *            jsonObject json对象
	 * @throws Exception
	 */
	public static void write(HttpServletResponse response, Object o) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(o.toString()); //打印字符串
		out.flush();
		out.close();
	}
}
