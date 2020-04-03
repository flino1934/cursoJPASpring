package com.felipe.curso.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.felipe.curso.entities.pk.OrderItemPK;

@Entity
@Table(name = "tb_order_Item")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	//É um id composto que retorna de outra classe 
	private OrderItemPK id = new OrderItemPK();

	private Integer quantity;
	private Double price;

	public OrderItem() {
		// TODO Auto-generated constructor stub
	}

	// Não vai receber o id no metodo construtor pois vamos passar as classes Order e product como argumento

	public OrderItem(Order order, Product product, Integer quantity, Double price) {

		id.setOrder(order);//Vai ate a classe OrderItemPK e vai no metodo setOrde e passar os dados de la como argumento
		id.setProduct(product);//Vai ate a classe OrderItemPK e vai no metodo setOrde e passar os dados de la como argumento
		this.quantity = quantity;
		this.price = price;
		
	}
	@JsonIgnore
	//estava tendo um problema de referencia ciclica chamava o pedido e o pedido chava itemdopedido
	public Order getOrder() {
		
		return id.getOrder();//Vai ate a classe OrderItemPK e vai no metodo get que vai na classe order e vamos trazer o id
		
	}
	
	public void setOrder(Order order) {
		
		id.setOrder(order);//Ele vai pegar o id do pedido e jogar dentro do pedido
		
	}
	
	
	public Product getProduct() {
		
		return id.getProduct();//Vai ate a classe OrderItemPK e vai no metodo get que vai na classe Product e vamos trazer o id
		
	}
	
	public void setProduct(Product product) {
		
		id.setProduct(product);//Ele vai pegar o id do produto e jogar dentro do pedido
		
	}
	

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getSubTotal() {
		
		return price * quantity;
		
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
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
