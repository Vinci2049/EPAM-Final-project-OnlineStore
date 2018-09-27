package com.epam.training.onlineStore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.training.onlineStore.model.Cart;
import com.epam.training.onlineStore.model.ProductListItem;
import com.epam.training.onlineStore.service.CartService;

@Controller
public class CartController {

	private final CartService cartService;
	
	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}
	
	
    /*@RequestMapping("/**")
    public ModelAndView CartProductCount(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        
        //Map<Product, Integer> productList = cartService.getAll(idClient);
        
        //Cart cart = cartService.findById(1);
        
        //List<ProductListItem> products = cart.getProductList();     
        
        modelAndView.setViewName("header");

        //User currentUser = userManager.getUser();

        //modelAndView.addObject("client", client);
        //modelAndView.addObject("productList", productList);
 
        modelAndView.addObject("cartProductCount", "5");

        //return "5";
        return modelAndView;
    }*/

	
	
    @RequestMapping("/cart")
    public ModelAndView hello(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        
        //Map<Product, Integer> productList = cartService.getAll(idClient);
        
        Cart cart = cartService.findById(1);
        
        List<ProductListItem> products = cart.getProductList();     
        
        modelAndView.setViewName("cart");

        //User currentUser = userManager.getUser();

        //modelAndView.addObject("client", client);
        //modelAndView.addObject("productList", productList);
 
        modelAndView.addObject("products", products);

        return modelAndView;
    }

    
	@RequestMapping("/cart/addToCart/{productId}")
    public String addToCart(HttpServletRequest request,
         @PathVariable(name = "productId", required = false) Long productId) {
    	
	  	cartService.addProductById(productId);

    	return "redirect:/index.html";

	}

	@RequestMapping("/cart/remove/{productId}")
    public String removeFromCart(HttpServletRequest request,
         @PathVariable(name = "productId", required = false) Long productId) {
    	
	  	cartService.removeProductById(productId);

    	return "redirect:/cart";

	}
	
	
}
