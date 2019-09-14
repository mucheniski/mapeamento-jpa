package com.course.mapeamentojpa.configs;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.course.mapeamentojpa.entities.Order;
import com.course.mapeamentojpa.entities.User;
import com.course.mapeamentojpa.enums.OrderStatus;
import com.course.mapeamentojpa.repositories.OrderRepository;
import com.course.mapeamentojpa.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Bruna", "bruna@teste.com", "99999999", "123");
		User user2 = new User(null, "Diego", "diego@teste.com", "99999999", "123");
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		
		Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user1);
		Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2);
		Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user1);
		
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));
	}
	
		

}
