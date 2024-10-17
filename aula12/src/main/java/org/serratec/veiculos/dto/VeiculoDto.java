package org.serratec.veiculos.dto;

import java.util.List;

import org.serratec.veiculos.model.Cor;
import org.serratec.veiculos.model.Marca;
import org.serratec.veiculos.model.TipoCombustivel;
import org.serratec.veiculos.model.Veiculo;

public record VeiculoDto(
		Long id,
		Marca marca,
		String modelo,
		Cor cor,
		int anoFabricacao,
		TipoCombustivel tipoCombustivel,
		ProprietarioDto proprietario,
		List<AcessorioDto> acessorios,
		List<ConcessionariaDto> concessionarias) {
	
	public Veiculo toEntity() {
		Veiculo veiculo = new Veiculo();
		veiculo.setId(this.id);
		veiculo.setMarca(this.marca);
		veiculo.setModelo(this.modelo);
		veiculo.setCor(this.cor);
		veiculo.setAnoFabricacao(this.anoFabricacao);
		veiculo.setTipoCombustivel(this.tipoCombustivel);
		veiculo.setProprietario(this.proprietario.toEntity());
		veiculo.setAcessorios(this.acessorios.stream().map(a -> a.toEntity()).toList());
		veiculo.setConcessionarias(this.concessionarias.stream().map(c -> c.toEntity()).toList());
		return veiculo;
		
	}
	
	public static VeiculoDto toDto(Veiculo veiculo) {
		return new VeiculoDto(veiculo.getId(), veiculo.getMarca(),
				veiculo.getModelo(), veiculo.getCor(), veiculo.getAnoFabricacao(),
				veiculo.getTipoCombustivel(), ProprietarioDto.toDto(veiculo.getProprietario()),
				veiculo.getAcessorios().stream().map(a -> AcessorioDto.toDto(a)).toList(), 
				veiculo.getConcessionarias().stream().map(c -> ConcessionariaDto.toDto(c)).toList());
	}
}
