package com.spring.springsecurity2;

import com.spring.springsecurity2.model.User;
import com.spring.springsecurity2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurity2Application implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurity2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User("Supratim",passwordEncoder.encode("1234"),"ROLE_USER",true));
		userRepository.save(new User("Shreyas",passwordEncoder.encode("1234"),"ROLE_ADMIN",true));
	}
}
