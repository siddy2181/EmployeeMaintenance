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
import com.igate.ems.exception.InvalidEmployeeDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("testDao.xml")
public class EmployeeViewDaoTest {

	@Autowired
	IEmployeeMaintenanceDao dao;

	@Test
	public void viewAllEmployeeTest() {
		System.out.println("When Test Passes");
		try {
			Assert.assertNotNull(dao.viewAllEmployee());
		} catch (InvalidEmployeeDetails e) {
			fail("Exception occured");
		}
	}
	
	@Test
	@Ignore
	public void viewAllEmployeeFailTest() {
		System.out.println("When Test Fail");
		try {
			List<Employee> getAllEmployee=dao.viewAllEmployee();
			if(getAllEmployee==null){
				assertTrue(false);;
			}
		} catch (InvalidEmployeeDetails e) {
			fail("Exception occured");
		}
	}

}
