package com.felipe.curso.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.curso.entities.Category;
import com.felipe.curso.services.CategoryService;

@RestController
//Esse classe implementa uma outra classe rest
@RequestMapping(value = "/categories")//caminho para acessar
public class CategoryResource {
	
	@Autowired
	//Vai fazer a injeção de dependencia de forma transparente
	private CategoryService service;
	
	@GetMapping
	//Responde a uma requisição do metodo get do http
	public ResponseEntity<List<Category>> findAll(){//Vai retornar um tipo generico de lista, no caso um tipo de lista que vai recebe a classe Category
		
		List<Category> list = service.findAll();//A lista vai receber o metodo findAll() que vem da classe CategoryService
		return ResponseEntity.ok().body(list);//Vaii retornar pelo http pelo corpo o usuario que foi mandado pela instancia
		
	}
	
	@GetMapping(value ="/{id}")//Para falar que vai receber um id
	//Responde a uma requisição do metodo get do http e vai trazer um id coo argumento
	public ResponseEntity<Category> findById(@PathVariable Long id){//para o spring aceitar o id como parametro precisa colocar o @PathVariable para ele entender
		
		Category obj = service.findById(id);//vai trazer o metodo da classe findById
		return ResponseEntity.ok().body(obj);//Vaii retornar pelo http pelo corpo o usuario que foi mandado pela instancia
		
	}
	
}
