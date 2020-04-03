package com.felipe.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.curso.entities.User;
import com.felipe.curso.repositories.UserRepository;
import com.felipe.curso.services.exceptions.ResourceNotFoundException;



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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));//Vai retornar oq estiver dentro do <> se não ele vai lançar uma excptions
		
	}
	
	public User insert(User obj) {//Vai chamar a operação insert() da interface UserRepository que extends JpaRepository
 		
		return repository.save(obj);//Vai retornar o obj salvo
		
	}
	
	public void delete(Long id) {//Vai chamar a operação delete() da interface UserRepository que extends JpaRepository
 		
		repository.deleteById(id);//Vai passar o id que sera deletado
		
	}
	
	public User update(Long id,User obj) {//Vai chamar a operação insert() da interface UserRepository que extends JpaRepository
 		
		User entity = repository.getOne(id);//Vai monitorar o objeto
		updateData(entity,obj);//Vai chamar o metodo
		return repository.save(entity);//Vai retornar o obj salvo
		
	}


	private void updateData(User entity, User obj) {//Vai atualizar e restringir os campos que podem ser atualizados 
		
		entity.setName(obj.getName());//Vai atualizar o nome
		entity.setEmail(obj.getEmail());//Vai atualizar o email
		entity.setPhone(obj.getPhone());//Vai atualizar o telefone
		
	}
	
	
	
}
