package com.iknowhow.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iknowhow.springboot.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
