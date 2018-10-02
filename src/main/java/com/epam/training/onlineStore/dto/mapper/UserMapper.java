package com.epam.training.onlineStore.dto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epam.training.onlineStore.model.User;

public class UserMapper implements RowMapper <User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User(
			rs.getLong("User.userId"),
			rs.getString("User.login"),
			rs.getString("User.password"),
			rs.getString("User.name"),
			rs.getString("User.email"),
			rs.getBoolean("User.inBlackList"),
			rs.getBoolean("User.isAdmin"));
						
		return user;
	}

}
