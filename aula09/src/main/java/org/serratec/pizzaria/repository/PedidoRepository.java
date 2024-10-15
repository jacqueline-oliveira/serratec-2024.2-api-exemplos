package org.serratec.pizzaria.repository;

import java.util.List;

import org.serratec.pizzaria.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{ //botar grudado, custa ponto
	List<Pedido> findByPizzaIgnoreCase(String pizza);
	List<Pedido> findByClienteIgnoreCase(String nome);
	
}
