package br.com.agenda.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.model.Contato;
import br.com.agenda.model.Email;
import br.com.agenda.model.Endereco;
import br.com.agenda.model.Telefone;

public class ContatoInputDto {
	private String nome;
	private String sobrenome;
	private LocalDate dataNascimento;
	private String apelido;
	private List<Telefone> telefones = new ArrayList<>();
	private List<Endereco> enderecos = new ArrayList<>();
    private List<Email> emails = new ArrayList<>();
    
	public ContatoInputDto(String nome, String sobrenome, LocalDate dataNascimento, String apelido,
			List<Telefone> telefones, List<Endereco> enderecos, List<Email> emails) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.apelido = apelido;
		this.telefones = telefones;
		this.enderecos = enderecos;
		this.emails = emails;
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

	public List<Telefone> getTelefone() {
		return telefones;
	}

	public List<Endereco> getEndereco() {
		return enderecos;
	}

	public List<Email> getEmail() {
		return emails;
	}
	
	public Contato getContato() {
		Contato contato = new Contato(nome, sobrenome, dataNascimento, apelido);
		return contato;
	}	
}
