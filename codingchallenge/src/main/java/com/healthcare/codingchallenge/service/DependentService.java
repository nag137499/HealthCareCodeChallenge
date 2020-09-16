package com.healthcare.codingchallenge.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.healthcare.codingchallenge.exception.ResourceNotFoundException;
import com.healthcare.codingchallenge.model.Dependent;
import com.healthcare.codingchallenge.model.Enrollee;
import com.healthcare.codingchallenge.repository.DependentRepository;
import com.healthcare.codingchallenge.repository.EnrolleeRepository;

/**
 * @author 137499
 *
 */
@Service
public class DependentService {

	@Autowired
	private EnrolleeRepository enrolleeRepository;

	@Autowired
	private DependentRepository dependentRepository;

	public List<Dependent> findByEnrolleeId(Long enrolleeId) {

		return dependentRepository.findByEnrolleeId(enrolleeId);
	}

	public Dependent createDependent(Long enrolleeId, @Valid Dependent dependent) {

		Enrollee enrollee = this.enrolleeRepository.findById(enrolleeId)
				.orElseThrow(() -> new ResourceNotFoundException("Enrollee", "id", enrolleeId));

		dependent.setEnrollee(enrollee);
		return dependentRepository.save(dependent);

	}

	public Dependent updateDependent(Long enrolleeId, Long dependentId, @Valid Dependent dependentDetails) {

		if (!enrolleeRepository.existsById(enrolleeId)) {
			throw new ResourceNotFoundException("Enrollee", "id", enrolleeId);
		}

		Dependent dependent = dependentRepository.findByIdAndEnrolleeId(dependentId, enrolleeId).orElseThrow(
				() -> new ResourceNotFoundException("Dependent not found with id" + dependentId + "in" + enrolleeId,
						"id", dependentId));

		dependent.setDependentName(dependentDetails.getDependentName());
		dependent.setDob(dependentDetails.getDob());

		return dependentRepository.save(dependent);

	}

	public ResponseEntity<?> deleteDependent(Long enrolleeId, Long dependentId) {

		Dependent dependent = dependentRepository.findByIdAndEnrolleeId(dependentId, enrolleeId).orElseThrow(
				() -> new ResourceNotFoundException("Dependent not found with id" + dependentId + "in" + enrolleeId,
						"id", dependentId));
		dependentRepository.delete(dependent);
		return ResponseEntity.ok().build();

	}

}
