package com.felipe.curso.resources;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.curso.entities.User;

@RestController
//Esse classe implementa uma outra classe rest
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	//Responde a uma requisição do metodo get do http
	public ResponseEntity<User> findAll(){
		
		User u = new User(1L, "Felipe","fe@hotmail.com","13981375682","123456");
		return ResponseEntity.ok().body(u);//Vaii retornar pelo http pelo corpo o usuario que foi mandado pela instancia
		
	}

}
