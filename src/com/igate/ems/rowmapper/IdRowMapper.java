package com.igate.ems.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.ems.dto.Employee;

public class IdRowMapper implements RowMapper<String> {

	@Override
	public String mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		String empId = resultSet.getString(1);
		return empId;
	}

}
