package com.igate.ems.dao;

import java.util.ArrayList;
import java.util.List;

import com.igate.ems.dto.Department;
import com.igate.ems.dto.Employee;
import com.igate.ems.dto.Grade;
import com.igate.ems.exception.InvalidEmployeeDetails;

public interface IEmployeeMaintenanceDao {

	public String userLogin(String userName, String password)
			throws InvalidEmployeeDetails;

	// Method to find department
	public ArrayList<Department> getDepartments() throws InvalidEmployeeDetails;

	// Method to view all Employees

	public List<Employee> viewAllEmployee() throws InvalidEmployeeDetails;

	// Method to insert values into database
	public int insertEmployee(Employee emp) throws InvalidEmployeeDetails;
	
	
	// Method to fetch employee id
	public String getEmpId() throws InvalidEmployeeDetails;
	
	
	//method  to calculate grade from salary
	public Grade calGrade(String empSal) throws InvalidEmployeeDetails;
	
	
	//Method to get Grades for search
	public ArrayList<Grade> getGrades() throws InvalidEmployeeDetails;
	
	
	//Method to search employees from any given parameter
	public ArrayList<Employee> searchEmployee(Employee emp)
			throws InvalidEmployeeDetails;

	// Method to get empid
	public ArrayList<String> getEmpIds() throws InvalidEmployeeDetails;

	
	//Method to search employee by emp Id
	public Employee searchByIdEmployee(String empId)
			throws InvalidEmployeeDetails;
	
	//Method to update Employee Details
	public int updateEmployee(Employee emp) throws InvalidEmployeeDetails;
}
