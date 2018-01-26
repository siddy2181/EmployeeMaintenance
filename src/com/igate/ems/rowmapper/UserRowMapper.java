package com.igate.ems.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.ems.dto.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int row) throws SQLException {
		User user = new User();

		user.setUserId(rs.getString("userId"));
		user.setUserName(rs.getString("userName"));
		user.setPassword(rs.getString("userPassword"));
		user.setUserType(rs.getString("userType"));

		return user;
	}

}
