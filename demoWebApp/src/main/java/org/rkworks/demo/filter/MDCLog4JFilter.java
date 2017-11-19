package org.rkworks.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.MDC;
import org.springframework.stereotype.Component;

@Component
public class MDCLog4JFilter implements Filter {
	String MDC_ID ="username";
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;		
		
		String userId = httpRequest.getParameter(MDC_ID);
		System.out.println("Filter Called"+userId);
		if(userId != null){
			MDC.put("MDC_ID", userId);
		}		
		try {
			chain.doFilter(request, response);
		} finally {
			MDC.remove("MDC_ID");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {		

	}

	@Override
	public void destroy() {		

	}
}
