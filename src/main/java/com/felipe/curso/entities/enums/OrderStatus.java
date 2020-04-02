package com.felipe.curso.entities.enums;

public enum OrderStatus {

	WATTING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;

	private OrderStatus(int code) {
		// TODO Auto-generated constructor stub

		this.code = code;

	}

	public int getCode() {
		return code;
	}
	
	public static OrderStatus valueOf(int code) {//esse metodo vai converter de um valor numerico para um tipo enumerado
		
		for(OrderStatus value : OrderStatus.values()) {//um forEach que vai percorrer todos os valores possiveis do orderStatus
			
			if (value.getCode() == code) {//vai testar se o valor do get code que percorreu a lista vai ser igual ao argumento passado

				return value;

			}

		}

		throw new IllegalArgumentException("Codigo invalido!!!");

	}

}
