package com.demo.springmvc.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


public class User implements Serializable {

	@Size(min=3, max=30) 
	private String firstName;

	@Size(min=3, max=30) 
	private String lastName;

	@NotEmpty
	private String sex;
	
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	@Past @NotNull
	private Date dob;
	
	@Email @NotEmpty
	private String email;
	
//	@NotEmpty
//	private String section;
//	
//	@NotEmpty
//	private String country;
//	
//	private boolean firstAttempt;
//	
//	@NotEmpty
//	private List<String> subjects = new ArrayList<String>();

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", sex=" + sex + ", dob=" + dob
				+ ", email=" + email + "]";
	}


	
	

}

