package org.serratec.veiculos.model;

public record AcessorioDto(
		 Long id,
		 String descricao,
		 String informacao) {
	
	public Acessorio toEntity() {
		Acessorio acessorio = new Acessorio();
		acessorio.setId(this.id);
		acessorio.setDescricao(this.descricao);
		acessorio.setInformacao(this.informacao);
		return acessorio;
	}
	
	public static AcessorioDto toDto(Acessorio acessorio) {
		return new AcessorioDto(acessorio.getId(), acessorio.getDescricao(),
				acessorio.getInformacao());
	}

}
