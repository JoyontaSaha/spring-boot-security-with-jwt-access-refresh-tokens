package com.joyonta.springbootsecuritywithjwtaccessrefreshtokens.api;

import com.joyonta.springbootsecuritywithjwtaccessrefreshtokens.domain.User;
import com.joyonta.springbootsecuritywithjwtaccessrefreshtokens.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserResource {
    private final UserServiceImpl userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/test")
    public String apiTest() {
        return "Testing api is ok.....";
    }
}
