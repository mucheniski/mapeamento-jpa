package com.course.mapeamentojpa.configs;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.course.mapeamentojpa.entities.User;
import com.course.mapeamentojpa.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Bruna", "bruna@teste.com", "99999999", "123");
		User user2 = new User(null, "Diego", "diego@teste.com", "99999999", "123");
		
		userRepository.saveAll(Arrays.asList(user1, user2));
	}
	
		

}
