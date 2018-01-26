package com.igate.ems.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.ems.dto.Department;

public class DepartmentRowMapper implements RowMapper<Department> {

	@Override
	public Department mapRow(ResultSet rs, int row) throws SQLException {
		Department dept = new Department();
		dept.setDeptId(rs.getInt("dept_id"));
		dept.setDeptName(rs.getString("dept_name"));
		return dept;
	}

}
