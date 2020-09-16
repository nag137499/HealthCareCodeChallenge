package com.healthcare.codingchallenge.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 137499
 *
 */
@Entity
@Table(name = "dependents")
public class Dependent implements Serializable {

	 /**
	 * 
	 */
	private static final long serialVersionUID = -3761660582845515625L;

	@Id
	    @GeneratedValue
	    private Long id;
	 
	    @Column(name = "name", nullable = false)
	    private String dependentName;
	 
	    @Column(name = "dob",nullable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date dob;
	 
	    @ManyToOne
	    @JoinColumn(name ="enrollee_id", nullable = false)
	    private Enrollee enrollee;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDependentName() {
			return dependentName;
		}

		public void setDependentName(String dependentName) {
			this.dependentName = dependentName;
		}

		public Date getDob() {
			return dob;
		}

		public void setDob(Date dob) {
			this.dob = dob;
		}

		public Enrollee getEnrollee() {
			return enrollee;
		}

		public void setEnrollee(Enrollee enrollee) {
			this.enrollee = enrollee;
		}
	    
}
