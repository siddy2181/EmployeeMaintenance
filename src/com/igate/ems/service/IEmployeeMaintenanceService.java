package com.igate.ems.service;

import java.util.ArrayList;
import java.util.List;

import com.igate.ems.dto.Department;
import com.igate.ems.dto.Employee;
import com.igate.ems.dto.Grade;
import com.igate.ems.exception.InvalidEmployeeDetails;

public interface IEmployeeMaintenanceService {

	public String userLogin(String userName, String password)
			throws InvalidEmployeeDetails;

	public ArrayList<Department> getDepartments() throws InvalidEmployeeDetails;

	// Method to view all Employees

	public List<Employee> viewAllEmployee() throws InvalidEmployeeDetails;

	// Method to insert values into database
	public int insertEmployee(Employee emp) throws InvalidEmployeeDetails;

	public String getEmpId() throws InvalidEmployeeDetails;

	public Grade calGrade(String empSal) throws InvalidEmployeeDetails;

	public ArrayList<Grade> getGrades() throws InvalidEmployeeDetails;

	public ArrayList<Employee> searchEmployee(Employee emp)
			throws InvalidEmployeeDetails;

	// Method to get empid
	public ArrayList<String> getEmpIds() throws InvalidEmployeeDetails;

	public Employee searchByIdEmployee(String empId)
			throws InvalidEmployeeDetails;

	public int updateEmployee(Employee emp) throws InvalidEmployeeDetails;
	
		

}
