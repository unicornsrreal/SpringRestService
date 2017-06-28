package com.demo.springmvc.dao;

import java.util.List;

import com.demo.springmvc.model.User;

public interface UserDao {

	User findUser(int id);
	void saveUser(User user);
	void deleteUser(User user);
	List<User> findAllUsers();
	User findByLastName(String lastName);
	void deleteUserById(int id);
	void updateUser(User user);
}
