package com.joyonta.springbootsecuritywithjwtaccessrefreshtokens.bean;

import lombok.Data;

@Data
public class RoleToUserForm {
    private String roleName;
    private String username;
}
