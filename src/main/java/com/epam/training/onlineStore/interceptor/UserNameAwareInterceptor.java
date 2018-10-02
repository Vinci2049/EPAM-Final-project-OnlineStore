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

//    @Override
//   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//           throws Exception {
//       
//   	User currentUser = userManager.getUser();
//
//       /*if (Objects.isNull(currentUser)) {
//           response.sendRedirect("/login");
//           return false;
//       }*/
//   	
//           if (currentUser == null) {
//           	String currentUserName = "Не определен";
//           	boolean currentUserIsAdmin = false;
//           	
//           } else {
//           	String currentUserName = "Определен";
//           	boolean currentUserIsAdmin = true;
////           	modelAndView.addObject("currentUserName", currentUser.getLogin());
////           	modelAndView.addObject("currentUserIsAdmin", currentUser.getIsAdmin());
//           
//       }
//
//       return true;
//
//   }    
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) {
    	
 		User currentUser = userManager.getUser();
		
		if (modelAndView != null) {
			//System.out.println(modelAndView);
			//System.out.println(currentUser);
			//System.out.println(modelAndView==null);
			//System.out.println(currentUser==null);
			////modelAndView.addObject("currentUser", currentUser);
			
			if (currentUser == null) {
			
//				modelAndView.addObject("currentUser", currentUser);
				modelAndView.addObject("currentUserName", "Не определен");
				modelAndView.addObject("currentUserIsAdmin", false);
				
			} else {
			 
//				modelAndView.addObject("currentUser", currentUser);
				modelAndView.addObject("currentUserName", "Определен");
				modelAndView.addObject("currentUserIsAdmin", true);
			//	modelAndView.addObject("currentUserName", currentUser.getLogin());
			//	modelAndView.addObject("currentUserIsAdmin", currentUser.getIsAdmin());
			}	
			
			}
		
		}
    
}
