package com.healthcare.codingchallenge.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.codingchallenge.model.Enrollee;



/**
 * @author 137499
 *
 */
@Repository
public interface EnrolleeRepository extends CrudRepository<Enrollee, Long>{		
	
}