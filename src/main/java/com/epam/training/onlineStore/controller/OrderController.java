package com.epam.training.onlineStore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.training.onlineStore.service.CartService;
import com.epam.training.onlineStore.service.OrderService;
import com.epam.training.onlineStore.service.UserManager;
import com.epam.training.onlineStore.model.Cart;
import com.epam.training.onlineStore.model.Order;
import com.epam.training.onlineStore.model.ProductListItem;
import com.epam.training.onlineStore.model.User;

@Controller
public class OrderController {
	
	private final OrderService orderService;
	    
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@Autowired
	private CartService cartService;
	
    @Autowired
    private UserManager userManager;

	
    @RequestMapping("/orders")
	public ModelAndView hello(HttpServletRequest request) {
        
    	ModelAndView modelAndView = new ModelAndView();
        
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
    

	@PostMapping("/orders/new")
	public ModelAndView createOrder(HttpServletRequest request) {
 		
    	ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.setViewName("orderCreateUpdate");

        User currentUser = userManager.getUser();
        Cart cart = cartService.findById(currentUser.getId()); 	
    	Order order = new Order(cart);
		
       	orderService.add(order);
       	
       	cartService.clearProductList(currentUser.getId());		

       	modelAndView.addObject("order", order);
       	modelAndView.addObject("userLogin", currentUser.getLogin());
        return modelAndView;        
	}   
        
	@RequestMapping("/orders/{orderId}/setPaid")
    public String setisPaid(HttpServletRequest request,
         @PathVariable(name = "orderId", required = false) Long orderId,
         @PathVariable(name = "isPaid", required = false) boolean isPaid) {
    	
	  	orderService.setPaidById(orderId, isPaid);

    	return "redirect:/orders";
	}    
    
}
