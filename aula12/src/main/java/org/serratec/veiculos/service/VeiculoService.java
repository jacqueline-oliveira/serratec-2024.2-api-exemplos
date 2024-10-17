package org.serratec.veiculos.service;

import java.util.List;
import java.util.Optional;

import org.serratec.veiculos.dto.VeiculoDto;
import org.serratec.veiculos.model.Veiculo;
import org.serratec.veiculos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {
	@Autowired
	private VeiculoRepository repositorio;

	public VeiculoDto salvarVeiculo(VeiculoDto veiculo) {
		return VeiculoDto.toDto(repositorio.save(veiculo.toEntity()));
	}

	public Optional<VeiculoDto> modificarVeiculo(Long id, VeiculoDto veiculo) {
		if (!repositorio.existsById(id)) {
			return Optional.empty();
		}
		Veiculo veiculoEntity = veiculo.toEntity();
		veiculoEntity.setId(id);
		return Optional.of(VeiculoDto.toDto(repositorio.save(veiculoEntity)));
	}

	public boolean apagarVeiculo(Long id) {
		if (!repositorio.existsById(id)) {
			return false;
		}
		repositorio.deleteById(id);
		return true;
	}

	public List<VeiculoDto> buscarTodos() {
		return repositorio.findAll().stream().map(v -> VeiculoDto.toDto(v)).toList();
	}

	public Optional<VeiculoDto> buscarPorId(Long id) {
		if (!repositorio.existsById(id)) {
			return Optional.empty();
		}
		return Optional.of(VeiculoDto.toDto(repositorio.findById(id).get()));
	}

}
