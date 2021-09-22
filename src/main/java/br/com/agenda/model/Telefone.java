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
	
	public void setContato(Contato contato) {
		this.contato = contato;		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contato == null) ? 0 : contato.hashCode());
		result = prime * result + ddd;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		if (contato == null) {
			if (other.contato != null)
				return false;
		} else if (!contato.equals(other.contato))
			return false;
		if (ddd != other.ddd)
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	
}