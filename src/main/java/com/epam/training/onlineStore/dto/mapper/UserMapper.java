package com.epam.training.onlineStore.dto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epam.training.onlineStore.model.User;

public class UserMapper implements RowMapper <User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User(
			rs.getLong("id"),
			rs.getString("login"),
			rs.getString("password"),
			rs.getString("name"),
			rs.getString("email"),
			rs.getBoolean("inBlackList"),
			rs.getBoolean("isAdmin"));
						
		return user;
	}

}