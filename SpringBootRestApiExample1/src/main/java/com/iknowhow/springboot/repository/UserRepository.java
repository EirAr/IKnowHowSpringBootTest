package com.iknowhow.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iknowhow.springboot.model.User;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long>{
	
}
