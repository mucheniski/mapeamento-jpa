package com.course.mapeamentojpa.configs;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.course.mapeamentojpa.entities.Category;
import com.course.mapeamentojpa.entities.Order;
import com.course.mapeamentojpa.entities.OrderItem;
import com.course.mapeamentojpa.entities.Payment;
import com.course.mapeamentojpa.entities.Product;
import com.course.mapeamentojpa.entities.User;
import com.course.mapeamentojpa.enums.OrderStatus;
import com.course.mapeamentojpa.repositories.CategoryRepository;
import com.course.mapeamentojpa.repositories.OrderItemRepository;
import com.course.mapeamentojpa.repositories.OrderRepository;
import com.course.mapeamentojpa.repositories.ProductRepository;
import com.course.mapeamentojpa.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Bruna", "bruna@teste.com", "99999999", "123");
		User user2 = new User(null, "Diego", "diego@teste.com", "99999999", "123");
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		
		Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user1);
		Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2);
		Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user1);
		
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));
		
		Category category1 = new Category(null, "Electronics");
		Category category2 = new Category(null, "Books");
		Category category3 = new Category(null, "Computers");
		
		Product product1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product product2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product product3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product product4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product product5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");		
		
		categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
		productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));
		
		product1.getCategories().addAll(Arrays.asList(category2));
		product2.getCategories().addAll(Arrays.asList(category1, category3));
		product3.getCategories().addAll(Arrays.asList(category3));
		product4.getCategories().addAll(Arrays.asList(category3));
		product5.getCategories().addAll(Arrays.asList(category2));
		
		productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));
		
		OrderItem item1 = new OrderItem(order1, product1, 2, product1.getPrice());
		OrderItem item2 = new OrderItem(order1, product3, 1, product3.getPrice());
		OrderItem item3 = new OrderItem(order2, product3, 2, product3.getPrice());
		OrderItem item4 = new OrderItem(order3, product5, 2, product5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(item1, item2, item3, item4));
		
		Payment payment1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), order1);
		order1.setPayment(payment1);
		orderRepository.save(order1);
				
	}
	
		

}
