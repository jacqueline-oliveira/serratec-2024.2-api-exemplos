package org.serratec.veiculos.model;

public record ConcessionariaDto(
		 Long id,
		 String nome,
		 Endereco endereco) {
	
	public Concessionaria toEntity() {
		Concessionaria concessionaria = new Concessionaria();
		concessionaria.setId(this.id);
		concessionaria.setNome(this.nome);
		concessionaria.setEndereco(this.endereco);
		return concessionaria;
	}
	
	public static ConcessionariaDto toDto(Concessionaria concessionaria) {
		return new ConcessionariaDto(concessionaria.getId(),
				concessionaria.getNome(), concessionaria.getEndereco());
	}

}
