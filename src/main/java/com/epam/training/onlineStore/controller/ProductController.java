package com.epam.training.onlineStore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.training.onlineStore.service.ProductService;
import com.epam.training.onlineStore.service.UserManager;
import com.epam.training.onlineStore.model.Product;

@Controller
public class ProductController {
	
	private final ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
    @Autowired
    private UserManager userManager;
	
    @RequestMapping("/index.html")
    public ModelAndView hello(HttpServletRequest request,
            @PathVariable(name = "pageId", required = false) String pageId) {
        
    	ModelAndView modelAndView = new ModelAndView();
        
        
        List<Product> products = productService.getAll();
        
        modelAndView.setViewName("products");

        //User currentUser = userManager.getUser();

        modelAndView.addObject("products", products);

        return modelAndView;
    }
	
    
    @RequestMapping("/product/{productId}")
    public ModelAndView product(HttpServletRequest request,
             @PathVariable(name = "productId", required = false) Long productId) {
        
    	ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.setViewName("product");
        
        Product product = productService.findById(productId);

        modelAndView.addObject("product", product);

        return modelAndView;
    }

        
    @GetMapping("/newProduct")
    //public String listproduct(Model model) {
        public ModelAndView listproduct(Model model) {
        
    	ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.setViewName("newproduct");
        
        return modelAndView;
        
    }
    
    
    @PostMapping("product/new")
//  public ModelAndView addProduct(HttpServletRequest request,
//          @PathVariable(name = "pageId", required = false) String pageId) {
      
	public String newProduct(Model model,
          Product product) {

    	productService.add(product);
  	
    	return "redirect:/index.html";

	}    
       
}
