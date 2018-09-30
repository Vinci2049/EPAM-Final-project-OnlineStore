package com.epam.training.onlineStore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.training.onlineStore.dto.UserDAO;
import com.epam.training.onlineStore.model.User;
import com.epam.training.onlineStore.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean checkAndAddUser(User user) {
        User findUser = findUserByLogin(user.getLogin());
        if (findUser != null) {
            return false;
        }
        userDAO.add(user);
        return true;
    }

    /*@Override
    public long deleteUser(long id) {
        return userDAO.delete(id);
    }

    @Override
    public List<User> getUsers() {
        return userDAO.getAll();
    }

    @Override
    public User getUserById(long id) {
        return userDAO.getById(id);
    }

    @Override
    public long setUser(long id, User user) {
        return userDAO.set(id, user);
    }*/

    @Override
    public User findUserByLogin(String login) {
        if (login.length() == 0) {
            return null;
        }
        return userDAO.findByLogin(login);
    }

    /*@Override
    public boolean checkAndUpdateUser(User user) {
        User findUser = getUserByLogin(user.getLogin());
        if (findUser != null && findUser.getId() != user.getId()) {
            return false;
        }
        setUser(user.getId(), user);
        return true;
    }*/

    @Override
    public User checkLoginAndPasswordAndGetUser(String login, String password) {
        User user = findUserByLogin(login);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

	@Override
	public List<User> getAll() {
        return this.userDAO.getAll();
	}

	@Override
	public User findById(long id) {
		return this.userDAO.findById(id);
	}
	
	@Override
	public long add(User user) {
		return this.userDAO.add(user);
	}

	@Override
	public long edit(User user) {
		return this.userDAO.edit(user);
	}

	@Override
	public long deleteById(long id) {
		return this.userDAO.deleteById(id);
	}

}
