package com.igate.ems.testcase;

import static org.junit.Assert.*;
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
public class EmployeeUpdateDaoTest {

	@Autowired
	IEmployeeMaintenanceDao dao;

	@Test
	public void updateEmployeeTest() {
		System.out.println("When Test Passes");
		try {
			// getting the employee to be updated
			Employee emp = dao.searchByIdEmployee("100001");
			
			emp.setLastName("Verma");
			emp.setAddress("Phase 3, Pune");
			
			int result=dao.updateEmployee(emp);
			if(result>0){
				assertTrue(true);
			}else{
				assertTrue(false);
			}

		} catch (InvalidEmployeeDetails e) {
			e.printStackTrace();
			fail("Exception occured");
		}
	}
	
	@Test
	//@Ignore
	public void updateEmployeeFailTest() {
		System.out.println("When Test Fail");
		try {
			// getting the employee to be updated
			Employee emp = dao.searchByIdEmployee("1001");
			
			emp.setLastName("Verma");
			emp.setAddress("Phase 3, Pune");
			
			int result=dao.updateEmployee(emp);
			if(result>0){
				assertTrue(true);
			}else{
				assertTrue(false);
			}

		} catch (InvalidEmployeeDetails e) {
			e.printStackTrace();
			fail("Exception occured");
		}
	}


}
