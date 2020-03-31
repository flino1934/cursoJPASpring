package com.felipe.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipe.curso.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

	
	
	
}
