package com.igate.ems.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.ems.dto.Grade;

public class GradeRowMapper implements RowMapper<Grade>{
	

	@Override
	public Grade mapRow(ResultSet rs, int row) throws SQLException {
		Grade grade = new Grade();
		grade.setGradeCode(rs.getString("grade_code"));
		grade.setDescription(rs.getString("description"));
		grade.setMinSal(rs.getLong("min_salary"));
		grade.setMaxSal(rs.getLong("max_salary"));
		return grade;
	}
}
