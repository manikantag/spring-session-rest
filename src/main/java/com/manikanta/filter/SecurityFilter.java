package com.manikanta.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecurityFilter implements Filter {

	String[] urls = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String urlsParam = filterConfig.getInitParameter("urls");
		urls = urlsParam.split(", \n");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		if (! isRequestInterceptable(httpRequest)) {
			System.out.println("Auth is not required.");
			chain.doFilter(request, response);
		} else {
			System.out.println("Checking for auth...");
			
			HttpSession session = httpRequest.getSession();
			String permissions = (String) session.getAttribute("permissions");
			
			if (permissions != null && "aaa".equals(permissions)) {
				System.out.println("user has permissions");
				chain.doFilter(request, response);
			} else {
				System.out.println("user has no permissions");
				httpResponse.setContentLength(0);
				httpResponse.sendError(401);
			}
		}
		
	}
	
	private boolean isRequestInterceptable(HttpServletRequest httpRequest) {
		for (String url : urls) {
			if (url.equals(httpRequest.getRequestURI().substring(httpRequest.getContextPath().length()))) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void destroy() {
		
	}

}
