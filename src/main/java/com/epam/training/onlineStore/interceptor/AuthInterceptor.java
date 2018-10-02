package com.epam.training.onlineStore.interceptor;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.epam.training.onlineStore.model.User;
import com.epam.training.onlineStore.service.UserManager;

public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private UserManager userManager;

    /**
     * В текущем методе происходит проверка наличия объекта текущего пользователя {@link User} в менеджере сессионных
     * пользователей {@link SessionUserManager}.
     * <p>
     * Если объект равен null, значит пользователь не проходил через процесс аутентификации, а значит он не авторизован.
     * При этом происходит редирект на страницу логина.
     * 
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        
    	User currentUser = userManager.getUser();

        if (Objects.isNull(currentUser)) {
            response.sendRedirect("/login");
            return false;
        }
    	
           /* if (currentUser == null) {
            	String currentUserName = "Не определен";
            	boolean currentUserIsAdmin = false;
            	
            } else {
            	String currentUserName = "Определен";
            	boolean currentUserIsAdmin = true;
//            	modelAndView.addObject("currentUserName", currentUser.getLogin());
//            	modelAndView.addObject("currentUserIsAdmin", currentUser.getIsAdmin());
            
        }*/


        return true;

    }

    /* @Override
     public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                            ModelAndView modelAndView) {
         User currentUser = userManager.getUser();
         
         if (modelAndView != null) {
//             System.out.println(modelAndView);
//             System.out.println(currentUser);
//             System.out.println(modelAndView==null);
//             System.out.println(currentUser==null);
//             //modelAndView.addObject("currentUser", currentUser);
             
             if (currentUser == null) {
 
             	modelAndView.addObject("currentUserName", "Не определен");
             	modelAndView.addObject("currentUserIsAdmin", false);
             	
             } else {
            	 
             	modelAndView.addObject("currentUserName", "Определен");
             	modelAndView.addObject("currentUserIsAdmin", true);
//             	modelAndView.addObject("currentUserName", currentUser.getLogin());
//             	modelAndView.addObject("currentUserIsAdmin", currentUser.getIsAdmin());
             }	
             
         }
         
//         if (currentUser == null) {
//         	modelAndView.addObject("currentUserName", "Не определен");
//         	modelAndView.addObject("currentUserIsAdmin", false);
//         	
//         } else {
//         	modelAndView.addObject("currentUserName", currentUser.getLogin());
//         	modelAndView.addObject("currentUserIsAdmin", currentUser.getIsAdmin());
//         } 	
     }*/

     
     
     
}
