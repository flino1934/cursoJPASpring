package com.felipe.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.curso.entities.Order;
import com.felipe.curso.repositories.OrderRepository;



@Service
//Esta sendo injetado como componente no Spring
public class OrderService {

	
	@Autowired
	//para fazer a injeção de dependencia de forma transparente
 	private OrderRepository repository;
	
	public List<Order>findAll(){
		
		return repository.findAll();//Vai chamar a operação findAll() da interface userRepository que extend JpaRepository que já uma classe pronta da jpa 
		
	}
	
	
	public Order findById(Long id) {//Vai chamar a operação findAll() da interface userRepository que extend JpaRepository que já uma classe pronta da jpa e vai buscar a venda por ID
		
		Optional<Order> obj = repository.findById(id);//vai passar o id como argumento
		return obj.get();//Vai retornar oq estiver dentro do <>
		
	}
	
}
