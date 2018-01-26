package com.igate.ems.dto;

import java.time.LocalDate;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Employee {
	
	/************************************
	POJO for getting Employee Details 
	************************************/
	
	private String empId;

	@Pattern(regexp = "^[a-zA-Z]{3,19}$", message = "Enter only characters")
	private String firstName;

	@Pattern(regexp = "^[a-zA-Z]{3,19}$", message = "Enter only characters")
	private String lastName;
	private String dateOfBirth;
	private String dateOfJoining;
	private String deptId;
	private String grade;
	private String designation;
	private String basic;
	private String gender;
	private String maritalStatus;

	//SPRING VALIDATION FOR ADDRESS
	@Pattern(regexp = "[0-9A-Za-z /,/-]{0,10}[a-zA-Z ,]+", message = "Match with the given format")
	private String address;

	//SPRING VALIDATION FOR CONTACT NUMBER
	@Pattern(regexp = "[7-9][0-9]{9}", message = "Match with the given format")
	private String contactNum;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getBasic() {
		return basic;
	}

	public void setBasic(String basic) {
		this.basic = basic;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	//CONVERTING THE OBJECT TO STRING
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ ", dateOfJoining=" + dateOfJoining + ", deptId=" + deptId
				+ ", grade=" + grade + ", designation=" + designation
				+ ", basic=" + basic + ", gender=" + gender
				+ ", maritalStatus=" + maritalStatus + ", address=" + address
				+ ", contactNum=" + contactNum + "]";
	}

}
