package com.healthcare.codingchallenge.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.healthcare.codingchallenge.service.EnrolleeService;
import com.healthcare.codingchallenge.controller.EnrolleeController;
import com.healthcare.codingchallenge.model.Enrollee;

public class EnrolleeControllerTest {

	@InjectMocks
	private EnrolleeController enrolleeController;

	@Mock
	private EnrolleeService enrolleeService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetEnrollees() {
		Enrollee enrollee = new Enrollee();
		enrollee.setId(1l);
		enrollee.setName("Nag");
		enrollee.setActivationStatus(true);
		enrollee.setDob(new Date());
		List<Enrollee> enrolleeList = new ArrayList<Enrollee>();
		enrolleeList.add(enrollee);

		Mockito.when(enrolleeService.fetchAllEnrollees()).thenReturn(enrolleeList);

		List<Enrollee> result = enrolleeController.getAllEnrollees();

		Mockito.verify(enrolleeService).fetchAllEnrollees();

		assertEquals(enrolleeList, result);

	}

	@Test
	public void testGetEnrolleeById() {
		Enrollee enrollee = new Enrollee();
		enrollee.setId(1l);
		enrollee.setName("Nag");
		enrollee.setActivationStatus(true);
		enrollee.setDob(new Date());

		Mockito.when(enrolleeService.getEnrolleeById(enrollee.getId())).thenReturn(enrollee);

		Enrollee result = enrolleeController.getEnrolleeById(enrollee.getId());

		Mockito.verify(enrolleeService).getEnrolleeById(enrollee.getId());

		assertEquals(enrollee.getId(), result.getId());

	}

	@Test
	public void testCreateEnrollee() {
		Enrollee enrollee = new Enrollee();
		enrollee.setId(1l);
		enrollee.setName("Nag");
		enrollee.setActivationStatus(true);
		enrollee.setDob(new Date());

		Mockito.when(enrolleeService.saveEnrollee(enrollee)).thenReturn(enrollee);

		Enrollee result = enrolleeController.createEnrollee(enrollee);

		Mockito.verify(enrolleeService).saveEnrollee(enrollee);

		assertEquals(enrollee, result);
		assertEquals(enrollee.getId(), result.getId());

	}

	@Test
	public void testUpdateEnrollee() {
		Enrollee enrollee = new Enrollee();
		enrollee.setId(1l);
		enrollee.setName("Nag");
		enrollee.setActivationStatus(true);
		enrollee.setDob(new Date());

		Enrollee updateEnrollee = new Enrollee();

		updateEnrollee.setName("Arjun");
		updateEnrollee.setActivationStatus(true);
		updateEnrollee.setDob(new Date());

		Mockito.when(enrolleeService.getEnrolleeById(enrollee.getId())).thenReturn(enrollee);

		Mockito.when(enrolleeService.updateEnrollee(enrollee.getId(), updateEnrollee)).thenReturn(updateEnrollee);

		Enrollee result = enrolleeController.updateEnrollee(enrollee.getId(), updateEnrollee);

		Mockito.verify(enrolleeService).updateEnrollee(enrollee.getId(), updateEnrollee);

		assertEquals(updateEnrollee, result);
		assertEquals(updateEnrollee.getName(), result.getName());

	}

	@Test
	public void testDeleteEnrollee() {
		Enrollee enrollee = new Enrollee();
		enrollee.setId(1l);
		enrollee.setName("Nag");
		enrollee.setActivationStatus(true);
		enrollee.setDob(new Date());


		Mockito.when(enrolleeService.deleteEnrollee(enrollee.getId())).thenReturn(ResponseEntity.ok().build());

		ResponseEntity<?> result = enrolleeController.deleteEnrollee(enrollee.getId());

		Mockito.verify(enrolleeService).deleteEnrollee(enrollee.getId());

		assertEquals(ResponseEntity.ok().build(), result);

	}
}
