package com.epam.training.onlineStore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.training.onlineStore.model.User;
import com.epam.training.onlineStore.service.UserService;

@Controller
public class UserController {

	private final UserService userService;
	
    //@Autowired
    //private UserManager userManager;
    
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
    @RequestMapping("/users")
//    public ModelAndView hello(HttpServletRequest request,
//            @PathVariable(name = "pageId", required = false) String pageId) {
	public ModelAndView users(HttpServletRequest request) {
        
    	ModelAndView modelAndView = new ModelAndView();
        
        //User currentUser = userManager.getUser();
       
        List<User> users = userService.getAll();
        
        modelAndView.setViewName("users");

        modelAndView.addObject("users", users);

        return modelAndView;
    }
	
}
