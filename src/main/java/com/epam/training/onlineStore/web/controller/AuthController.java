package com.epam.training.onlineStore.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.training.onlineStore.model.User;
import com.epam.training.onlineStore.exception.NotFoundException;
import com.epam.training.onlineStore.service.UserManager;

@Controller
public class AuthController {

    @Autowired
    private UserManager userManager;

    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login-page");

        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login-page");

        request.getSession().invalidate();

        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(User user) {
        ModelAndView modelAndView = new ModelAndView();
        
        if (user.getLogin().equals("hacker")) {
            throw new NotFoundException("Хакер уходи");
        }

        if (!user.getPassword().equals("123")) {
            modelAndView.addObject("errorMsg", "Пароль неверен");
            modelAndView.setViewName("login-page");
        } else {
            User currentUser = new User();
            currentUser.setLogin(user.getLogin());

            
            if (user.getLogin().equals("Admin")) {
                currentUser.setRole("ADMIN");
            } else {
                currentUser.setRole("USER");
            }

            userManager.setUser(currentUser);

            modelAndView.setViewName("redirect:/home");
        }

        return modelAndView;

    }

    @GetMapping("/registration")
    public ModelAndView registrationPage(User user) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("registration");

        return modelAndView;

    }

    @PostMapping("/registration")
    public ModelAndView registration(@Validated User user, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();

        if (result.hasErrors()) {
            modelAndView.addObject("errors", result.getAllErrors());
        }

        return modelAndView;
    }

//    @ExceptionHandler(NotFoundException.class)
//    public ModelAndView handleException(RuntimeException ex) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("error");
//        modelAndView.addObject("error", ex.getMessage());
//        return modelAndView;
//    }
}
