package com.iknowhow.springboot.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
	 private EntityManager entityManager;
	
	@Override
	public User findById(long id) {
		return entityManager.find(User.class, id);

	}

	@Override
	public User findByName(String name) {
		return entityManager.find(User.class, name);
	}

	@Override
	public void saveUser(User user) {
		entityManager.persist(user);

	}

	@Override
	public void updateUser(User user) {
		entityManager.merge(user);
	}

	@Override
	public void deleteUserById(long id) {
		User user = findById(id);
		if (user != null) {
			entityManager.remove(user);
		}
	}

	@Override
	public List<User> findAllUsers() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();
		//EntityTransaction userTransaction = em.getTransaction();
		return em.createNamedQuery("EmailDomainTrust.getEmailDomains", User.class).getResultList();
	}
	
	@Override
	public void deleteAllUsers() {
		
	}

	@Override
	public boolean isUserExist(User user) {
		return findById(user.getId())!=null;
	}
	

	
}
