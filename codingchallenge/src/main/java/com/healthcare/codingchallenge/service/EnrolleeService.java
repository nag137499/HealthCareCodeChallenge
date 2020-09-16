package com.healthcare.codingchallenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.healthcare.codingchallenge.exception.ResourceNotFoundException;
import com.healthcare.codingchallenge.model.Enrollee;
import com.healthcare.codingchallenge.repository.EnrolleeRepository;

/**
 * @author 137499
 *
 */
@Service
public class EnrolleeService {
	
	@Autowired
	private EnrolleeRepository enrolleeRepository; 
	
	/**
	 * @param enrollee
	 */
	public List<Enrollee> fetchAllEnrollees() {
		return (List<Enrollee>) this.enrolleeRepository.findAll();
		
	}
	
	public Enrollee getEnrolleeById(Long enrolleId) {
		return this.enrolleeRepository.findById(enrolleId)
				.orElseThrow(() -> new ResourceNotFoundException("Enrollee", "id", enrolleId));
	}

	public Enrollee saveEnrollee(Enrollee enrollee) {
		
		return enrolleeRepository.save(enrollee);
	}

	public Enrollee updateEnrollee(Long enrolleeId, Enrollee enrolleeDetails) {
		
		Enrollee enrollee = enrolleeRepository.findById(enrolleeId)
	            .orElseThrow(() -> new ResourceNotFoundException("Enrollee", "id", enrolleeId));

		enrollee.setName(enrolleeDetails.getName());
		enrollee.setActivationStatus(enrolleeDetails.getActivationStatus());
		enrollee.setDob(enrolleeDetails.getDob());
		enrollee.setPhoneNumber(enrolleeDetails.getPhoneNumber());

	    Enrollee updatedEnrollee = enrolleeRepository.save(enrollee);
	    
		return updatedEnrollee;
	}
	
	public ResponseEntity<?> deleteEnrollee(Long enrolleeId) {
		Enrollee enrollee = enrolleeRepository.findById(enrolleeId)
	            .orElseThrow(() -> new ResourceNotFoundException("Enrollee", "id", enrolleeId));

		enrolleeRepository.delete(enrollee);
	    return ResponseEntity.ok().build();
	}

}
