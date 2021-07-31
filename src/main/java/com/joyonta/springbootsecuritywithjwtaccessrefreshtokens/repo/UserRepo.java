package com.joyonta.springbootsecuritywithjwtaccessrefreshtokens.repo;

import com.joyonta.springbootsecuritywithjwtaccessrefreshtokens.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
