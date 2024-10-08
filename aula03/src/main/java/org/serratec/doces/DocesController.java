package org.serratec.doces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/doces")
public class DocesController {
	@Autowired
	private DocesRepository repositorio;
	
	
	@GetMapping
	public List<Doces> obterTodos() {
		return repositorio.findAll();
	}
	
	@GetMapping("/{id}")
	public Doces obterPorId(@PathVariable Long id) {
		return repositorio.findById(id).orElse(null);
	}
	
	@PostMapping
	public Doces cadastrarDoce(@RequestBody Doces doce) {
		return repositorio.save(doce);
	}
	
	@DeleteMapping("/{id}")
	public void excluirDoce(@PathVariable Long id) {
		repositorio.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Doces alterarDoce(@PathVariable Long id, @RequestBody Doces doce) {
		if (repositorio.existsById(id)) {
			doce.setId(id);
			repositorio.save(doce);
			return doce;
		}
		
		return null;
	}
		
}
