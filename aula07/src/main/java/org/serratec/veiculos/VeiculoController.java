package org.serratec.veiculos;

import java.util.List;

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
	private VeiculoRepository repositorio;
	
	@GetMapping
	public List<Veiculo> obterTodos(){
		return repositorio.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> obterPorId(@PathVariable Long id) {
		if(!repositorio.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(repositorio.findById(id).get());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo cadastrarVeiculo(@RequestBody @Valid Veiculo veiculo) {
		return repositorio.save(veiculo);
	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirVeiculo(@PathVariable Long id) {
		if(!repositorio.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		repositorio.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Veiculo> alterarVeiculo(@PathVariable Long id, 
			@RequestBody @Valid Veiculo veiculo) {
		if(!repositorio.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
			
		veiculo.setId(id);
		repositorio.save(veiculo);
		return ResponseEntity.ok(veiculo);
	}
	

}
