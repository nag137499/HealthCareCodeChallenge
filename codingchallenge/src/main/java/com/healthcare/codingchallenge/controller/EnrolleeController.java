package com.healthcare.codingchallenge.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.codingchallenge.model.Enrollee;
import com.healthcare.codingchallenge.service.EnrolleeService;

/**
 * @author 137499
 *
 */
@RestController
@RequestMapping("/api")
public class EnrolleeController {

	@Autowired
	private EnrolleeService service;

	// Get All Enrollees
	@GetMapping("/enrollees")
	public @ResponseBody List<Enrollee> getAllEnrollees() {

		return service.fetchAllEnrollees();

	}

	// Get a Single Enrollee
	@GetMapping("/enrollees/{id}")
	public @ResponseBody Enrollee getEnrolleeById(@PathVariable(value = "id") long enrolleeID) {

		return service.getEnrolleeById(enrolleeID);
	}
	
	// Create a new Enrollee
	@PostMapping("/enrollee")
	public Enrollee createEnrollee(@Valid @RequestBody Enrollee enrollee) {
	    return service.saveEnrollee(enrollee);
	}
	
	//Update Enrollee
	@PutMapping("/enrollee/{id}")
	public Enrollee updateEnrollee(@PathVariable(value = "id") Long enrolleeId,
	                                        @Valid @RequestBody Enrollee enrolleeDetails) {

	
	    return service.updateEnrollee(enrolleeId, enrolleeDetails);
	}
	
	// Delete a Enrollee
	@DeleteMapping("/enrollees/{id}")
	public ResponseEntity<?> deleteEnrollee(@PathVariable(value = "id") Long enrolleeId) {
	    
	    return service.deleteEnrollee(enrolleeId);
	}
	
	@GetMapping(path = "/error")
	public void handleError(HttpServletRequest request) {

	}

	public String getErrorPath() {
		return "/error";
	}
	
}
