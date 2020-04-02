package com.felipe.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.felipe.curso.entities.Category;
import com.felipe.curso.entities.Order;
import com.felipe.curso.entities.OrderItem;
import com.felipe.curso.entities.Product;
import com.felipe.curso.entities.User;
import com.felipe.curso.entities.enums.OrderStatus;
import com.felipe.curso.repositories.CategoryRepository;
import com.felipe.curso.repositories.OrderItemRepository;
import com.felipe.curso.repositories.OrderRepository;
import com.felipe.curso.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;//Injeção de dependencia
	
	@Autowired
	private OrderItemRepository orderItemRepository;//Injeção de dependencia

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers"); 
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategories().add(cat2);//Esta fazendo uma associação de objetos, esta falando que p1 é da categoria cat2
		p2.getCategories().add(cat1);//Esta fazendo uma associação de objetos, esta falando que p2 é da categoria cat1
		p2.getCategories().add(cat3);//Esta fazendo uma associação de objetos, esta falando que p2 é da categoria cat3
		p3.getCategories().add(cat3);//Esta fazendo uma associação de objetos, esta falando que p3 é da categoria cat3
		p5.getCategories().add(cat2);//Esta fazendo uma associação de objetos, esta falando que p5 é da categoria cat2
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WATTING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WATTING_PAYMENT, u1);

		userRepository.saveAll(Arrays.asList(u1, u2));// vai salvar os dados nesse array
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));// vai salvar os dados nesse array
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));

	}
	
	
	
}
