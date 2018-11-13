package com.itek.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.itek.entity.User;

/**
 * 登陆验证拦截器
 * 
 * @author zhangyu
 *
 * @date 2017年5月21日
 */
public class PrivilegeFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		if (req.getServletPath().equals("/login.jsp")) {
			chain.doFilter(req, response);
			return;
		}
		User existUser = (User) req.getSession().getAttribute("currentUser");
		if (existUser == null) {
			req.setAttribute("Msg", "您还没有登陆，没有权限执行该操作!");
			req.getRequestDispatcher("msg.jsp").forward(req, response);
			return;
		}
		chain.doFilter(req, response);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
