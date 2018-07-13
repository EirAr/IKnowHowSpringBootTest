package com.iknowhow.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iknowhow.springboot.model.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
	
}
