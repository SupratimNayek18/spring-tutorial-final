package com.spring.jwtmongo;

import com.spring.jwtmongo.model.User;
import com.spring.jwtmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableMongoRepositories
public class JwtMongoSpringBoot3Application implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(JwtMongoSpringBoot3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User("supratim",passwordEncoder.encode("1234"),"ROLE_ADMIN"));
		userRepository.save(new User("sohom",passwordEncoder.encode("12345"),"ROLE_USER"));
	}
}
