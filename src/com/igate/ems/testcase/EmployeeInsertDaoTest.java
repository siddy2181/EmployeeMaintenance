package com.igate.ems.testcase;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.igate.ems.dao.IEmployeeMaintenanceDao;
import com.igate.ems.dto.Employee;
import com.igate.ems.dto.Grade;
import com.igate.ems.exception.InvalidEmployeeDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("testDao.xml")
public class EmployeeInsertDaoTest {

	@Autowired
	IEmployeeMaintenanceDao dao;

	@Test
	public void insertEmployeeTest() {
		System.out.println("When Test Passes");
		try {
			Employee emp = new Employee();
			// function call to get employee id
			String empId = dao.getEmpId();
			emp.setEmpId(empId);
			emp.setFirstName("Nikhita");
			emp.setLastName("Upreti");
			emp.setDateOfBirth("1993-05-08");
			emp.setDateOfJoining("2015-10-29");
			emp.setDeptId("10");
			emp.setBasic("25000");
			// function to set grade based on salary
			Grade grade = dao.calGrade(emp.getBasic());
			emp.setGrade(grade.getGradeCode());
			emp.setDesignation("Programmer");
			emp.setGender("F");
			emp.setMaritalStatus("U");
			emp.setAddress("Hinjewadi, Pune");
			emp.setContactNum("9811799204");

			Assert.assertNotNull(dao.insertEmployee(emp));
		} catch (InvalidEmployeeDetails e) {
			fail("Exception occured");
		}
	}

	@Test
	@Ignore
	public void insertEmployeeFailTest() {
		System.out.println("When Test Fails");
		try {
			Employee emp = new Employee();
			// function call to get employee id
			String empId = dao.getEmpId();
			emp.setEmpId(empId);
			emp.setFirstName("Nikhita");
			emp.setLastName("Upreti");
			emp.setDateOfBirth("1993-05-08");
			emp.setDateOfJoining("2015-10-29");
			emp.setDeptId("10");
			emp.setBasic("25000");
			// function to set grade based on salary
			Grade grade = dao.calGrade(emp.getBasic());
			emp.setGrade(grade.getGradeCode());
			emp.setDesignation("Programmer");
			emp.setGender("FA");
			emp.setMaritalStatus("UNM");
			emp.setAddress("Hinjewadi, Pune");
			emp.setContactNum("9811799204");

			Assert.assertNotNull(dao.insertEmployee(emp));
		} catch (InvalidEmployeeDetails e) {
			fail("Exception occured");
		}
	}

}
