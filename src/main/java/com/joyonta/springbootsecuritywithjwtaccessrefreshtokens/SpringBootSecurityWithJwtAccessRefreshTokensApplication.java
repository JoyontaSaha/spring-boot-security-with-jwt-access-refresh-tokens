package com.joyonta.springbootsecuritywithjwtaccessrefreshtokens;

import com.joyonta.springbootsecuritywithjwtaccessrefreshtokens.domain.Role;
import com.joyonta.springbootsecuritywithjwtaccessrefreshtokens.domain.User;
import com.joyonta.springbootsecuritywithjwtaccessrefreshtokens.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringBootSecurityWithJwtAccessRefreshTokensApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityWithJwtAccessRefreshTokensApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role("ROLE_USER"));
			userService.saveRole(new Role("ROLE_MANAGER"));
			userService.saveRole(new Role("ROLE_ADMIN"));
			userService.saveRole(new Role("ROLE_SUPER_ADMIN"));

			userService.saveUser(new User("John Travolta", "john", "1234", new ArrayList<>()));
			userService.saveUser(new User("Will Smith", "will", "1234", new ArrayList<>()));
			userService.saveUser(new User("Jim Carry", "jim", "1234", new ArrayList<>()));
			userService.saveUser(new User("Arnold Schwarzenegger", "arnold", "1234", new ArrayList<>()));

			userService.addRoleToUser("john", "ROLE_USER");
			userService.addRoleToUser("john", "ROLE_MANAGER");
			userService.addRoleToUser("will", "ROLE_MANAGER");
			userService.addRoleToUser("jim", "ROLE_ADMIN");
			userService.addRoleToUser("arnold", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("arnold", "ROLE_ADMIN");
			userService.addRoleToUser("arnold", "ROLE_USER");
		};
	}


}
