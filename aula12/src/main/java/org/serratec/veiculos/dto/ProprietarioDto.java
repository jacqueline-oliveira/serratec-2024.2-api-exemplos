package org.serratec.veiculos.dto;

import org.serratec.veiculos.model.Proprietario;

public record ProprietarioDto(
		 Long id,
		 String nome,
		 String cnh,
		 String telefone) {
	
	public Proprietario toEntity() {
		Proprietario proprietario = new Proprietario();
		proprietario.setId(this.id);
		proprietario.setNome(this.nome);
		proprietario.setCnh(this.cnh);
		proprietario.setTelefone(this.telefone);
		return proprietario;
	}
	
	public static ProprietarioDto toDto(Proprietario proprietario) {
		return new ProprietarioDto(proprietario.getId(), proprietario.getNome(),
				proprietario.getCnh(), proprietario.getTelefone());
	}

}
