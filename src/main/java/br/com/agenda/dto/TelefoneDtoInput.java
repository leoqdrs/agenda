package br.com.agenda.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.agenda.model.TipoTelefone;

public class TelefoneDtoInput {

	@Enumerated(EnumType.STRING)
	private TipoTelefone tipo;
	private int ddd;
	private String numero;
	
	public TelefoneDtoInput(TipoTelefone tipo, int ddd, String numero) {
		this.tipo = tipo;
		this.ddd = ddd;
		this.numero = numero;
	}

	public TipoTelefone getTipo() {
		return tipo;
	}

	public int getDdd() {
		return ddd;
	}

	public String getNumero() {
		return numero;
	}	

}
