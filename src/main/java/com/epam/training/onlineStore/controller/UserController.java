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

import com.epam.training.onlineStore.model.User;
import com.epam.training.onlineStore.service.UserService;

@Controller
public class UserController {

	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
    @RequestMapping("/users")
//    public ModelAndView hello(HttpServletRequest request,
//            @PathVariable(name = "pageId", required = false) String pageId) {
	public ModelAndView users(HttpServletRequest request) {
        
    	ModelAndView modelAndView = new ModelAndView();
        
        //User currentUser = userManager.getUser();
       
        List<User> users = userService.getAll();
        
        modelAndView.setViewName("users");

        modelAndView.addObject("users", users);

        return modelAndView;
    }
	  
    
    @GetMapping("/users/new")
    public String initCreationForm(ModelMap model) {
        User user = new User();
        //owner.addPet(pet);
        model.put("user", user);
        //return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        return "userCreateUpdate";
    }
    
       
    @PostMapping("/users/new")
    public String processCreationForm(@Valid User user, BindingResult result, ModelMap model) {
        if (StringUtils.hasLength(user.getName()) && user.isNew()){
            result.rejectValue("name", "duplicate", "already exists");
        }
        //owner.addPet(pet);
        if (result.hasErrors()) {
            model.put("user", user);
            //return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
            return "userCreateUpdate";
        } else {
            //this.products.save(product);
        	userService.add(user);
            //return "redirect:/owners/{ownerId}";
        	return "redirect:/users";
        }
    }    
    
    
    @GetMapping("/users/{userId}/edit")
    public String initUpdateForm(@PathVariable("userId") long userId, ModelMap model) {
        User user = userService.findById(userId);
        model.put("user", user);
        //return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        return "userCreateUpdate";
    }
    
        
    @PostMapping("/users/{userId}/edit")
    public String processUpdateForm(@Valid User user, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            //pet.setOwner(owner);
            model.put("user", user);
            //return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
            return "userCreateUpdate";
        } else {
            //owner.addPet(pet);
            //this.pets.save(pet);
        	userService.edit(user);
            //return "redirect:/owners/{ownerId}";
        	return "redirect:/users";
        }
    }
    

    @RequestMapping("/users/{userId}/delete")
    public String removeFromCart(HttpServletRequest request,
         @PathVariable(name = "userId", required = false) Long userId) {
    	
    	userService.deleteById(userId);

    	return "redirect:/users";

	}
    
    
}
