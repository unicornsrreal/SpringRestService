package com.demo.springmvc.service;

import java.util.List;

import com.demo.springmvc.model.User;

public interface UserService {

	User findUser(int id);
	void saveUser(User user);
	void deleteUser(int id);
	List<User> findAllUsers();
	User findByLastName(String lastName);
	void editUser(User user);
	
}
