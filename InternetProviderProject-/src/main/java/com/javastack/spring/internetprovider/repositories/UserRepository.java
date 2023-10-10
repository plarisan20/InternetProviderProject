package com.javastack.spring.internetprovider.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javastack.spring.internetprovider.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

//	List<User> findAll();
	

	Optional<User> findByUserName(String userName);
}
