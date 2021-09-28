package br.com.agenda.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.agenda.dto.ContatoInputDto;
import br.com.agenda.model.Contato;
import br.com.agenda.model.Email;
import br.com.agenda.model.Endereco;
import br.com.agenda.model.Telefone;
import br.com.agenda.service.ContatoService;

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
    
    @PutMapping("salvar/{id}/foto")
    public ResponseEntity<?> uploadPhoto(
            @PathVariable Integer id,
            @RequestBody MultipartFile foto
            )
    {
        File file = new File("C:\\Users\\leoqd\\Downloads\\"+foto.getOriginalFilename());
        try {
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(foto.getBytes());
            fileOutputStream.close();
            String enderecofoto=file.getAbsolutePath();
            contatoService.salvarFoto(id,enderecofoto);
            return ResponseEntity.ok().body("Foto adicionada");
        }catch (IOException e){
            e.printStackTrace();

            return ResponseEntity.ok().body("Erro ao adicionar foto");
        }


    }

}
