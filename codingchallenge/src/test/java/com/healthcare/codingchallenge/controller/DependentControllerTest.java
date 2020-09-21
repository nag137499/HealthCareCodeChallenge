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

import com.healthcare.codingchallenge.service.DependentService;
import com.healthcare.codingchallenge.service.EnrolleeService;
import com.healthcare.codingchallenge.controller.EnrolleeController;
import com.healthcare.codingchallenge.controller.DependentControllerTest;
import com.healthcare.codingchallenge.model.Dependent;
import com.healthcare.codingchallenge.model.Enrollee;

public class DependentControllerTest {

	@InjectMocks
	private DependentController dependentController;

	@Mock
	private DependentService dependentService;

	@Mock
	private EnrolleeService enrolleeService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetDependentsByEnrollee() {
		Enrollee enrollee = new Enrollee();
		enrollee.setId(1l);
		enrollee.setName("Nag");
		enrollee.setActivationStatus(true);
		enrollee.setDob(new Date());

		Dependent dependent = new Dependent();
		dependent.setId(11l);
		dependent.setDependentName("Dependent1");
		dependent.setDob(new Date());
		dependent.setEnrollee(enrollee);

		List<Dependent> dependentList = new ArrayList<Dependent>();
		dependentList.add(dependent);

		Mockito.when(dependentService.findByEnrolleeId(enrollee.getId())).thenReturn(dependentList);

		List<Dependent> result = dependentController.getDependentsByEnrollee(enrollee.getId());

		Mockito.verify(dependentService).findByEnrolleeId(enrollee.getId());

		assertEquals(dependentList, result);

	}

	@Test
	public void testCreateDependent() {

		Enrollee enrollee = new Enrollee();
		enrollee.setId(1l);
		enrollee.setName("Nag");
		enrollee.setActivationStatus(true);
		enrollee.setDob(new Date());

		Dependent dependent = new Dependent();
		dependent.setId(11l);
		dependent.setDependentName("Dependent1");
		dependent.setDob(new Date());
		dependent.setEnrollee(enrollee);

		Mockito.when(enrolleeService.getEnrolleeById(enrollee.getId())).thenReturn(enrollee);

		Mockito.when(dependentService.createDependent(enrollee.getId(), dependent)).thenReturn(dependent);

		Dependent result = dependentController.createDependent(enrollee.getId(), dependent);

		Mockito.verify(dependentService).createDependent(enrollee.getId(), dependent);

		assertEquals(dependent, result);
		assertEquals(dependent.getEnrollee(), result.getEnrollee());
	}

	@Test
	public void testUpdateDependent() {
		Enrollee enrollee = new Enrollee();
		enrollee.setId(1l);
		enrollee.setName("Nag");
		enrollee.setActivationStatus(true);
		enrollee.setDob(new Date());

		Dependent dependent = new Dependent();
		dependent.setId(11l);
		dependent.setDependentName("Dependent1");
		dependent.setDob(new Date());
		dependent.setEnrollee(enrollee);

		Dependent Updateddependent = new Dependent();
		Updateddependent.setId(11l);
		Updateddependent.setDependentName("Dependent11");
		Updateddependent.setDob(new Date());
		Updateddependent.setEnrollee(enrollee);

		Mockito.when(enrolleeService.getEnrolleeById(enrollee.getId())).thenReturn(enrollee);

		Mockito.when(dependentService.updateDependent(enrollee.getId(), dependent.getId(), Updateddependent))
				.thenReturn(Updateddependent);

		Dependent result = dependentController.updateDependent(enrollee.getId(), dependent.getId(), Updateddependent);

		Mockito.verify(dependentService).updateDependent(enrollee.getId(), dependent.getId(), Updateddependent);

		assertEquals(Updateddependent, result);
		assertEquals(Updateddependent.getEnrollee(), result.getEnrollee());
	}

	@Test
	public void testDeleteDependent() {
		Enrollee enrollee = new Enrollee();
		enrollee.setId(1l);
		enrollee.setName("Nag");
		enrollee.setActivationStatus(true);
		enrollee.setDob(new Date());

		Dependent dependent = new Dependent();
		dependent.setId(11l);
		dependent.setDependentName("Dependent1");
		dependent.setDob(new Date());
		dependent.setEnrollee(enrollee);

		Mockito.when(dependentService.deleteDependent(enrollee.getId(), dependent.getId()))
				.thenReturn(ResponseEntity.ok().build());

		ResponseEntity<?> result = dependentController.deleteDependent(enrollee.getId(), dependent.getId());

		Mockito.verify(dependentService).deleteDependent(enrollee.getId(), dependent.getId());

		assertEquals(ResponseEntity.ok().build(), result);

	}
}
