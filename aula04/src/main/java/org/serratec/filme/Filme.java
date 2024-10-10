package org.serratec.filme;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
public class Filme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(min=2, message = "O nome do filme deve ter pelo menos 2 caracteres")
	private String nome;
	@Enumerated(EnumType.STRING)
	private Genero genero;
	@NotNull
	@Past(message="A data de lançamento do filme deve ser inferior ao dia de hoje")
	private LocalDate anoLancamento;
	
	//cascade all replica todas as operações em cascata (cadastro, exclsão, etc)
	//cascade persist por exemplo persiste o diretor, mas ao apagar o filme não apaga o diretor
	@OneToOne(cascade = CascadeType.ALL)
	private Diretor diretor;
	
	@OneToMany(mappedBy = "filme", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Ator> atores;
	
	public List<Ator> getAtores() {
		return atores;
	}
	public void setAtores(List<Ator> atores) {
		atores.forEach(a -> a.setFilme(this));
		this.atores = atores;
	}
	public Diretor getDiretor() {
		return diretor;
	}
	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public LocalDate getAnoLancamento() {
		return anoLancamento;
	}
	public void setAnoLancamento(LocalDate anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	
	
}

