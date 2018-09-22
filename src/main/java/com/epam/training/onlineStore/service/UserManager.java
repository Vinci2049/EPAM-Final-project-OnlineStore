package com.epam.training.onlineStore.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.epam.training.onlineStore.model.User;

@SessionScope
@Service
public class UserManager {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
