package com.epam.training.onlineStore.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    
    /*@PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestParam(required = false) String id, @RequestBody String note) {
        if (StringUtils.isEmpty(id)) {
            id = note.split(" ")[0];
        }
        products.put(id, note);
        return id;
    }*/    
    
    /*@PostMapping("/product/add")
    //@PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    //public void createProduct(@RequestBody Product request) {
    public void createProduct(@RequestBody Product product) {

    	Product product2 = new Product ("NAME2", 20.0);
    	
        productService.add(product2);
    }*/

    
    //@GetMapping("add_diagnosis")
    /*@GetMapping("add_product")
    public String listTreatment(Model model) {
        List<Product> products = this.productService.getAll();
        model.addAttribute("treatments", products);

        return "doctor/add_diagnosis";
    }*/

    @PostMapping("products/new")
//    public ModelAndView addProduct(HttpServletRequest request,
//            @PathVariable(name = "pageId", required = false) String pageId) {
        
    public String addProduct(HttpServletRequest request,
            @PathVariable(name = "pageId", required = false) String pageId) {

     	Product product = new Product("name_name", 30.0);	// ВРЕМЕННО УБРАТЬ PAGEID
     	
    	productService.add(product);

        return "redirect:/index.html";
    }    

}
