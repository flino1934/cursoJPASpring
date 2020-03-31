package com.felipe.curso.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.curso.entities.Order;
import com.felipe.curso.services.OrderService;

@RestController
//Esse classe implementa uma outra classe rest
@RequestMapping(value = "/orders")//caminho para acessar
public class OrderResource {
	
	@Autowired
	//Vai fazer a injeção de dependencia de forma transparente
	private OrderService service;
	
	@GetMapping
	//Responde a uma requisição do metodo get do http
	public ResponseEntity<List<Order>> findAll(){//Vai retornar um tipo generico de lista, no caso um tipo de lista que vai recebe a classe Order
		
		List<Order> list = service.findAll();//A lista vai receber o metodo findAll() que vem da classe OrderService
		return ResponseEntity.ok().body(list);//Vaii retornar pelo http pelo corpo o usuario que foi mandado pela instancia
		
	}
	
	@GetMapping(value ="/{id}")//Para falar que vai receber um id
	//Responde a uma requisição do metodo get do http e vai trazer um id coo argumento
	public ResponseEntity<Order> findById(@PathVariable Long id){//para o spring aceitar o id como parametro precisa colocar o @PathVariable para ele entender
		
		Order obj = service.findById(id);//vai trazer o metodo da classe findById
		return ResponseEntity.ok().body(obj);//Vaii retornar pelo http pelo corpo o usuario que foi mandado pela instancia
		
	}
	
}
