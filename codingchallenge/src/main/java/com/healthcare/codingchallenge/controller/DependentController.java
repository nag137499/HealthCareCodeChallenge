package com.healthcare.codingchallenge.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.codingchallenge.exception.ResourceNotFoundException;
import com.healthcare.codingchallenge.model.Dependent;
import com.healthcare.codingchallenge.service.DependentService;



/**
 * @author 137499
 *
 */
@RestController
@RequestMapping("/api")
public class DependentController {

	
	@Autowired
	private DependentService dependentService;

	// Get Dependents
	@GetMapping("/enrollees/{enrolleeId}/dependents")
	public List<Dependent> getDependentsByEnrollee(@PathVariable(value = "enrolleeId") Long enrolleeId) {
		return dependentService.findByEnrolleeId(enrolleeId);

	}

	//Create a Dependent
	@PostMapping("/enrollees/{enrolleeId}/dependents")
	public Dependent createDependent(@PathVariable(value = "enrolleeId") Long enrolleeId,
			@Valid @RequestBody Dependent dependent) throws ResourceNotFoundException {

		return dependentService.createDependent(enrolleeId, dependent);

	}

	// Update Dependent
	@PutMapping("/enrollees/{enrolleeId}/dependents/{Id}")
	public Dependent updateDependent(@PathVariable(value = "enrolleeId") Long enrolleeId,
			@PathVariable(value = "Id") Long dependentId, @Valid @RequestBody Dependent dependentDetails)
			throws ResourceNotFoundException {

		return dependentService.updateDependent(enrolleeId, dependentId, dependentDetails);
	}

	// Delete a Dependent
	@DeleteMapping("/enrollees/{enrolleeId}/dependents/{Id}")
	public ResponseEntity<?> deleteDependent(@PathVariable(value = "enrolleeId") Long enrolleeId,
			@PathVariable(value = "Id") Long dependentId) throws ResourceNotFoundException {

		return dependentService.deleteDependent(enrolleeId, dependentId);
	}

}
