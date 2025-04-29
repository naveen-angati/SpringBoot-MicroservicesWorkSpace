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
public class ZuulPostFilter extends ZuulFilter {
	

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("ZuulPostFilter.run()");
	   //get RequestContext object
		 RequestContext  context=RequestContext.getCurrentContext();
		 //get request object from the context object
		 HttpServletResponse res=context.getResponse();
		 //write info about current request to log file
		 log.info("=========== from  post Zuul Filter ==========");
		 log.info(" response status code ::"+res.getStatus());
		 log.info(" response content type ::"+res.getContentType());
		 log.info(" response character encoding::"+res.getCharacterEncoding());
		 log.info(" Host name::"+res.getHeader("host"));
		 
		 return null;
		 
	}

	@Override
	public String filterType() {
		return FilterConstants.POST_TYPE;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
