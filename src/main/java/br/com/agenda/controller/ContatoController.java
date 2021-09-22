package br.com.agenda.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenda.dto.ContatoInputDto;
import br.com.agenda.model.Contato;
import br.com.agenda.service.ContatoService;

@RestController
@RequestMapping("/contatos")
public class ContatoController {
	
	private final ContatoService contatoService;

	public ContatoController(ContatoService contatoservice) {
		this.contatoService = contatoservice;
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody ContatoInputDto contatoDto) {
		System.out.println(contatoDto);
		Contato contato = contatoService.salvar(contatoDto);
		return ResponseEntity.ok(contato);
	}
	
	@GetMapping("/contatos/{id}")
	public ResponseEntity<?> contatos(@PathVariable Integer id){
		
		Contato contatos =  contatoService.buscarPorId(id);
		return ResponseEntity.ok(contatos);
	}
	
	@GetMapping
	public List<Contato> buscarContatos(){
		return contatoService.buscarContatos();
	} 

}
