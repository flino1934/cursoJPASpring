package com.felipe.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.curso.entities.User;
import com.felipe.curso.repositories.UserRepository;



@Service
//Esta sendo injetado como componente no Spring
public class UserService {

	
	@Autowired
	//para fazer a injeção de dependencia de forma transparente
 	private UserRepository repository;
	
	public List<User>findAll(){
		
		return repository.findAll();//Vai chamar a operação findAll() da interface userRepository que extend JpaRepository que já uma classe pronta da jpa 
		
	}
	
	
	public User findById(Long id) {//Vai chamar a operação findAll() da interface userRepository que extend JpaRepository que já uma classe pronta da jpa e vai buscar o usuario por ID
		
		Optional<User> obj = repository.findById(id);//vai passar o id como argumento
		return obj.get();//Vai retornar oq estiver dentro do <>
		
	}
	
	public User insert(User obj) {//Vai chamar a operação insert() da interface UserRepository que extends JpaRepository
 		
		return repository.save(obj);//Vai retornar o obj salvo
		
	}
	
	public void delete(Long id) {//Vai chamar a operação delete() da interface UserRepository que extends JpaRepository
 		
		repository.deleteById(id);//Vai passar o id que sera deletado
		
	}
	
}
