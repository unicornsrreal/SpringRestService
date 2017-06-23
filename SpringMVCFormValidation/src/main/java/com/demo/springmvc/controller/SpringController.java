package com.demo.springmvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.springmvc.model.User;
import com.demo.springmvc.service.UserService;

@Controller
@Component
@RequestMapping("/")
public class SpringController {

	@Autowired
	UserService userService;
	/*
	 * This method will serve as default GET handler.
	 */
	@RequestMapping(value={"/userRegistration"},method = RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "userRegistration";
	}

	/*
	 * This method will be called on form submission, handling POST request It
	 * also validates the user input
	 */
	@RequestMapping(value={"/newuser"},method = RequestMethod.POST)
	public String saveUser(@Valid User user,
			BindingResult result, ModelMap model) {

		System.out.println("User invoked");
		if (result.hasErrors()) {
			return "userRegistration";
		}

		userService.saveUser(user);
		
		model.addAttribute("success", "Dear " + user.getFirstName()
				+ " , your Registration completed successfully");
		return "success";
	}

	

}