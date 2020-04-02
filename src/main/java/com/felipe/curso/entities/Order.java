package com.felipe.curso.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.felipe.curso.entities.enums.OrderStatus;

@Entity
//Vai criar uma tabela no BD com os seguintes atributos dessa classe 
@Table(name = "tb_order")
//Vai dar o nome da tabela de tb_order
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	//Esta definindo como chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//Auto incrementavel no banco
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
	//Formatando o formato de data do JSON
	private Instant moment;
	
	private Integer orderStatus;//Mudamos de orderStatus para Integer para informar de forma explicita que estamos gravando ele na classe
	
	@ManyToOne
	//esta falando que a associação é de muitos para um
	@JoinColumn(name = "client_id")
	//Nome da chave estrangeira que vai ter no banco
	private User client;// O pedido tem um cliente
	
	@OneToMany(mappedBy = "id.order")//ordemItem tem o id e o id tem o pedido(O id esta na classe OrdemItemPK)
	private Set<OrderItem> items = new HashSet<>();

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {

		this.id = id;
		this.moment = moment;
		setOrderStatus(orderStatus);//Vai ateribuir por essa pq ele recebe um valor enum e converte para inteiro
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);//Esta utilizando o metodo de converção de codigo da classe OrderStatus,vai receber um valor inteiro e vai converter ele para OrderStatus
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		
		if (orderStatus != null) {
			
			this.orderStatus = orderStatus.getCode();//vai receber um valor tipo orderStatus e vai precisar armazenar um inteiro	
		
		}
		
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public Set<OrderItem> getItems() {
		return items;
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
