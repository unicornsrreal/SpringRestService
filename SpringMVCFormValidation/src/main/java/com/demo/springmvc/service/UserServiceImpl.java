package com.demo.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springmvc.dao.UserDao;
import com.demo.springmvc.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public User findUser(int id) {
		User user = userDao.findUser(id);
		return user;
	}

	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);

	}

	@Override
	public void deleteUser(User user) {
		userDao.deleteUser(user);

	}

	@Override
	public List<User> findAllUsers() {
		List<User> usersList = userDao.findAllUsers();
		return usersList;
	}

	@Override
	public User findByLastName(String lastName) {
		User user = userDao.findByLastName(lastName);
		return user;
	}

}
