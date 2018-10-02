package com.epam.training.onlineStore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.training.onlineStore.service.ProductService;
import com.epam.training.onlineStore.model.Product;

@Controller
public class ProductController {
	
	private final ProductService productService;
	    
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	
    @RequestMapping("/index.html")
	public ModelAndView hello(HttpServletRequest request) {
        
    	ModelAndView modelAndView = new ModelAndView();
        
        //User currentUser = userManager.getUser();
       
        List<Product> products = productService.getAll();
        
        modelAndView.setViewName("products");        
        	
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

        
//    @GetMapping("/newProduct")
//    //public String listproduct(Model model) {
//        public ModelAndView listproduct(Model model) {
//        
//    	ModelAndView modelAndView = new ModelAndView();
//        
//        modelAndView.setViewName("productnew");
//        
//        return modelAndView;
//        
//    }
    
    @GetMapping("/products/new")
    public String initCreationForm(ModelMap model) {
        Product product = new Product();
        //owner.addPet(pet);
        model.put("product", product);
        //return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        return "productCreateUpdate";
    }
    
   
    @PostMapping("/products/new")
    public String processCreationForm(@Valid Product product, BindingResult result, ModelMap model) {
        if (StringUtils.hasLength(product.getName()) && product.isNew()){
            result.rejectValue("name", "duplicate", "already exists");
        }
        //owner.addPet(pet);
        if (result.hasErrors()) {
            model.put("product", product);
            //return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
            return "productCreateUpdate";
        } else {
            //this.products.save(product);
        	productService.add(product);
            //return "redirect:/owners/{ownerId}";
        	return "redirect:/index.html";
        }
    }    
    
    
//    @GetMapping("/productEdit")
//    //public String listproduct(Model model) {
//        public ModelAndView listproductEdit(Model model) {
//       
//    	ModelAndView modelAndView = new ModelAndView();
//        
//        modelAndView.setViewName("productEdit");
//        
//        return modelAndView;
//        
//    }
    
    @GetMapping("/products/{productId}/edit")
    public String initUpdateForm(@PathVariable("productId") long productId, ModelMap model) {
        Product product = productService.findById(productId);
        model.put("product", product);
        //return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        return "productCreateUpdate";
    }
    
    
//    @PostMapping("product/edit")
////  public ModelAndView addProduct(HttpServletRequest request,
////          @PathVariable(name = "pageId", required = false) String pageId) {
//      
//	public String editProduct(Model model,
//          Product product) {
//
//    	productService.edit(product);
//  	
//    	return "redirect:/index.html";
//
//	}
    
    @PostMapping("/products/{productId}/edit")
    public String processUpdateForm(@Valid Product product, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            //pet.setOwner(owner);
            model.put("product", product);
            //return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
            return "productCreateUpdate";
        } else {
            //owner.addPet(pet);
            //this.pets.save(pet);
        	productService.edit(product);
            //return "redirect:/owners/{ownerId}";
        	return "redirect:/index.html";
        }
    }
        
    
	@RequestMapping("/products/{productId}/delete")
    public String deleteProduct(HttpServletRequest request,
         @PathVariable(name = "productId", required = false) Long productId) {
    	
	  	productService.deleteById(productId);

    	return "redirect:/index.html";

	}
    
    
}
