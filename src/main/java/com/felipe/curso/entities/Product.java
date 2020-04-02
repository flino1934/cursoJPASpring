package com.felipe.curso.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
//Vai criar uma tabela no BD com os seguintes atributos da classe.
@Table(name = "tb_product")
//Esta dando o nome da tabela no BD de "tb_product"
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	//Vai ser a chave primaria na tabela.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//vai ser auto incrementavel
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
	
	@ManyToMany
	//Muitos para muitos.
	@JoinTable(name = "tb_product_category",joinColumns = @JoinColumn(name = "product_id"),inverseJoinColumns = @JoinColumn(name = "category_id"))
	//Definiu o nome da tabela e as colunas que vão associar
	private Set<Category> categories = new HashSet<>();//Para garantir que o mesmo produto não tenha a MESMA categoria duas vezes mas ele pode ter duas categorias diferentes

	@OneToMany(mappedBy = "id.product")//Ele vai na classe OrderItem ela vai vai mandar para classe OrdemItemPK que vai pegar pelo meo getProduct
	private Set<OrderItem> items = new HashSet<>();
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Long id, String name, String description, Double price, String imgUrl) {

		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Category> getCategories() {
		return categories;
	}
	
	
	@JsonIgnore
	public Set<Order> getOrders() {
		
		Set<Order> set  = new HashSet<>();
		
		for (OrderItem x : items) {//Vai adicionar TOdos os orders contidos em ordemitem
			
			set.add(x.getOrder());
			
		}
		
		return set;
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
