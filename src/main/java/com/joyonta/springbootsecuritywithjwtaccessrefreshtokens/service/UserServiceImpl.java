package com.joyonta.springbootsecuritywithjwtaccessrefreshtokens.service;

import com.joyonta.springbootsecuritywithjwtaccessrefreshtokens.domain.Role;
import com.joyonta.springbootsecuritywithjwtaccessrefreshtokens.domain.User;
import com.joyonta.springbootsecuritywithjwtaccessrefreshtokens.repo.RoleRepo;
import com.joyonta.springbootsecuritywithjwtaccessrefreshtokens.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public User saveUser(User user) {
        log.info("Saving user {} to the database", user.getName());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving role {} to the database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {} ", roleName, username);
        User user = userRepo.findByUserName(username);
        Role role = roleRepo.findByName(roleName);

        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user {} ", username);
        return userRepo.findByUserName(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }
}
