package com.igate.ems.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.igate.ems.dto.Department;
import com.igate.ems.dto.Employee;
import com.igate.ems.dto.Grade;
import com.igate.ems.dto.User;
import com.igate.ems.exception.InvalidEmployeeDetails;
import com.igate.ems.service.IEmployeeMaintenanceService;

@Controller
@SessionAttributes(value = { "userName", "userType" })
public class EmployeeController {

	@Autowired
	IEmployeeMaintenanceService service;

	static Logger emsLogger = Logger.getLogger(EmployeeController.class);

	/**********************************************
	 * Globally Declaring checklist variables
	 ***********************************************/

	ArrayList<String> designation = new ArrayList<String>();
	ArrayList<String> maritalStatus = new ArrayList<String>();
	ArrayList<Department> departments = new ArrayList<Department>();
	ArrayList<Grade> grades = new ArrayList<Grade>();

	int size;
	List<Employee> getAllEmployee = null;

	String errorMsg = "";

	//@formatter:off
    /*******************************************************************************************
   	*ACTION : showHome																		   *
	*FROM   : index.jsp																		   *
	*TO     : homeEMS ; AdminHome ;EmployeeHome  											   *
	*DESCR  : Gets Login Page                                                                  *
	*******************************************************************************************/
	//@formatter:on 

	@RequestMapping(value = "showHome", method = RequestMethod.GET)
	public String showHome(Model model, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String userType = (String) session.getAttribute("userType");

		if (userType != null) {
			if (userType.equals("Admin")) {
				return "AdminHome";
			}
			if (userType.equals("Employee")) {
				return "EmployeeHome";
			}
		}
		model.addAttribute("user", new User());
		emsLogger.info("User Visited Home Page");
		return "homeEMS";
	}

	//@formatter:off
	/*******************************************************************************************
	*ACTION : aboutUs																		   *
	*FROM   : 																		           *
	*TO     : AboutUs  											                               *
	*DESCR  : displays the about us slider 												       *
	*******************************************************************************************/
	//@formatter:on 

	@RequestMapping(value = "aboutUs")
	public String aboutUs(Model model) {
		emsLogger.info("User Visited AboutUs Page");
		return "AboutUs";
	}

	//@formatter:off
	/*******************************************************************************************
	*ACTION : Gallery																		   *
	*FROM   : 																		           *
	*TO     : Gallery  											                               *
	*DESCR  : displays the Employee Picture Gallery slider 								       *
	*******************************************************************************************/
	//@formatter:on 

	@RequestMapping(value = "Gallery")
	public String Gallery(Model model) {
		emsLogger.info("User Visited Gallery Page");
		return "Gallery";
	}

	/*
	 * @RequestMapping(value = "showLogin", method = RequestMethod.GET) public
	 * String showLogin(Model model) { model.addAttribute("user", new User());
	 * return "homeEMS.jsp#modal-login"; }
	 */

	//@formatter:off
	/*******************************************************************************************
	*ACTION : logout																		   *
	*FROM   : 																		           *
	*TO     : homeEMS  											                               *
	*DESCR  : Logic for logging out  								                           *
	*******************************************************************************************/
	//@formatter:on 

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String loogout(Model model) {
		model.addAttribute("userName", "");
		model.addAttribute("userType", "");
		model.addAttribute("user", new User());
		emsLogger.info("User Logged Off");
		return "homeEMS";
	}

	//@formatter:off
	/**************************************************************************************************
	*ACTION : validateLogin																    		  *
	*FROM   : 																		                  *
	*TO     : errorPage ; homeEMS ; AdminHome ; EmployeeHome.	                                      *
	*DESCR  : Check and Validate Logging User if Admin or Employee and redirects to respective page.  *
	**************************************************************************************************/
	//@formatter:on 

	@RequestMapping(value = "validateLogin", method = RequestMethod.POST)
	public String validateLogin(@ModelAttribute("user") User user, Model model) {
		/*
		 * if (user.getUserName().equals("") || user.getUserName() == null) {
		 * errorMsg = "Invalid UserName or Password";
		 * model.addAttribute("errorMsg", errorMsg); return "homeEMS"; }
		 */
		try {
			String userType = service.userLogin(user.getUserName(),
					user.getPassword());

			if (userType != null) {

				departments.removeAll(departments);
				Department dept = new Department();
				dept.setDeptId(0);
				dept.setDeptName("--");
				departments.add(dept);
				try {
					departments.addAll(service.getDepartments());
				} catch (InvalidEmployeeDetails e) {
					model.addAttribute("errorMsg", e.getMessage());
					return "errorPage";
				}

				designation.removeAll(designation);
				designation.add("MANAGER");
				designation.add("PROGRAMMER");
				designation.add("TRAINEE");
				designation.add("TECHIE");

				maritalStatus.removeAll(maritalStatus);
				maritalStatus.add("");
				maritalStatus.add("Married");
				maritalStatus.add("Unmarried");
				maritalStatus.add("Widowed");
				maritalStatus.add("Seperated");
				maritalStatus.add("Divorced");

				grades.removeAll(grades);
				Grade grade = new Grade();
				grade.setGradeCode("");
				grade.setDescription("--");
				grades.add(grade);
				try {
					grades.addAll(service.getGrades());
				} catch (InvalidEmployeeDetails e) {
					model.addAttribute("errorMsg", e.getMessage());
					return "errorPage";
				}

				if (userType.equals("Admin")) {

					model.addAttribute("userName", user.getUserName());
					model.addAttribute("userType", userType);
					emsLogger.info("User entered AdminHome Page");
					return "AdminHome";
				} else if (userType.equals("Employee")) {
					model.addAttribute("userName", user.getUserName());
					model.addAttribute("userType", userType);
					emsLogger.info("User entered EmployeeHome Page");
					return "EmployeeHome";
				}
			} else {
				errorMsg = "Invalid UserName or Password";
				model.addAttribute("errorMsg", errorMsg);
				emsLogger
						.info("User entered Invalid Details and was redirected to HomePage");
				return "homeEMS";
			}

		} catch (InvalidEmployeeDetails e) {
			model.addAttribute("errorMsg", e.getMessage());
			return "errorPage";
		}
		return null;
	}

	//@formatter:off
	/**************************************************************************************************
	*ACTION :  redirectAdminHome															    	  *
	*FROM   : 																		                  *
	*TO     :  AdminHome.	                                      									  *
	*DESCR  :  redirects to admin home page.   														  *
	**************************************************************************************************/
	//@formatter:on 

	@RequestMapping(value = "redirectAdminHome", method = RequestMethod.GET)
	public String redirectAdminHome() {
		emsLogger.info("User redirected AdminHome Page");
		return "AdminHome";
	}

	//@formatter:off
	/**************************************************************************************************
	*ACTION : redirectEmployeeHome																      *
	*FROM   : 																		                  *
	*TO     : EmployeeHome.	                                      									  *
	*DESCR  : redirects to Employee Home page. 														  *
	**************************************************************************************************/
	//@formatter:on 

	@RequestMapping(value = "redirectEmployeeHome", method = RequestMethod.GET)
	public String redirectEmployeeHome() {
		emsLogger.info("User redirected to EmployeeHome Page");
		return "EmployeeHome";
	}

	//@formatter:off
	/**************************************************************************************************
	*ACTION : showAddEmployee															    		  *
	*FROM   : 																		                  *
	*TO     : AddEmployee.	                          									              *
	*DESCR  : Displays Add Employee page and Adds an employee										  *
	**************************************************************************************************/
	//@formatter:on 

	@RequestMapping(value = "showAddEmployee", method = RequestMethod.GET)
	public String showAddEmployee(Model model) {

		model.addAttribute("departments", departments);
		model.addAttribute("designation", designation);
		model.addAttribute("maritalStatus", maritalStatus);
		model.addAttribute("empAdd", new Employee());
		emsLogger.info("User visited AddEmployee Page");
		return "AddEmployee";
	}

	//@formatter:off
	/**************************************************************************************************
	*ACTION : showViewAll																    		  *
	*FROM   : 																		                  *
	*TO     : errorPage ; ShowAllEmployees.	                                     					  *
	*DESCR  : Displays 5 employees per page fetching from database                                    *
	**************************************************************************************************/
	//@formatter:on 

	@RequestMapping(value = "showViewAll", method = RequestMethod.GET)
	public String viewAllEmployee(@RequestParam("page") int pageNo, Model model) {

		/**********************************************
		 * Logic For Pagination
		 ***********************************************/

		List<Employee> empSub = null;

		try {
			if (pageNo == 0) {
				getAllEmployee = service.viewAllEmployee();
				size = getAllEmployee.size();
			}

			int start = 5 * pageNo;

			if (size - start < 5) {
				empSub = getAllEmployee.subList(start, size);
			} else {
				empSub = getAllEmployee.subList(start, start + 5);
			}

		} catch (InvalidEmployeeDetails | DataAccessException e) {
			model.addAttribute("errorMsg", e.getMessage());
			return "errorPage";
		}

		model.addAttribute("size", size);
		model.addAttribute("curPage", pageNo);
		model.addAttribute("nextPage", pageNo + 1);
		model.addAttribute("prePage", pageNo - 1);
		if (size % 10 == 0) {
			model.addAttribute("lastPage", (size / 5) - 1);
		} else {
			model.addAttribute("lastPage", size / 5);
		}
		model.addAttribute("EmployeeList", empSub);
		emsLogger.info("User Viewed ShowAllEmployee Page");
		return "ShowAllEmployees";

	}

	//@formatter:off
	/**************************************************************************************************
	*ACTION : addEmployee																    		  *
	*FROM   : 																		                  *
	*TO     : errorPage ; AddEmployee ; InsertedPage .	                             		          *
	*DESCR  : Adds an  Employee and redirects to Inserted page which shows the details added          *
	**************************************************************************************************/
	//@formatter:on 

	@RequestMapping(value = "addEmployee", method = RequestMethod.POST)
	public String addEmployee(@Valid @ModelAttribute("empAdd") Employee emp,
			BindingResult bindResult, @RequestParam("doj") String doj,
			@RequestParam("dob") String dob, Model model) {
		int insertedDetails;

		if (bindResult.hasErrors()) {

			model.addAttribute("departments", departments);
			model.addAttribute("designation", designation);
			model.addAttribute("maritalStatus", maritalStatus);

			return "AddEmployee";

		} else {
			try {

				String empId = service.getEmpId();

				emp.setEmpId(empId);

				Grade grade = service.calGrade(emp.getBasic());

				emp.setGrade(grade.getGradeCode());
				emp.setDateOfBirth(dob);
				emp.setDateOfJoining(doj);

				insertedDetails = service.insertEmployee(emp);

			} catch (InvalidEmployeeDetails e) {
				model.addAttribute("errorMsg", e.getMessage());
				return "errorPage";
			}
			model.addAttribute("inserted", emp);
			emsLogger
					.info("User added new Employee and was redirected to Inserted Page where new Employee Id and details were displayed");
			return "InsertedPage";
		}

	}

	//@formatter:off
	/**************************************************************************************************
	*ACTION : showSearchEmployee																      *
	*FROM   : 																		                  *
	*TO     : SearchEmployee	                                     								  *
	*DESCR  : Redirects to Search Employee page 													  *
	**************************************************************************************************/
	//@formatter:on 

	@RequestMapping(value = "showSearchEmployee", method = RequestMethod.GET)
	public String showSearchEmployee(Model model) {

		model.addAttribute("departments", departments);
		model.addAttribute("maritalStatus", maritalStatus);
		model.addAttribute("grades", grades);
		model.addAttribute("empSearch", new Employee());
		emsLogger.info("User visited Search Employee Page");
		return "SearchEmployee";
	}

	//@formatter:off
	/**************************************************************************************************
	*ACTION : searchEmployee												     		    		  *
	*FROM   : 																		                  *
	*TO     : errorPage ; SearchEmployee.	                                                          *
	*DESCR  : Searches an Employee using several wildcard entries                                     *
	**************************************************************************************************/
	//@formatter:on 

	@RequestMapping(value = "searchEmployee", method = RequestMethod.POST)
	public String searchEmployee(@ModelAttribute("empSearch") Employee emp,
			Model model) {

		/******************************************************
		 *
		 * Logic to check if there are no entries for searching
		 *
		 ********************************************************/

		if (emp.getEmpId().equalsIgnoreCase("")
				&& emp.getFirstName().equalsIgnoreCase("")
				&& emp.getLastName().equalsIgnoreCase("")
				&& Integer.parseInt(emp.getDeptId()) == 0
				&& emp.getGrade().equalsIgnoreCase("")
				&& emp.getMaritalStatus().equalsIgnoreCase("")) {
			model.addAttribute("departments", departments);
			model.addAttribute("maritalStatus", maritalStatus);
			model.addAttribute("grades", grades);
			model.addAttribute("empSearch", new Employee());
			model.addAttribute("errorMsg", "Please Fill at least one field");
			return "SearchEmployee";
		}

		/******************************************************
		 * Search by wildcard
		 ********************************************************/

		if (emp.getEmpId() == null || emp.getEmpId().equalsIgnoreCase("")) {
			emp.setEmpId("%");
		} else {
			String empId = emp.getEmpId().replace("*", "%");
			empId = empId.replace("?", "_");
			emp.setEmpId(empId);
		}

		/******************************************************
		 * Search by first Name
		 ********************************************************/

		if (emp.getFirstName() == null
				|| emp.getFirstName().equalsIgnoreCase("")) {
			emp.setFirstName("%");
		} else {
			String fName = emp.getFirstName().replace("*", "%");
			fName = fName.replace("?", "_");
			emp.setFirstName(fName);
		}

		/******************************************************
		 * Search by last Name
		 ********************************************************/

		if (emp.getLastName() == null || emp.getLastName().equalsIgnoreCase("")) {
			emp.setLastName("%");
		} else {
			String lName = emp.getLastName().replace("*", "%");
			lName = lName.replace("?", "_");
			emp.setLastName(lName);
		}
		/******************************************************
		 * Search by Department
		 ********************************************************/

		if (Integer.parseInt(emp.getDeptId()) == 0) {
			emp.setDeptId("%");
		}

		/******************************************************
		 * Search by Grade
		 ********************************************************/

		if (emp.getGrade() == null || emp.getGrade().equalsIgnoreCase("")) {
			emp.setGrade("%");
		}

		/******************************************************
		 * Search by Marital Status
		 ********************************************************/

		if (emp.getMaritalStatus() == null
				|| emp.getMaritalStatus().equalsIgnoreCase("")) {
			emp.setMaritalStatus("%");
		}

		ArrayList<Employee> emps = null;
		try {
			emps = service.searchEmployee(emp);
		} catch (InvalidEmployeeDetails e) {
			model.addAttribute("errorMsg", e.getMessage());
			return "errorPage";
		}

		model.addAttribute("departments", departments);
		model.addAttribute("maritalStatus", maritalStatus);
		model.addAttribute("grades", grades);
		model.addAttribute("empSearch", new Employee());

		if (emps.size() != 0) {
			model.addAttribute("emps", emps);
			return "SearchResult";
		} else {
			model.addAttribute("departments", departments);
			model.addAttribute("maritalStatus", maritalStatus);
			model.addAttribute("grades", grades);
			model.addAttribute("empSearch", new Employee());
			model.addAttribute("errorMsg", "No data Found");
			return "SearchEmployee";
		}
	}

	//@formatter:off
	/**************************************************************************************************
	*ACTION : showUpdateEmployee																      *
	*FROM   : 																		                  *
	*TO     : errorPage ; UpdationRequest.	                                    					  *
	*DESCR  : Redirects to UpdatION Page.  															  *
	**************************************************************************************************/
	//@formatter:on 

	@RequestMapping(value = "showUpdateEmployee", method = RequestMethod.GET)
	public String showUpdateEmployee(Model model) {

		ArrayList<String> empIds = null;

		try {
			empIds = service.getEmpIds();
		} catch (InvalidEmployeeDetails e) {
			model.addAttribute("errorMsg", e.getMessage());
			return "errorPage";
		}

		model.addAttribute("empIds", empIds);
		emsLogger.info("User requested for updation");
		return "UpdationRequest";

	}

	//@formatter:off
	/**************************************************************************************************
	*ACTION : UpdateRequest																    		  *
	*FROM   : 																		                  *
	*TO     : errorPage ; EmployeeUpdation.	                   					                      *
	*DESCR  : Options to select an employee to be updated .  										  *
	**************************************************************************************************/
	//@formatter:on 

	@RequestMapping(value = "UpdateRequest", method = RequestMethod.POST)
	public String shoeUpdateForm(@RequestParam("selEmpId") String empId,
			Model model) {

		Employee emp = null;
		try {
			emp = service.searchByIdEmployee(empId);
		} catch (InvalidEmployeeDetails e) {
			model.addAttribute("errorMsg", e.getMessage());
			return "errorPage";
		}

		model.addAttribute("departments", departments);
		model.addAttribute("designation", designation);
		model.addAttribute("maritalStatus", maritalStatus);
		model.addAttribute("empUpdate", emp);
		emsLogger.info("User Updation details were displayed");
		return "EmployeeUpdation";
	}

	//@formatter:off
	/*************************************************************************************************
	*ACTION : UpdateEmployee															   		 	 *
	*FROM   : 																		                 *
	*TO     : errorPage ; EmployeeUpdation ;AdminHome.	                                     		 *
	*DESCR  : Updates Employee Details. 															 *
	**************************************************************************************************/
	//@formatter:on 

	@RequestMapping(value = "UpdateEmployee", method = RequestMethod.POST)
	public String updateEmployee(
			@Valid @ModelAttribute("empUpdate") Employee emp,
			BindingResult bindResult, Model model) {

		if (bindResult.hasErrors()) {
			model.addAttribute("empUpdate", emp);
			model.addAttribute("departments", departments);
			model.addAttribute("designation", designation);
			model.addAttribute("maritalStatus", maritalStatus);

			return "EmployeeUpdation";
		} else {

			Grade grade = null;
			try {
				grade = service.calGrade(emp.getBasic());
			} catch (InvalidEmployeeDetails e) {
				model.addAttribute("errorMsg", e.getMessage());
				return "errorPage";
			}
			emp.setGrade(grade.getGradeCode());

			int rows = 0;
			try {
				rows = service.updateEmployee(emp);
			} catch (InvalidEmployeeDetails e) {
				model.addAttribute("errorMsg", e.getMessage());
				return "errorPage";
			}
			emsLogger.info("User redirected to HomePage");
			if (rows != 0) {
				model.addAttribute("updated", 1);
				model.addAttribute("empUpdate", emp);
				model.addAttribute("departments", departments);
				model.addAttribute("designation", designation);
				model.addAttribute("maritalStatus", maritalStatus);
				return "EmployeeUpdation";
			} else {
				return "AdminHome";
			}
		}
	}

}
