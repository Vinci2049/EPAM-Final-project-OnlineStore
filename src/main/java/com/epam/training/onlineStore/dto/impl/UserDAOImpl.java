package com.epam.training.onlineStore.dto.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epam.training.onlineStore.dto.UserDAO;
import com.epam.training.onlineStore.dto.mapper.UserMapper;
import com.epam.training.onlineStore.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }	

    @Override
	public List<User> getAll() {
		return this.jdbcTemplate.query("SELECT * FROM USER", new UserMapper());
	}

	@Override
	public User findById(long id) {
		return this.jdbcTemplate.queryForObject("SELECT * FROM USER WHERE id = ?",
                new Object[]{id}, new UserMapper());
	}

	public User findByLogin(String login) {
		try {
			return this.jdbcTemplate.queryForObject("SELECT * FROM USER WHERE login = ?",
	                new Object[]{login}, new UserMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		
	}
	
	
	@Override
	public long add(User user) {
		return this.jdbcTemplate.update("INSERT INTO USER (login, password, name, email, inBlackList, isAdmin) VALUES"
                + "(?,?,?,?,?,?)"
                , user.getLogin()
              	, user.getPassword()
				, user.getName()
				, user.getEmail()
				, user.getInBlackList()
				, user.getIsAdmin());
		}

}
