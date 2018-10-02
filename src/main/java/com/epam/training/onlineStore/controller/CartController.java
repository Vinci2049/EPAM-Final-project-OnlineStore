package com.epam.training.onlineStore.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.training.onlineStore.model.Cart;
import com.epam.training.onlineStore.model.ProductListItem;
import com.epam.training.onlineStore.model.User;
import com.epam.training.onlineStore.service.CartService;
import com.epam.training.onlineStore.service.UserManager;

@Controller
public class CartController {

	private final CartService cartService;
	
	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}
	
    @Autowired
    private UserManager userManager;

	
    @RequestMapping("/cart")
    public ModelAndView hello(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        
 		User currentUser = userManager.getUser();
        Cart cart = cartService.findById(currentUser.getId());
        
    	List<ProductListItem> products = new ArrayList<ProductListItem>();
        
        if (cart == null) {
        	cart = new Cart(currentUser, new Date(), products);
        } else {
        	products = cart.getProductList();
        }
        
        modelAndView.setViewName("cart");

        modelAndView.addObject("cart", cart);
        
        modelAndView.addObject("products", products);

        return modelAndView;
    }

    
	@RequestMapping("/cart/addToCart/{productId}")
    public String addToCart(HttpServletRequest request,
         @PathVariable(name = "productId", required = false) Long productId) {
    	
 		User currentUser = userManager.getUser();
	  	cartService.addProductById(currentUser.getId(), productId);

    	return "redirect:/index.html";

	}

	@RequestMapping("/cart/remove/{productId}")
    public String removeFromCart(HttpServletRequest request,
         @PathVariable(name = "productId", required = false) Long productId) {
    	
 		User currentUser = userManager.getUser();
	  	cartService.removeProductById(currentUser.getId(), productId);

    	return "redirect:/cart";

	}
	
	
}
