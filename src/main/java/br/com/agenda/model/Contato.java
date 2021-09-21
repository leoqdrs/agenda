package br.com.agenda.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String sobrenome;
	private LocalDate dataNascimento;
	private String apelido;
	@JsonManagedReference
    @OneToMany(mappedBy = "contato", cascade = CascadeType.ALL)
    private List<Telefone> telefone = new ArrayList<>();
	@JsonManagedReference
    @OneToMany(mappedBy = "contato", cascade = CascadeType.ALL)
    private List<Endereco> endereco = new ArrayList<>();
    private String email;
    


	public Contato(String nome, String sobrenome, LocalDate dataNascimento, String apelido, List<Telefone> telefone,
			List<Endereco> endereco, String email) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.apelido = apelido;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
	}
	
	public Contato() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
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
		return telefone;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Contato other = (Contato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
      

}
