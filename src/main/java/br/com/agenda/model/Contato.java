package br.com.agenda.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
    private List<Telefone> telefones = new ArrayList<>();
	@JsonManagedReference
    @OneToMany(mappedBy = "contato", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();
    private String email;
    


	public Contato(String nome, String sobrenome, LocalDate dataNascimento, String apelido, List<Telefone> telefones,
			List<Endereco> enderecos, String email) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.apelido = apelido;
		this.telefones = telefones;
		this.enderecos = enderecos;
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
		return telefones;
	}

	public List<Endereco> getEndereco() {
		return enderecos;
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

	public void setEnderecos(Collection<Endereco> enderecos) {
		enderecos.forEach(e -> adicionaEndereco(e));
	}

	public void adicionaEndereco(Endereco endereco) {
		endereco.setContato(this);
		this.enderecos.add(endereco);
	}

	public List<Endereco> getEnderecos() {
		return Collections.unmodifiableList(enderecos);
	}


	public void setTelefones(Collection<Telefone> telefones) {
		telefones.forEach(t -> adicionaTelefone(t));
	}

	public void adicionaTelefone(Telefone telefone) {
		telefone.setContato(this);
		this.telefones.add(telefone);
	}

	public List<Telefone> getTelefones() {
		return Collections.unmodifiableList(telefones);
	}
      

}
