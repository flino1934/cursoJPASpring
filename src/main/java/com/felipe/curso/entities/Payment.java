package com.felipe.curso.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//Vai criar uma tabela no BD com os seguintes atributos
@Table(name = "tb_payment")
public class Payment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	//Identifica como chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//Auto incrementavel
	private Long id;
	private Instant date;

	@JsonIgnore
	@OneToOne
	@MapsId
	//Um para um, só que a classe pagamento é a classe dependente pois pode ter pedido sem pagamento mas não pode ter pagamento sem pedido
	private Order order;

	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public Payment(Long id, Instant date, Order order) {

		this.id = id;
		this.date = date;
		this.order = order;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
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
		Payment other = (Payment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
