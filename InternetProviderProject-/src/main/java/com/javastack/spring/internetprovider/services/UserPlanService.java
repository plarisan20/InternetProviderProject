package com.javastack.spring.internetprovider.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javastack.spring.internetprovider.models.UserPlan;
import com.javastack.spring.internetprovider.repositories.UserPlanRepository;

@Service
public class UserPlanService {
	@Autowired
	private UserPlanRepository userplanRepo;
	
	
	//Create
	public UserPlan createUserPlan(UserPlan newUserPlan) {
		return userplanRepo.save(newUserPlan);
	}
	
	
	// READ
	public List<UserPlan> getAllUserPlan() {
		return userplanRepo.findAll();
	}
	
	// READ BY ID	
	public UserPlan getByIdUserPlan(Long id) {
		Optional<UserPlan> possibleUserPlan = userplanRepo.findById(id);
	return possibleUserPlan.isPresent() ? possibleUserPlan.get() : null;
	// if the possibleUserPlan is present or exist: then get the specific ID: or else return nothing
	}
	
	//UPDATE
	public UserPlan updateUserPlan(UserPlan updatedUserPlan) {
		return userplanRepo.save(updatedUserPlan);
		// Implement the logic to update an existing book in the database
	}
	
	//DELETE by ID
	public void deleteUserPlan(Long Id) {
		userplanRepo.deleteById(Id);
		// Implement the logic to delete a book by its ID from the database
	}
}
