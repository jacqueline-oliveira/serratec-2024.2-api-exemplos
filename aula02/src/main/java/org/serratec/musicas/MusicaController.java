package org.serratec.musicas;

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
@RequestMapping("/musicas")
public class MusicaController {
	List<Musica> musicas = new ArrayList<>();
	
	@GetMapping
	public List<Musica> obterMusica() {
		return musicas;
	}
	
	@PostMapping("/lista")
	public List<Musica> cadastrarMusicas(@RequestBody List<Musica> musica) {
		musicas.addAll(musica);
		return musica;
	}
	
	@PostMapping
	public Musica cadastrarMusica(@RequestBody Musica musica) {
		musicas.add(musica);
		return musica;
	}
	
//	@GetMapping("/{nome}")
//	public String obterSaudacao(@PathVariable String nome) {
//		return String.format("Olá %s, boas vindas ao site!", nome);
//	}
	
	@GetMapping("/{nome}")
	public Musica obterMusicaPorNome(@PathVariable String nome) {
		for(Musica m : musicas) {
			if (m.getNome().equalsIgnoreCase(nome)) {
				return m;
			}
		}
		return null;
	}
	
	@DeleteMapping("/{nome}")
	public void excluirMusica(@PathVariable String nome) {
		musicas.removeIf(m -> m.getNome().equalsIgnoreCase(nome));	
	}
	
	@PutMapping("/{nome}")
	public Musica alterarMusica(@PathVariable String nome, @RequestBody Musica musica) {
		for(int i=0; i < musicas.size(); i++) {
			if (musicas.get(i).getNome().equalsIgnoreCase(nome)) {
				musicas.set(i, musica);
				return musicas.get(i);
			}	
		}
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	

}
