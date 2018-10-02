package com.epam.training.onlineStore.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.epam.training.onlineStore.exception.NotFoundException;

@ControllerAdvice
public class ExceptionHandlerControllerr {
    
    
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleException(NotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("error", ex.getMessage());
        return modelAndView;
    }
    
}
