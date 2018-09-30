package com.epam.training.onlineStore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.training.onlineStore.service.OrderService;
import com.epam.training.onlineStore.model.Order;

@Controller
public class OrderController {
	
	private final OrderService orderService;
	    
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	
    @RequestMapping("/orders")
//    public ModelAndView hello(HttpServletRequest request,
//            @PathVariable(name = "pageId", required = false) String pageId) {
	public ModelAndView hello(HttpServletRequest request) {
        
    	ModelAndView modelAndView = new ModelAndView();
        
        //User currentUser = userManager.getUser();
       
        List<Order> orders = orderService.getAll();
        
        modelAndView.setViewName("orders");        
        	
        modelAndView.addObject("orders", orders);

        return modelAndView;
    }
	
    
    @RequestMapping("/order/{orderId}")
    public ModelAndView product(HttpServletRequest request,
             @PathVariable(name = "orderId", required = false) Long orderId) {
        
    	ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.setViewName("order");
        
        Order order = orderService.findById(orderId);

        modelAndView.addObject("order", order);

        return modelAndView;
    }

        
    @GetMapping("/orders/new")
    public String initCreationForm(ModelMap model) {
    	
    	// Проверяем авторизован ли пользователь
    	
        Order order = new Order();
        model.put("order", order);
        return "orderCreateUpdate";
    }
    
    
    @PostMapping("/orders/new")
    public String processCreationForm(@Valid Order order, BindingResult result, ModelMap model) {
        /*if (StringUtils.hasLength(order.getName()) && order.isNew()){
            result.rejectValue("name", "duplicate", "already exists");
        }   ВРЕМЕННО !!! */  
         if (result.hasErrors()) {
            model.put("order", order);
            return "orderCreateUpdate";
        } else {
            //this.products.save(product);
        	orderService.add(order);
            //return "redirect:/owners/{ownerId}";
        	return "redirect:/orders";
        }
    }    
    
    
    @GetMapping("/orders/{orderId}/edit")
    public String initUpdateForm(@PathVariable("productId") long orderId, ModelMap model) {
        Order order = orderService.findById(orderId);
        model.put("order", order);
         return "orderCreateUpdate";
    }
    
        
    @PostMapping("/orders/{orderId}/edit")
    public String processUpdateForm(@Valid Order order, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.put("order", order);
            return "orderCreateUpdate";
        } else {
            //owner.addPet(pet);
            //this.pets.save(pet);
        	orderService.edit(order);
            //return "redirect:/owners/{ownerId}";
        	return "redirect:/orders";
        }
    }
    
	@RequestMapping("/orders/{orderId}/delete")
    public String removeFromCart(HttpServletRequest request,
         @PathVariable(name = "orderId", required = false) Long orderId) {
    	
	  	orderService.deleteById(orderId);

    	return "redirect:/orders";

	}
    
    
}
