package com.felipe.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.felipe.curso.entities.User;
import com.felipe.curso.repositories.UserRepository;

@Configuration
@Profile("test")
//Classe especifica de configuração, somente quando estiver no perfil de teste.
public class TestConfig implements CommandLineRunner{//criou um metodo que vai ser executado quando a aplicação for iniciada no perfil de teste

	@Autowired
	private UserRepository userRepository;//injeção de dependencia.
	
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		userRepository.saveAll(Arrays.asList(u1,u2));//vai salvar os dados nesse array
		
	}
	
	
	
}
