package org.serratec.doces;

import java.util.ArrayList;
import java.util.List;

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
	List<Doces> doces = new ArrayList<>();
	
	@GetMapping
	public List<Doces> obterTodos() {
		return doces;
	}
	
	@PostMapping
	public Doces cadastrarDoce(@RequestBody Doces doce) {
		doces.add(doce);
		return doce;
	}
	
	@DeleteMapping("/{nome}")
	public void excluirDoce(@PathVariable String nome) {
		doces.removeIf(d -> d.getNome().equalsIgnoreCase(nome));
	}
	
	@PutMapping("/{nome}")
	public Doces alterarDoce(@PathVariable String nome, @RequestBody Doces doce) {
		for(int i=0; i < doces.size(); i++) {
			if (doces.get(i).getNome().equalsIgnoreCase(nome)) {
				doces.set(i, doce);
				return doces.get(i);
			}
		}
		
		return null;
	}
	

}
