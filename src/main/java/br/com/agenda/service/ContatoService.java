package br.com.agenda.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agenda.dto.ContatoInputDto;
import br.com.agenda.model.Contato;
import br.com.agenda.model.Email;
import br.com.agenda.model.Endereco;
import br.com.agenda.model.Telefone;
import br.com.agenda.repository.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired
	private final ContatoRepository contatoRepository;

	public ContatoService(ContatoRepository contatoRepository) {
		this.contatoRepository = contatoRepository;
	}
	
	public Contato salvar(ContatoInputDto contatoDto) {
		Contato contato = contatoDto.getContato();
		return contatoRepository.save(contato);
	}

	public Contato buscarPorId(Integer contatoId) {
		return contatoRepository.findById(contatoId)
				.orElseThrow(() -> new EntityNotFoundException("Contato com id " + contatoId + " não encontrado"));
	}

	public List<Contato> buscarContatos() {
		return contatoRepository.findAll();
	}
	
    public Contato adicionaTelefoneContato(Integer id, Telefone telefone) {
        Contato contato = contatoRepository.getById(id);
        telefone.setContato(contato);
        contato.adicionaTelefone(telefone);
        return contatoRepository.save(contato);
    }

    public Contato adicionaEnderecoContato(Integer id, Endereco endereco) {
        Contato contato = contatoRepository.getById(id);
        endereco.setContato(contato);
        contato.adicionaEndereco(endereco);
        return contatoRepository.save(contato);
    }

    public Contato adicionaEmailContato(Integer id, Email email) {
        Contato contato = contatoRepository.getById(id);
        email.setContato(contato);
        contato.adicionaEmail(email);
        return contatoRepository.save(contato);
    }
	
    public Contato salvarFoto(Integer id, String foto) {
        Contato contato = contatoRepository.getById(id);
        contato.setFoto(foto);
        return contatoRepository.save(contato);
    }
    
    public void deletaContato(Integer id) {
        contatoRepository.delete(contatoRepository.getById(id));
    }

	public List<Contato> searchByContato(String nome, String sobrenome, LocalDate dataNascimento) {
		return contatoRepository.searchByContato(nome, sobrenome, dataNascimento);
	}
	
}