package com.nt.interceptor;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class TimeCheckingInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)throws Exception {
		// get System date and time
		LocalDateTime ldt=LocalDateTime.now();
		//get current hour of the day
		int hour=ldt.getHour();
		if(hour>=9 && hour<=21)
			return true;
		else {
			RequestDispatcher rd=req.getRequestDispatcher("/timeout.jsp");
			rd.forward(req, res);
			return false;
		}
			
		
	}

}
