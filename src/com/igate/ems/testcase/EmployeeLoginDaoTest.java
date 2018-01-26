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
public class EmployeeLoginDaoTest {

	@Autowired
	IEmployeeMaintenanceDao dao;

	@Test
	public void adminLoginEmployeeTest() {
		System.out.println("When Test Passes for Admin");
		try {
			String userType=dao.userLogin("Admin","password");
			if(userType.equals("Admin")){
				assertTrue(true);
			}
		} catch (InvalidEmployeeDetails e) {
			fail("Exception occured");
		}
	}
	
	@Test
	public void userLoginEmployeeTest() {
		System.out.println("When Test Passes for User");
		try {
			String userType=dao.userLogin("Yash","yash");
			if(userType.equals("User")){
				assertTrue(true);
			}
		} catch (InvalidEmployeeDetails e) {
			fail("Exception occured");
		}
	}
	
	@Test
	@Ignore
	public void loginEmployeeFailTest() {
		System.out.println("When Test Fail");
		
		try {
			String userType=dao.userLogin("Admin","pass1234");
			if(userType.equals("User")){
				assertTrue(true);
			}else{
				assertTrue(false);
			}
		} catch (InvalidEmployeeDetails e) {
			fail("Exception occured");
		}
	}

}
