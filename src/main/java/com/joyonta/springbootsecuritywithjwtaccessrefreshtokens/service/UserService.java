package com.joyonta.springbootsecuritywithjwtaccessrefreshtokens.service;

import com.joyonta.springbootsecuritywithjwtaccessrefreshtokens.domain.Role;
import com.joyonta.springbootsecuritywithjwtaccessrefreshtokens.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String role);
    User getUser(String username);
    List<User>getUsers();
}
