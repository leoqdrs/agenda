package br.com.agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenda.model.Usuario;
import br.com.agenda.repository.UsuarioRepository;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@PreAuthorize("hasRole('ROLE_ADM') and hasRole('ROLE_USUARIO')")
	@GetMapping
	public List<Usuario> buscarTodos(){
		return usuarioRepository.findAll();
	}
}
