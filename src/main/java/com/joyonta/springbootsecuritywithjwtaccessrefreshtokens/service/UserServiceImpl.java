package com.joyonta.springbootsecuritywithjwtaccessrefreshtokens.service;

import com.joyonta.springbootsecuritywithjwtaccessrefreshtokens.domain.Role;
import com.joyonta.springbootsecuritywithjwtaccessrefreshtokens.domain.User;
import com.joyonta.springbootsecuritywithjwtaccessrefreshtokens.repo.RoleRepo;
import com.joyonta.springbootsecuritywithjwtaccessrefreshtokens.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepo.findByUserName(username);
        Role role = roleRepo.findByName(roleName);

        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        return userRepo.findByUserName(username);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }
}
