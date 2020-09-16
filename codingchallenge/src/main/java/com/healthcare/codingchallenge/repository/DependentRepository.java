package com.healthcare.codingchallenge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.codingchallenge.model.Dependent;


/**
 * @author 137499
 *
 */
@Repository
public interface DependentRepository extends CrudRepository<Dependent, Long>{		
	
	List<Dependent> findByEnrolleeId(Long enrolleeId);
	Optional<Dependent> findByIdAndEnrolleeId(Long id, Long enrolleeId);
	
}