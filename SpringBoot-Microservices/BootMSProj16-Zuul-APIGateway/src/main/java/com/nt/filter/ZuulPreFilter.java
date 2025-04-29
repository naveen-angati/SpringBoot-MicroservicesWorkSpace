package com.nt.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ZuulPreFilter extends ZuulFilter {
	

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("ZuulPreFilter.run()");
	   //get RequestContext object
		 RequestContext  context=RequestContext.getCurrentContext();
		 //get request object from the context object
		 HttpServletRequest req=context.getRequest();
		 //write info about current request to log file
		 log.info("=========== from  pre Zuul Filter ==========");
		 log.info(" request mode ::"+req.getMethod());
		 log.info(" request url ::"+req.getRequestURI());
		 log.info("request path ::"+req.getServletPath());
		 log.info(" request content type::"+req.getContentType());
		 
		 return null;
		 
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
