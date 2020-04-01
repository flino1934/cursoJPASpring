package com.felipe.curso.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
//vai criar uma tabela com os seguintes atributos.
@Table(name = "tb_category")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	//Vai ser a chave primaria da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//Auto incrementavel
	private Long id;
	private String name;
	
	@ManyToMany(mappedBy = "categories")
	//muitos para muitos, esta peassociado de categories
	@JsonIgnore
	//Para não ter o lupping infinito
	private Set<Product>products = new HashSet<>();
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(Long id, String name) {

		this.id = id;
		this.name = name;
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

	public Set<Product> getProducts() {
		return products;
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
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
