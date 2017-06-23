package com.demo.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.demo.springmvc.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	@Override
	public User findUser(int id) {

		User user = getByKey(id);
		return user;
	}

	@Override
	public void saveUser(User user) {
		persist(user);
	}

	@Override
	public void deleteUser(User user) {
		delete(user);

	}

	@Override
	public List<User> findAllUsers() {
		Criteria criteria = createEntityCriteria();
		return (List<User>) criteria.list();
	}

	@Override
	public User findByLastName(String lastName) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("lastName", lastName));
		return (User) criteria.uniqueResult();
	}

}
