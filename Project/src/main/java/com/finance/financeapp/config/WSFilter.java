package com.finance.financeapp.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebFilter(filterName="wsFilter",urlPatterns="/rest/protected/*")
public class WSFilter implements Filter {

	final Logger logger = LoggerFactory.getLogger(WSFilter.class);

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest servletRequest = (HttpServletRequest)request;
	    HttpServletResponse servletResponse = (HttpServletResponse) response;
		
	    HttpSession currentSession = servletRequest.getSession();
	    
	    System.out.println("Session Object ------> " + currentSession.getAttribute("idUser"));
		if (currentSession.getAttribute("idUser") != null) {
			chain.doFilter(servletRequest, servletResponse);
		} else {
			logger.debug("Rejected: " + servletRequest.toString());
			servletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext (this);
	}

}
