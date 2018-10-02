package com.epam.training.onlineStore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.epam.training.onlineStore.model.User;
import com.epam.training.onlineStore.service.UserManager;

public class UserNameAwareInterceptor implements HandlerInterceptor {

    @Autowired
    private UserManager userManager;
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) {
    	
 		User currentUser = userManager.getUser();
		
		if (modelAndView != null) {
			
			if (currentUser == null) {
			
				modelAndView.addObject("currentUserName", "Не определен");
				modelAndView.addObject("currentUserIsAdmin", false);
				modelAndView.addObject("userDefined", false);
				
			} else {
			 
				modelAndView.addObject("currentUserName", currentUser.getLogin());
				modelAndView.addObject("currentUserIsAdmin", true);
				modelAndView.addObject("userDefined", true);
				
			}	
			
		}
		
    }
    
}
