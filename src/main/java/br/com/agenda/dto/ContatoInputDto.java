package br.com.agenda.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.model.Contato;
import br.com.agenda.model.Endereco;
import br.com.agenda.model.Telefone;

public class ContatoInputDto {
	private String nome;
	private String sobrenome;
	private LocalDate dataNascimento;
	private String apelido;
	private TelefoneDtoInput telefone;
	private EnderecoDtoInput endereco;
    private String email;
    
	public ContatoInputDto(String nome, String sobrenome, LocalDate dataNascimento, String apelido,
			TelefoneDtoInput telefone, EnderecoDtoInput endereco, String email) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.apelido = apelido;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getApelido() {
		return apelido;
	}

	public TelefoneDtoInput getTelefone() {
		return telefone;
	}

	public EnderecoDtoInput getEndereco() {
		return endereco;
	}

	public String getEmail() {
		return email;
	}
	
	public Contato getContato() {
		Telefone telefone = new Telefone(this.telefone.getTipo(), this.telefone.getDdd(), this.telefone.getNumero());
		Endereco endereco = new Endereco(this.endereco.getRua(), this.endereco.getNumero(), this.endereco.getCidade());
		return new Contato(nome, sobrenome, dataNascimento, apelido, telefone, endereco, email);
	}	
	
}
