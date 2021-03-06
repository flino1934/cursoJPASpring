package com.felipe.curso.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//A JPA vai criar uma tabela DB com os campos dos atributos da classe
@Table(name = "tb_user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	//Esta informando que é a chave primaria.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//Vai ser auto incrementavel
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	@OneToMany(mappedBy = "client")//e esta falando que na classe order ele esta mapeado com o nome de "client", fazemos esse mapeamento para puxar pelo id do cliente os pedidos
	//De um para muitos 
	@JsonIgnore
	//Para ignorar a associação de mão dupla um fica chamando o outro o tempo todo criando um looping infinito
	private List<Order> orders = new ArrayList<>();//um usuario tem varios pedidos

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Long id, String name, String email, String phone, String password) {

		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
