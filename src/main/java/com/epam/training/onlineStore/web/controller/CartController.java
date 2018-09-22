package com.epam.training.onlineStore.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.epam.training.onlineStore.model.Cart;
import com.epam.training.onlineStore.model.Product;
import com.epam.training.onlineStore.model.ProductListItem;
import com.epam.training.onlineStore.service.CartService;

@Controller
public class CartController {

	private final CartService cartService;
	
	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}
	
    @RequestMapping("/cart")
    public ModelAndView hello(HttpServletRequest request,
            @PathVariable(name = "pageId", required = false) String pageId) {
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

    
    /*@PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestParam(required = false) String id, @RequestBody String note) {
        if (StringUtils.isEmpty(id)) {
            id = note.split(" ")[0];
        }
        cart.put(id, note);
        return id;
    }*/
    
    
    
    /*@PostMapping("/cart/addToCart")
    public String addProduct(HttpServletRequest request,
          @PathVariable(name = "pageId", required = false) String pageId) {

	   	//Product product = new Product("name_NAME2", 10.0);
	   	
	  	//cartService.addProductById(idProduct);
	
	    return "redirect:"+pageId;
    
  }*/
    
    
    @RequestMapping(value = "/cart/addToCart", params = {"idProduct"}, method = RequestMethod.POST)
    public String addTreatment(Model model, Product product,
                               @RequestParam(value = "idProduct") Long idProduct) {
        //cartService.updateTreatmentPatient(product, idProduct);

    	
	  	cartService.addProductById(idProduct);
    	
        //return listTreatment(model);
	  	//return idProduct.toString();
    	return "reditect:/index.html";
    }
    
    
    
    
}
