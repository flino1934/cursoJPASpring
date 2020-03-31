package com.felipe.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.felipe.curso.entities.Category;
import com.felipe.curso.entities.Order;
import com.felipe.curso.entities.User;
import com.felipe.curso.entities.enums.OrderStatus;
import com.felipe.curso.repositories.CategoryRepository;
import com.felipe.curso.repositories.OrderRepository;
import com.felipe.curso.repositories.UserRepository;

@Configuration
@Profile("test")
//Classe especifica de configuração, somente quando estiver no perfil de teste.
public class TestConfig implements CommandLineRunner{//criou um metodo que vai ser executado quando a aplicação for iniciada no perfil de teste

	@Autowired
	private UserRepository userRepository;//injeção de dependencia.
	
	@Autowired
	private OrderRepository orderRepository;//injeção de dependencia.
	
	@Autowired
	private CategoryRepository categoryRepository;//injeção de dependencia.

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers"); 
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WATTING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WATTING_PAYMENT, u1);

		userRepository.saveAll(Arrays.asList(u1, u2));// vai salvar os dados nesse array
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));// vai salvar os dados nesse array

	}
	
	
	
}
