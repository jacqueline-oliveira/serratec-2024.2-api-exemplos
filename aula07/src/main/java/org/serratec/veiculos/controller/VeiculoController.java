package org.serratec.veiculos.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.veiculos.model.Veiculo;
import org.serratec.veiculos.service.VeiculoService;
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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	@Autowired
	private VeiculoService servico;
	
	@GetMapping
	public List<Veiculo> obterTodos(){
		return servico.buscarTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> obterPorId(@PathVariable Long id) {
		Optional<Veiculo> veiculo = servico.buscarPorId(id);
		
		if(!veiculo.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(veiculo.get());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo cadastrarVeiculo(@RequestBody @Valid Veiculo veiculo) {
		return servico.salvarVeiculo(veiculo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirVeiculo(@PathVariable Long id) {
		if(!servico.apagarVeiculo(id)) {
			return ResponseEntity.notFound().build();
		}
		
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Veiculo> alterarVeiculo(@PathVariable Long id, 
			@RequestBody @Valid Veiculo veiculo) {
		
		Optional<Veiculo> veiculoAlterado = servico.modificarVeiculo(id, veiculo);
		
		if(!veiculoAlterado.isPresent()) {
			return ResponseEntity.notFound().build();
		}
			
		
		return ResponseEntity.ok(veiculoAlterado.get());
	}
	

}
