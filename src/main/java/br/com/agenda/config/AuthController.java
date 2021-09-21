package br.com.agenda.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenda.dto.FormLoginDto;
import br.com.agenda.dto.TokenDto;
import br.com.agenda.service.TokenService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	TokenService tokenService;
		
	@PostMapping
	public ResponseEntity<TokenDto> autentica(@RequestBody FormLoginDto formlogindto){
		Authentication authenticate = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(formlogindto.getEmail(), formlogindto.getSenha()));
		
		String token = tokenService.geraToken(authenticate);
		return ResponseEntity.ok(new TokenDto(token, "Bearer"));
	}
}
