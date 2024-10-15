package org.serratec.pizzaria.service;

import java.util.List;
import java.util.Optional;

import org.serratec.pizzaria.dto.PedidoDto;
import org.serratec.pizzaria.model.Pedido;
import org.serratec.pizzaria.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository repositorio;
	
	public List<PedidoDto> obterTodos(){
		return repositorio.findAll().stream().map(p -> PedidoDto.toDto(p)).toList();
	}
	
	public Optional<PedidoDto> obterPorId(Long id){
		if(!repositorio.existsById(id)) {
			return Optional.empty();
		}
		return Optional.of(PedidoDto.toDto(repositorio.findById(id).get()));
	}
	
	public PedidoDto salvarPedido(PedidoDto dto) {
		Pedido pedidoEntity = repositorio.save(dto.toEntity());
		return PedidoDto.toDto(pedidoEntity);
		//return PedidoDto.toDto(repositorio.save(dto.toEntity()));
	}
	
	public boolean apagarPedido(Long id) {
		if(!repositorio.existsById(id)) {
			return false;
		}
		repositorio.deleteById(id);
		return true;
	}

	public Optional<PedidoDto> alterarPedido(Long id, PedidoDto dto){
		if(!repositorio.existsById(id)) {
			return Optional.empty();
		}
		Pedido pedidoEntity = dto.toEntity();
		pedidoEntity.setId(id);
		repositorio.save(pedidoEntity);
		return Optional.of(PedidoDto.toDto(pedidoEntity));
	}

	public List<PedidoDto> obterPorSabor(String sabor) {
		List<Pedido> pedidos = repositorio.findByPizzaIgnoreCase(sabor);
		return pedidos.stream().map(p -> PedidoDto.toDto(p)).toList();
	}

	public List<PedidoDto> obterPorCliente(String cliente) {
		List<Pedido> pedidos = repositorio.findByClienteIgnoreCase(cliente);
		return pedidos.stream().map(p -> PedidoDto.toDto(p)).toList();
	}
	
}
