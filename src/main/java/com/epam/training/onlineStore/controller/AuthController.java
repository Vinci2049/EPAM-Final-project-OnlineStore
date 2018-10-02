package com.epam.training.onlineStore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.training.onlineStore.model.User;
import com.epam.training.onlineStore.service.UserManager;
import com.epam.training.onlineStore.service.UserService;

@Controller
public class AuthController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private UserService userService;    
    
    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        User user = userManager.getUser();
        if (user != null) {
            modelAndView.setViewName("redirect:/index.html"); 
        }
        return modelAndView;

    }
    
   
    @PostMapping("/login")
    public ModelAndView loginCheck(
    	@ModelAttribute(value = "login") String login,
    	@ModelAttribute(value = "password") String password) {
    	
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.checkLoginAndPasswordAndGetUser(login, password);
        if (user != null) {
            userManager.setUser(user);
            modelAndView.setViewName("redirect:/login");
        } else {
            modelAndView.addObject("result", "Ошибка!");
        }
        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");

        request.getSession().invalidate();

        return modelAndView;
    }
    
    
    @GetMapping("/registration")
    public ModelAndView registrationPage() {
        
    	ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("registration");

        return modelAndView;

    }

    @PostMapping("/registration")
    
    public ModelAndView registration(@Validated User user, BindingResult result) {
    
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");

        if (result.hasErrors()) {
            modelAndView.addObject("errors", result.getAllErrors());
        }
        
        if (result.hasErrors()) {
            modelAndView.addObject("result", "Исправьте ошибки");
        } else if (!userService.checkAndAddUser(user)) {
            modelAndView.addObject("result", "Логин занят");
        } else {
            modelAndView.addObject("result", "Регистрация успешна");
        }
        return modelAndView;

    }

}
