package com.igate.ems.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Pagination;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.igate.ems.dto.Department;
import com.igate.ems.dto.Employee;
import com.igate.ems.dto.Grade;
import com.igate.ems.dto.User;
import com.igate.ems.exception.InvalidEmployeeDetails;
import com.igate.ems.rowmapper.DepartmentRowMapper;
import com.igate.ems.rowmapper.EmployeeRowMapper;
import com.igate.ems.rowmapper.GradeRowMapper;
import com.igate.ems.rowmapper.IdRowMapper;
import com.igate.ems.rowmapper.UserRowMapper;

@Repository("dao")
public class EmployeeMaintenanceDaoImpl extends JdbcDaoSupport implements
		IEmployeeMaintenanceDao {

	// <-- Gets the dataSource and set it to get connection -->
	@Autowired
	private DataSource dataSource;

	@PostConstruct
	public void initalize() {
		setDataSource(dataSource);
	}

	public static Logger emsLogger = Logger.getLogger(EmployeeMaintenanceDaoImpl.class);
	
	
	/*********************************************************************
	* Module Name : userLogin()
	* Input Parameters : userName, password
	* Return Type : STRING
	* Author : GROUP-5
	* Creation Date : 09‐Jan‐2016
	* Modified Date : 09-Jan-2016
	* Description : Authenticating and Login user
	*********************************************************************/
	
	@Override
	public String userLogin(String userName, String password)
			throws InvalidEmployeeDetails {

		List<User> user;
		try {
			Object params[] = { userName, password };
			user = getJdbcTemplate().query(QuerryMapper.loginQuery, params,
					new UserRowMapper());
			if (!user.isEmpty()) {
				emsLogger.info("User of type "+user+"Logged in..!!");
				return user.get(0).getUserType();
			} else {
				return null;
			}

		} catch (DataAccessException e) {
			emsLogger.error("Error in Dao userLogin()");
			throw new InvalidEmployeeDetails("Error in Dao userLogin()"
					+ e.getMessage());
		}

	}

	/*********************************************************************
	* Module Name : getDepartments()
	* Input Parameters : Null
	* Return Type : ArrayList<>
	* Author : GROUP-5
	* Creation Date : 09‐Jan‐2016
	* Modified Date : 09-Jan-2016
	* Description : Getting all departments using deptId
	*********************************************************************/
	@Override
	public ArrayList<Department> getDepartments() throws InvalidEmployeeDetails {
		ArrayList<Department> departments = new ArrayList<Department>();
		try {
			departments = (ArrayList<Department>) getJdbcTemplate().query(
					QuerryMapper.deptQry, new DepartmentRowMapper());

		} catch (DataAccessException e) {
			emsLogger.error("Error in Dao getDepartments()");
			throw new InvalidEmployeeDetails("Error in Dao getDepartments()");
		}

		return departments;
	}

	/*********************************************************************
	* Module Name : viewAllEmployee()
	* Input Parameters : Null
	* Return Type : List<>
	* Author : GROUP-5
	* Creation Date : 09‐Jan‐2016
	* Modified Date : 16-Jan-2016
	* Description : View all the employee details
	*********************************************************************/
	
	@Override
	public List<Employee> viewAllEmployee() throws InvalidEmployeeDetails {

		List<Employee> getAllEmployee = null;
		try {
			getAllEmployee = getJdbcTemplate().query(QuerryMapper.viewSql,
					new EmployeeRowMapper());
			emsLogger.info("ViewAllEmployee method called for viewing all Employees");

		} catch (DataAccessException e) {
			emsLogger.error("Error in Dao viewAllEmployee()");
			throw new InvalidEmployeeDetails("Error in Dao viewAllEmployee()");
		}

		return getAllEmployee;

	}

	/*********************************************************************
	* Module Name : insertEmployee()
	* Input Parameters : Employee object
	* Return Type : INTEGER
	* Author : GROUP-5
	* Creation Date : 09‐Jan‐2016
	* Modified Date : 13-Jan-2016
	* Description : Inserts an employee's details to database
	*********************************************************************/
	
	@Override
	public int insertEmployee(Employee emp) throws InvalidEmployeeDetails {

		int insertedResult = 0;

		String dob = emp.getDateOfBirth();
		String doj = emp.getDateOfJoining();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Date dateOfBirth = Date.valueOf(LocalDate.parse(dob, formatter));

		Date dateOfJoining = Date.valueOf(LocalDate.parse(doj, formatter));
		int deptId = Integer.parseInt(emp.getDeptId());
		long basic = Long.parseLong(emp.getBasic());

		Object params[] = { emp.getEmpId(), emp.getFirstName().toUpperCase(),
				emp.getLastName().toUpperCase(), dateOfBirth, dateOfJoining,
				deptId, emp.getGrade(), emp.getDesignation(), basic,
				emp.getGender(), emp.getMaritalStatus(), emp.getAddress(),
				emp.getContactNum() };
		try {
			insertedResult = getJdbcTemplate().update(
					QuerryMapper.insertRecord, params);
			emsLogger.info("New Employee Details are entered into the system");


		} catch (DataAccessException e) {
			emsLogger.error("Error in Dao insertEmployee()");
			throw new InvalidEmployeeDetails("Error in Dao insertEmployee()");
		}

		return insertedResult;
	}
	
	
	/*********************************************************************
	* Module Name : getEmpId()
	* Input Parameters : Null
	* Return Type : String
	* Author : GROUP-5
	* Creation Date : 09‐Jan‐2016
	* Modified Date : 16-Jan-2016
	* Description : Getting employee Id for Search
	*********************************************************************/

	@Override
	public String getEmpId() throws InvalidEmployeeDetails {
		String empId = null;
		try {
			empId = getJdbcTemplate().queryForObject(QuerryMapper.seqEmp,
					new IdRowMapper());
			emsLogger.info("New empployeeId generated"+empId);
		} catch (DataAccessException e) {
			emsLogger.error("Error in Dao getEmpId()");
			throw new InvalidEmployeeDetails("Error in Dao getEmpId()");
		}

		return empId;
	}
	
	
	/*********************************************************************
	* Module Name : getDepartments()
	* Input Parameters : Employee salary
	* Return Type : Grade object
	* Author : GROUP-5
	* Creation Date : 09‐Jan‐2016
	* Modified Date : 16-Jan-2016
	* Description : Calculates grade according to the salary range
	*********************************************************************/

	@Override
	public Grade calGrade(String empSal) throws InvalidEmployeeDetails {

		Grade grade = null;

		Object params[] = { empSal };

		try {
			grade = getJdbcTemplate().queryForObject(QuerryMapper.gradeQry,
					params, new GradeRowMapper());
			emsLogger.info("Grade is calculated "+grade);
		} catch (DataAccessException e) {
			emsLogger.error("Error in Dao calGrade()");
			throw new InvalidEmployeeDetails("Error in Dao calGrade()");
		}

		return grade;
	}
	
	/*********************************************************************
	* Module Name : getGrades()
	* Input Parameters : Null
	* Return Type : ArrayList<>
	* Author : GROUP-5
	* Creation Date : 09‐Jan‐2016
	* Modified Date : 16-Jan-2016
	* Description : Getting grade for searching employee
	*********************************************************************/
	

	@Override
	public ArrayList<Grade> getGrades() throws InvalidEmployeeDetails {
		ArrayList<Grade> grades = null;
		try {
			grades = (ArrayList<Grade>) getJdbcTemplate().query(
					QuerryMapper.getAllGrade, new GradeRowMapper());
			
		} catch (DataAccessException e) {
			emsLogger.error("Error in Dao getGrades()");
			throw new InvalidEmployeeDetails("Error in Dao getGrades()");
		}

		return grades;
	}

	/*********************************************************************
	* Module Name : searchEmployee()
	* Input Parameters : Employee object
	* Return Type : ArrayList<>
	* Author : GROUP-5
	* Creation Date : 09‐Jan‐2016
	* Modified Date : 15-Jan-2016
	* Description : Searches Employees by any detail mentioned
	*********************************************************************/
	
	@Override
	public ArrayList<Employee> searchEmployee(Employee emp)
			throws InvalidEmployeeDetails {

		ArrayList<Employee> emps = null;

		Object params[] = { emp.getEmpId(), emp.getFirstName().toUpperCase(),
				emp.getLastName().toUpperCase(), emp.getDeptId(),
				emp.getGrade(), emp.getMaritalStatus() };

		try {
			emps = (ArrayList<Employee>) getJdbcTemplate().query(
					QuerryMapper.searchEmpQry, params, new EmployeeRowMapper());
			emsLogger.info("Employee details searched");
		} catch (DataAccessException e) {
			emsLogger.error("Error in Dao searcEmployee()");
			throw new InvalidEmployeeDetails("Error in Dao searcEmployee()");
		}

		return emps;
	}

	/*********************************************************************
	* Module Name : getEmpIds()
	* Input Parameters : Null
	* Return Type : ArrayList<>
	* Author : GROUP-5
	* Creation Date : 09‐Jan‐2016
	* Modified Date : 09-Jan-2016
	* Description : Getting Employee Ids for search
	*********************************************************************/
	
	@Override
	public ArrayList<String> getEmpIds() throws InvalidEmployeeDetails {

		ArrayList<String> empIds = null;
		try {
			empIds = (ArrayList<String>) getJdbcTemplate().query(
					QuerryMapper.allEmpIdQry, new IdRowMapper());
		} catch (DataAccessException e) {
			emsLogger.error("Error in Dao getEmpIds()");
			throw new InvalidEmployeeDetails("Error in Dao getEmpIds()");
		}
		return empIds;
	}
	
	/*********************************************************************
	* Module Name : searchByIdEmployee()
	* Input Parameters : Employee Id
	* Return Type : Employee
	* Author : GROUP-5
	* Creation Date : 09‐Jan‐2016
	* Modified Date : 15-Jan-2016
	* Description : Searching Employee by id
	*********************************************************************/

	@Override
	public Employee searchByIdEmployee(String empId)
			throws InvalidEmployeeDetails {

		Employee emp = null;

		Object params[] = { empId };

		try {
			emp = getJdbcTemplate().queryForObject(QuerryMapper.searchByIdQuery,
					params, new EmployeeRowMapper());
		} catch (DataAccessException e) {
			emsLogger.error("Error in Dao searchByIdEmployee()");
			throw new InvalidEmployeeDetails(
					"Error in Dao searchByIdEmployee()");
		}

		return emp;
	}
	
	/*********************************************************************
	* Module Name : updateEmployee()
	* Input Parameters : Employee object
	* Return Type : INTEGER
	* Author : GROUP-5
	* Creation Date : 09‐Jan‐2016
	* Modified Date : 17-Jan-2016
	* Description : Update  Employee details
	*********************************************************************/

	@Override
	public int updateEmployee(Employee emp) throws InvalidEmployeeDetails {

		int rowCount = 0;

		Object params[] = { emp.getLastName().toUpperCase(), emp.getDeptId(),
				emp.getGrade(), emp.getDesignation(), emp.getBasic(),
				emp.getMaritalStatus(), emp.getAddress(), emp.getContactNum(),
				emp.getEmpId() };
		try {
			rowCount = getJdbcTemplate().update(QuerryMapper.updateQuery,
					params);
			emsLogger.info("Employee updation process");
		} catch (DataAccessException e) {
			emsLogger.error("Error in Dao updateEmployee()");
			throw new InvalidEmployeeDetails("Error in Dao updateEmployee()");
		}

		return rowCount;
	}

	

}
