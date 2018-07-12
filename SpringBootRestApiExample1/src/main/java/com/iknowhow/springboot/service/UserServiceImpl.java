package com.iknowhow.springboot.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iknowhow.springboot.model.User;
import com.iknowhow.springboot.repository.UserRepository;


@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
		
	@PersistenceContext
	 private EntityManager em;
	
	@Override
	public User findById(long id) {
		return em.find(User.class, id);

	}

	@Override
	public User findByName(String name) {
		return em.find(User.class, name);
	}

	@Override
	public void saveUser(User user) {
		em.persist(user);

	}

	@Override
	public void updateUser(User user) {
		em.merge(user);
	}

	@Override
	public void deleteUserById(long id) {
		User user = findById(id);
		if (user != null) {
			em.remove(user);
		}
	}

	@Override
	public List<User> findAllUsers() {
		
		return userRepository.findAll();
	}
	
	@Override
	public void deleteAllUsers() {
		
	}

	@Override
	public boolean isUserExist(User user) {
		return findById(user.getId())!=null;
	}
	

	
}
