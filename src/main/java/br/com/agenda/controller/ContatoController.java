package br.com.agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.agenda.model.Email;
import br.com.agenda.model.Endereco;
import br.com.agenda.model.Telefone;
import br.com.agenda.service.ContatoService;
import br.com.agenda.service.EmailService;

@RestController
@RequestMapping("/contatos")
public class ContatoController {
	
    @Autowired
    ContatoService contatoService;

	public ContatoController(ContatoService contatoservice) {
		this.contatoService = contatoservice;
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody ContatoInputDto contatoDto) {
		Contato contato = contatoService.salvar(contatoDto);
		return ResponseEntity.ok(contato);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> contatos(@PathVariable Integer id){
		Contato contatos =  contatoService.buscarPorId(id);
		return ResponseEntity.ok(contatos);
	}
	
	@GetMapping
	public List<Contato> buscarContatos(){
		return contatoService.buscarContatos();
	} 
	
	@PostMapping("salvar/{id}/telefone")
    public ResponseEntity<?> adicionaTelefone(
            @PathVariable Integer id,
            @RequestBody Telefone telefone){
    	return  ResponseEntity.ok().body(contatoService.adicionaTelefoneContato(id,telefone));
    }

    @PostMapping("salvar/{id}/endereco")
    public ResponseEntity<?> adicionaEndereco(
            @PathVariable Integer id,
            @RequestBody Endereco endereco){
    	return  ResponseEntity.ok().body(contatoService.adicionaEnderecoContato(id,endereco));
    }

    @PostMapping("salvar/{id}/email")
    public ResponseEntity<?> adicionaTelefone(
            @PathVariable Integer id,
            @RequestBody Email email){
    	return  ResponseEntity.ok().body(contatoService.adicionaEmailContato(id,email));
    }

}
