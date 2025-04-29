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
public class ZuulErrorFilter extends ZuulFilter {
	

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("ZuulErrorFilter.run()");
	   //get RequestContext object
		 RequestContext  context=RequestContext.getCurrentContext();
		 // get Throwable object fron contxt object
		  Throwable th=context.getThrowable();
		 //write info about current request to log file
		 log.info("=========== from  Error Zuul Filter ==========");
		 log.info("  Problem is :"+th.getMessage()+" .... class name::"+th.getClass());
		 return null;
		 
	}

	@Override
	public String filterType() {
		return FilterConstants.ERROR_TYPE;
		}

	@Override
	public int filterOrder() {
		return 0;
	}

}
