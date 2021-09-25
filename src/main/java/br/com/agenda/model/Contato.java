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

@Entity
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String sobrenome;
	private LocalDate dataNascimento;
	private String apelido;

	@OneToMany(mappedBy = "contato", cascade = CascadeType.ALL)
    private List<Telefone> telefones = new ArrayList<>();

	@OneToMany(mappedBy = "contato", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();

	@OneToMany(mappedBy = "contato", cascade = CascadeType.ALL)
    private List<Email> emails = new ArrayList<>();
    


	public Contato(String nome, String sobrenome, LocalDate dataNascimento, String apelido) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.apelido = apelido;
	}
	
	public Contato() {
		
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

	public void setEnderecos(Collection<Endereco> enderecos) {
		enderecos.forEach(e -> adicionaEndereco(e));
	}

	public Endereco adicionaEndereco(Endereco endereco) {
		endereco.setContato(this);
		this.enderecos.add(endereco);
		return endereco;
	}

	public List<Endereco> getEnderecos() {
		return Collections.unmodifiableList(enderecos);
	}


	public void setTelefones(Collection<Telefone> telefones) {
		telefones.forEach(t -> adicionaTelefone(t));
	}

	public Telefone adicionaTelefone(Telefone telefone) {
		telefone.setContato(this);
		this.telefones.add(telefone);
		return telefone;
	}

	public List<Telefone> getTelefones() {
		return Collections.unmodifiableList(telefones);
	}
    
	public void setEmails(Collection<Email> emails) {
		emails.forEach(m -> adicionaEmail(m));
	}

	public Email adicionaEmail(Email email) {
		email.setContato(this);
		this.emails.add(email);
		return email;
	}

	public List<Email> getEmails() {
		return Collections.unmodifiableList(emails);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
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
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		return true;
	}
	

}
