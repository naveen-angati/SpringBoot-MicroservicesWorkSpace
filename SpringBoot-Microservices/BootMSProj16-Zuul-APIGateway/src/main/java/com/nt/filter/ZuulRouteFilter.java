package com.nt.filter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ZuulRouteFilter extends ZuulFilter {
	

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("ZuulRouteFilter.run()");
	   //get RequestContext object
		 RequestContext  context=RequestContext.getCurrentContext();
		 //get request object from the context object
		 HttpServletResponse res=context.getResponse();
		 //write info about current request to log file
		 log.info("=========== from  route Zuul Filter ==========");
		 log.info("  route host ::"+context.getRequest().getRemoteHost());
		
		 
		 return null;
		 
	}

	@Override
	public String filterType() {
		return FilterConstants.ROUTE_TYPE;
		}

	@Override
	public int filterOrder() {
		return 0;
	}

}
