package org.serratec.pizzaria.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.pizzaria.dto.PedidoDto;
import org.serratec.pizzaria.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	@Autowired
	private PedidoService servico;

	@GetMapping
	public List<PedidoDto> obterTodos() {
		return servico.obterTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<PedidoDto> obterPorId(@PathVariable Long id) {
		Optional<PedidoDto> dto = servico.obterPorId(id);
		if (!dto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(dto.get());
	}
	
	@GetMapping("/sabor/{sabor}")
	public List<PedidoDto> obterPorId(@PathVariable String sabor) {
		return servico.obterPorSabor(sabor);
	}
	
	@GetMapping("/cliente/{cliente}")
	public List<PedidoDto> obterPorCliente(@PathVariable String cliente) {
		return servico.obterPorCliente(cliente);
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PedidoDto cadastrarPedido(@RequestBody PedidoDto dto) {
		return servico.salvarPedido(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletaPedido(@PathVariable Long id){
		if(!servico.apagarPedido(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<PedidoDto> alterarPedido(@PathVariable Long id, @RequestBody PedidoDto dto){
		Optional<PedidoDto> pedidoAlterado = servico.alterarPedido(id, dto);
		if (!pedidoAlterado.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pedidoAlterado.get());
	}
}
	


