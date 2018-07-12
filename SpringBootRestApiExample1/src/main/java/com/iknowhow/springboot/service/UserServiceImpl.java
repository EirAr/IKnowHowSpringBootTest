package com.iknowhow.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.iknowhow.springboot.model.User;
import com.iknowhow.springboot.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User findById(long id) {
		 return userRepository.findOne(id);
	}

	@Override
	public User findByName(String name) {
		return null;
	}

	@Override
	public void saveUser(User user) {
		userRepository.save(user);

	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void deleteUserById(long id) {
		userRepository.delete(id);
	}

	@Override
	public List<User> findAllUsers() {
		return null;
	}
	
	@Override
	public void deleteAllUsers() {
		userRepository.deleteAll();
	}

	@Override
	public boolean isUserExist(User user) {
		return userRepository.exists(user.getId());
	}
	
}
