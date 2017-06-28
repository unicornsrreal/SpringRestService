package com.demo.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.springmvc.model.User;
import com.demo.springmvc.service.UserService;

@Controller
@RequestMapping("/")
public class SpringController {

	@Autowired
	UserService userService;

	/*
	 * This method will serve as default GET handler.
	 */
	@RequestMapping(value = { "/userRegistration" }, method = RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "userRegistration";
	}

	/*
	 * This method will be called on form submission, handling POST request It
	 * also validates the user input
	 */
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result, ModelMap model) {

		System.out.println("User invoked" + user.getId());
		if (result.hasErrors()) {
			return "userRegistration";
		}

		userService.saveUser(user);
		return "redirect:/users";
	}

	@RequestMapping(value = { "/users" }, method = RequestMethod.GET)
	public String findUsers(ModelMap model) {

		System.out.println("User list invoked");
		List<User> userList = userService.findAllUsers();
		model.addAttribute("userList", userList);
		return "allUsers";
	}

	@RequestMapping(value = { "/deleteUser/{id}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String id) {

		System.out.println("delete invoked");
		Integer userId = Integer.parseInt(id);
		userService.deleteUser(userId);

		return "redirect:/users";
	}

	@RequestMapping(value = { "/editUser/{id}" }, method = RequestMethod.POST)
	public String editUser(@Valid User user, BindingResult result, ModelMap model, @PathVariable String id) {

		System.out.println("update invoked" + user.getId());
		if (result.hasErrors()) {
			return "userRegistration";
		}
		userService.editUser(user);

		return "redirect:/users";
	}

	/*
	 * This method will provide the medium to update an existing employee.
	 */
	@RequestMapping(value = { "/editUser/{id}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String id, ModelMap model) {
		Integer userId = Integer.parseInt(id);
		User user = userService.findUser(userId);
		model.addAttribute("user", user);

		return "editUser";
	}

}