package com.javastack.spring.internetprovider.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javastack.spring.internetprovider.models.UserPlan;

@Repository
public interface UserPlanRepository extends CrudRepository<UserPlan, Long> {
	List<UserPlan> findAll();
}
