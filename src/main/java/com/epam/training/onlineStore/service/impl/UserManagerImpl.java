package com.epam.training.onlineStore.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.epam.training.onlineStore.model.User;
import com.epam.training.onlineStore.service.UserManager;

@SessionScope
@Service
public class UserManagerImpl implements UserManager{

    private User user;

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }
}
