package org.serratec.pizzaria.dto;

import org.serratec.pizzaria.model.Pedido;

public record PedidoDto(
		Long id,
		String cliente,
		String pizza,
		double valor
		) {
	
	public Pedido toEntity() { 
		Pedido pedido = new Pedido();
		pedido.setId(this.id);
		pedido.setCliente(this.cliente);
        pedido.setPizza(this.pizza);
        pedido.setValor(this.valor);
        return pedido;
	}
	
	public static PedidoDto toDto(Pedido pedido) { //usou static para transformar sem instanciar um pedido em DTO
		return new PedidoDto(pedido.getId(), pedido.getCliente(), 
				pedido.getPizza(), pedido.getValor());
	}
	
	
}
