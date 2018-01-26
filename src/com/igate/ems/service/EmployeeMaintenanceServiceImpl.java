package com.igate.ems.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igate.ems.dao.IEmployeeMaintenanceDao;
import com.igate.ems.dto.Department;
import com.igate.ems.dto.Employee;
import com.igate.ems.dto.Grade;
import com.igate.ems.exception.InvalidEmployeeDetails;

@Service("service")
public class EmployeeMaintenanceServiceImpl implements
		IEmployeeMaintenanceService {

	@Autowired
	IEmployeeMaintenanceDao dao;

	@Override
	public String userLogin(String userName, String password)
			throws InvalidEmployeeDetails {

		return dao.userLogin(userName, password);
	}

	@Override
	public ArrayList<Department> getDepartments() throws InvalidEmployeeDetails {
		return dao.getDepartments();
	}

	@Override
	public List<Employee> viewAllEmployee() throws InvalidEmployeeDetails {
		// TODO Auto-generated method stub
		return dao.viewAllEmployee();
	}

	@Override
	public int insertEmployee(Employee emp) throws InvalidEmployeeDetails {
		// TODO Auto-generated method stub
		return dao.insertEmployee(emp);
	}

	@Override
	public String getEmpId() throws InvalidEmployeeDetails {
		// TODO Auto-generated method stub
		return dao.getEmpId();
	}

	@Override
	public Grade calGrade(String empSal) throws InvalidEmployeeDetails {
		// TODO Auto-generated method stub
		return dao.calGrade(empSal);
	}

	@Override
	public ArrayList<Grade> getGrades() throws InvalidEmployeeDetails {
		return dao.getGrades();
	}

	@Override
	public ArrayList<Employee> searchEmployee(Employee emp)
			throws InvalidEmployeeDetails {
		return dao.searchEmployee(emp);
	}

	@Override
	public ArrayList<String> getEmpIds() throws InvalidEmployeeDetails {
		return dao.getEmpIds();
	}

	@Override
	public Employee searchByIdEmployee(String empId)
			throws InvalidEmployeeDetails {
		return dao.searchByIdEmployee(empId);
	}

	@Override
	public int updateEmployee(Employee emp) throws InvalidEmployeeDetails {
		return dao.updateEmployee(emp);
	}

	
	
}
