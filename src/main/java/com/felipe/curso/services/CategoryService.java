package com.felipe.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.curso.entities.Category;
import com.felipe.curso.repositories.CategoryRepository;



@Service
//Esta sendo injetado como componente no Spring
public class CategoryService {

	
	@Autowired
	//para fazer a injeção de dependencia de forma transparente
 	private CategoryRepository repository;
	
	public List<Category>findAll(){
		
		return repository.findAll();//Vai chamar a operação findAll() da interface userRepository que extend JpaRepository que já uma classe pronta da jpa 
		
	}
	
	
	public Category findById(Long id) {//Vai chamar a operação findAll() da interface userRepository que extend JpaRepository que já uma classe pronta da jpa e vai buscar categoria por ID
		
		Optional<Category> obj = repository.findById(id);//vai passar o id como argumento
		return obj.get();//Vai retornar oq estiver dentro do <>
		
	}
	
}
