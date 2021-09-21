package br.com.agenda.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import br.com.agenda.dto.ContatoInputDto;
import br.com.agenda.model.Contato;
import br.com.agenda.repository.ContatoRepository;

@Service
public class ContatoService {
	
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
	
}