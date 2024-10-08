package org.serratec.filme;

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
@RequestMapping("/filmes")
public class FilmeController {
	@Autowired 
	private FilmeRepository repositorio;
	
	@GetMapping
	public List<Filme> obterTodos(){
		return repositorio.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Filme> obterPorId(@PathVariable Long id) {
		if(!repositorio.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(repositorio.findById(id).get());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Filme cadastrarFilme(@RequestBody @Valid Filme filme) {
		return repositorio.save(filme);
	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirFilme(@PathVariable Long id) {
		if(!repositorio.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		repositorio.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Filme> alterarFilme(@PathVariable Long id, @RequestBody @Valid Filme filme) {
		if(!repositorio.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
			
		filme.setId(id);
		repositorio.save(filme);
		return ResponseEntity.ok(filme);
	}
	
	
	
	
	
	
	
	
}
