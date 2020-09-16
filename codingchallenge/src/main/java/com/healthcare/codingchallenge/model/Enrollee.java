package com.healthcare.codingchallenge.model;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 137499
 *
 */
@Entity
@Table(name = "enrollees")
public class Enrollee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3178650140189938450L;

	@Id
    @GeneratedValue
    private Long id;
 
    @Column(nullable = false, length = 100)
    private String name;
 
    @Column(name = "activation_status", nullable = false)
    private Boolean activationStatus;
    
    @Column(name = "dob",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    
    @Column(name = "phone_number")
    private String phoneNumber;
	
    @OneToMany(mappedBy = "enrollee", cascade = CascadeType.ALL)
    private List<Dependent> enrolleeDependents = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getActivationStatus() {
		return activationStatus;
	}

	public void setActivationStatus(Boolean activationStatus) {
		this.activationStatus = activationStatus;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Dependent> getEnrolleeDependents() {
		return enrolleeDependents;
	}

	public void setEnrolleeDependents(List<Dependent> enrolleeDependents) {
		this.enrolleeDependents = enrolleeDependents;
	}
 
   
}
