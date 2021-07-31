package com.joyonta.springbootsecuritywithjwtaccessrefreshtokens.repo;

import com.joyonta.springbootsecuritywithjwtaccessrefreshtokens.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);

}
