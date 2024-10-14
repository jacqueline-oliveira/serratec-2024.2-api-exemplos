package org.serratec.veiculos.service;

import java.util.List;
import java.util.Optional;

import org.serratec.veiculos.model.Veiculo;
import org.serratec.veiculos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {
	@Autowired 
	private VeiculoRepository repositorio;
	
	public Veiculo salvarVeiculo(Veiculo veiculo) {
		return repositorio.save(veiculo);
	}
		
	public Optional<Veiculo> modificarVeiculo(Long id, Veiculo veiculo) {
		if(!repositorio.existsById(id)) {
			return Optional.empty();
		}
		veiculo.setId(id);
		return Optional.of(repositorio.save(veiculo));	
	}
	
	public boolean apagarVeiculo(Long id) {
		if(!repositorio.existsById(id)) {
			return false;
		}
		repositorio.deleteById(id);
		return true;
	}
	
	public List<Veiculo> buscarTodos(){
		return repositorio.findAll();
	}
	
	public Optional<Veiculo> buscarPorId(Long id) {
		if (!repositorio.existsById(id)) {
			return Optional.empty();
		}
		return Optional.of(repositorio.findById(id).get());
	}

}
