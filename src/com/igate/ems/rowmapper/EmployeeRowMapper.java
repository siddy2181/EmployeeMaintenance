package com.igate.ems.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.ems.dto.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Employee empObj = new Employee();
		
		empObj.setEmpId(resultSet.getString("Emp_Id"));
		empObj.setFirstName(resultSet.getString("Emp_First_Name"));
		empObj.setLastName(resultSet.getString("Emp_Last_Name"));
		empObj.setDateOfBirth(String.valueOf(resultSet.getDate("Emp_Date_of_Birth")));
		empObj.setDateOfJoining(String.valueOf(resultSet.getDate("Emp_Date_of_Joining")));
		empObj.setDeptId(String.valueOf(resultSet.getInt("Emp_Dept_Id")));
		empObj.setGrade(resultSet.getString("Emp_Grade"));
		empObj.setDesignation(resultSet.getString("Emp_Designation"));
		empObj.setBasic(String.valueOf(resultSet.getLong("Emp_Basic")));
		empObj.setGender(resultSet.getString("Emp_Gender"));
		empObj.setMaritalStatus(resultSet.getString("Emp_Marital_Status"));
		empObj.setAddress(resultSet.getString("Emp_home_Address"));
		empObj.setContactNum(resultSet.getString("Emp_Contact_Num"));		
		
		return empObj;
	}

}
