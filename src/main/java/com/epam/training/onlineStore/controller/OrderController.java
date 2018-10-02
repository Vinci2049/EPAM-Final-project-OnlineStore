package com.epam.training.onlineStore.controller;

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
//    public ModelAndView hello(HttpServletRequest request,
//            @PathVariable(name = "pageId", required = false) String pageId) {
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

        
    
    
   /* @GetMapping("/orders/new")
    public String initCreationForm(ModelMap model) {
    	
 		User currentUser = userManager.getUser();
        Cart cart = cartService.findById(currentUser.getId()); 	
    	Order order = new Order(cart);
    	
//    	order.setDate(order.getDate());
    	order.setUser(order.getUser());
    	order.setIsPaid(true);
//    	order.setProductList(cart.getProductList());
    	order.setCost(555.0);
    	
    	//Order order = new Order();
    	
    	// Тут надо удалить все из корзины, так как товары перешли в заказ
   	
        
        model.put("order", order);
        return "orderCreateUpdate";
        
    }*/
    

	@PostMapping("/orders/new")
//    public String saveProduct(@Valid Cart cart, BindingResult result,
//            ModelMap model)  throws Exception{
	public ModelAndView createOrder(HttpServletRequest request) {
 		
    	ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.setViewName("orderCreateUpdate");

        User currentUser = userManager.getUser();
        Cart cart = cartService.findById(currentUser.getId()); 	
    	Order order = new Order(cart);

    	
		/*if (result.hasErrors()) {
		//обрабатываем ошибки валидации
		}*/
		
       	orderService.add(order);      	
		
		//устанавливаем нужные флаги, выкидываем сообщение для пользователя, что все прошло ок, и т.д.
		
       	modelAndView.addObject("order", order);
       	modelAndView.addObject("userLogin", currentUser.getLogin());
        return modelAndView;
        
		//return "orders";
    	//return "redirect:/orders";
		}   
    
    
//    @GetMapping("/orders/new")
//    public String initCreationForm(ModelMap model) {
//    	
// 		User currentUser = userManager.getUser();
//        Cart cart = cartService.findById(currentUser.getId()); 	
//    	Order order = new Order(cart);
//    	
////    	order.setDate(order.getDate());
//    	order.setUser(order.getUser());
//    	order.setIsPaid(true);
////    	order.setProductList(cart.getProductList());
//    	order.setCost(555.0);
//    	
//    	//Order order = new Order();
//    	
//    	// Тут надо удалить все из корзины, так как товары перешли в заказ
//   	
//        
//        model.put("order", order);
//        return "orderCreateUpdate";
//        
//    }
//    
//
//	@PostMapping("/orders/new")
//    public String saveProduct(@Valid Order order, BindingResult result,
//            ModelMap model)  throws Exception{
//
//		if (result.hasErrors()) {
//		//обрабатываем ошибки валидации
//		}
//		
//       	orderService.add(order);      	
//		
//		//устанавливаем нужные флаги, выкидываем сообщение для пользователя, что все прошло ок, и т.д.
//		
//		//return "orders";
//    	return "redirect:/orders";
//		}
    
    
//    @PostMapping("/orders/new")
//    public String processCreationForm(@Valid Order order, BindingResult result, ModelMap model) {
//            	
////    	if (StringUtils.hasLength(order.getName()) && order.isNew()){
////            result.rejectValue("name", "duplicate", "already exists");
////        }   ВРЕМЕННО !!! */  
//    	
//    	/*if (order.getId() != 0  && order.isNew()){
//            result.rejectValue("id", "duplicate", "already exists");
//        } */  
//
//         if (result.hasErrors()) {
//            model.put("order", order);
//    		
//            return "orderCreateUpdate";
//        } else {
//            //this.products.save(product);
//        	orderService.add(order);
//            //return "redirect:/owners/{ownerId}";
//        	return "redirect:/orders";
//        }
//    }    
    
	@RequestMapping("/orders/{orderId}/setPaid")
    public String setisPaid(HttpServletRequest request,
         @PathVariable(name = "orderId", required = false) Long orderId,
         @PathVariable(name = "isPaid", required = false) boolean isPaid) {
    	
	  	orderService.setPaidById(orderId, isPaid);

    	return "redirect:/orders";

	}
    
    /*@GetMapping("/orders/{orderId}/edit")
    public String initUpdateForm(@PathVariable("orderId") long orderId, ModelMap model) {
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
    }*/
    
	/*@RequestMapping("/orders/{orderId}/delete")
    public String removeFromCart(HttpServletRequest request,
         @PathVariable(name = "orderId", required = false) Long orderId) {
    	
	  	orderService.deleteById(orderId);

    	return "redirect:/orders";

	}*/
    
    
}
