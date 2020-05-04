package org.hello.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//session 媛앹껜瑜� 媛��졇�샂
		HttpSession session = request.getSession();
		
		/*
		Object obj = session.getAttribute("user");
		
		if(obj == null) {
			System.out.println("loginInterceptor obj null");
			response.sendRedirect("/login");
			return;
		} else {
			System.out.println("loginInterceptor obj");
			response.sendRedirect("/member/main");
			return;
		}
		*/
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		return super.preHandle(request, response, handler);
	}

}
