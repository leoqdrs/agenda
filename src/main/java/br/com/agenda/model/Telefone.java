package br.com.agenda.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Telefone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contato_id")
	private Contato contato;
	@Enumerated(EnumType.STRING)
	private TipoTelefone tipo;
	private int ddd;
	private String numero;
	
	public Telefone(TipoTelefone tipo, int ddd, String numero) {
		this.tipo = tipo;
		this.ddd = ddd;
		this.numero = numero;
	}

	public Telefone() {
	}

	public Integer getId() {
		return id;
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