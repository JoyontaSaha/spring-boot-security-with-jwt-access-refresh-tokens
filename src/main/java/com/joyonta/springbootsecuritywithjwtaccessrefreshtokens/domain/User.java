package com.joyonta.springbootsecuritywithjwtaccessrefreshtokens.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String username;
    private String password;
    @ManyToMany(fetch =  FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    public User(String name, String username, String password, ArrayList<Role> roles) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
}
