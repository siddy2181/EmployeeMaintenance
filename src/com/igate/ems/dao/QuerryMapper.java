package com.igate.ems.dao;

public interface QuerryMapper {

	public static final String loginQuery = "SELECT userId,userName,userPassword,userType FROM User_Master WHERE userName = ? AND UserPassword = ?";

	public static final String viewSql = "SELECT Emp_Id,Emp_First_Name,Emp_Last_Name,Emp_Date_of_Birth,Emp_Date_of_Joining,Emp_Dept_Id,Emp_Grade,Emp_Designation,Emp_Basic,Emp_Gender,Emp_Marital_Status,Emp_home_Address,Emp_Contact_Num FROM Employee_Master ORDER BY Emp_Id ";

	public static final String insertRecord = "INSERT INTO Employee_Master(Emp_Id,Emp_First_Name,Emp_Last_Name,Emp_Date_of_Birth,Emp_Date_of_Joining,Emp_Dept_Id,Emp_Grade,Emp_Designation,Emp_Basic,Emp_Gender,Emp_Marital_Status,Emp_home_Address,Emp_Contact_Num) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static final String searchByIdQuery = "SELECT Emp_Id,Emp_First_Name,Emp_Last_Name,Emp_Date_of_Birth,Emp_Date_of_Joining,Emp_Dept_Id,Emp_Grade,Emp_Designation,Emp_Basic,Emp_Gender,Emp_Marital_Status,Emp_home_Address,Emp_Contact_Num FROM Employee_Master WHERE Emp_Id = ?";

	public static final String seqEmp = "SELECT seqEmp.nextVal FROM dummy";

	public static final String searchEmpQry = "SELECT Emp_Id,Emp_First_Name,Emp_Last_Name,Emp_Date_of_Birth,Emp_Date_of_Joining,Emp_Dept_Id,Emp_Grade,Emp_Designation,Emp_Basic,Emp_Gender,Emp_Marital_Status,Emp_home_Address,Emp_Contact_Num FROM employee_master WHERE emp_id LIKE ? AND emp_first_name LIKE ? AND emp_last_name LIKE ? AND emp_dept_id LIKE ? AND emp_grade LIKE ? AND emp_marital_status LIKE ?";

	public static final String updateQuery = "UPDATE employee_master SET Emp_Last_Name=?,Emp_Dept_Id=?"
			+ ",Emp_Grade=?,Emp_Designation=?,Emp_Basic=?,Emp_Marital_Status=?,"
			+ "Emp_home_Address=?,Emp_Contact_Num=? WHERE Emp_Id=?";

	public static final String gradeQry = "SELECT grade_code,description,min_salary,max_salary FROM grade_master WHERE  ? BETWEEN min_salary AND max_salary";

	public static final String allEmpIdQry = "SELECT emp_id FROM employee_master";

	public static final String deptQry = "SELECT dept_id,dept_name FROM department_master";

	public static final String getAllGrade = "SELECT grade_code,description,min_salary,max_salary FROM grade_master";
}
