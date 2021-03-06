package br.com.agenda.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.agenda.model.Usuario;
import br.com.agenda.repository.UsuarioRepository;
import br.com.agenda.service.TokenService;

public class JwtTokenFilter extends OncePerRequestFilter {
	
	private TokenService tokenService;
	//private AutenticacaoService autenticacaoService;
	private UsuarioRepository usuarioRepository;
	
	public JwtTokenFilter(TokenService tokenService, UsuarioRepository usuarioRepository) {
		this.tokenService = tokenService;
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = getToken(request);
		if(tokenService.validaToken(token)) {
			autenticaUsuario(token);
		}
		System.out.println(token);
		filterChain.doFilter(request, response);
	}

	private void autenticaUsuario(String token) {
		Integer idUsuario = tokenService.getUsuarioId(token);
		Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario,null,usuario.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
	}

	private String getToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if(token==null|| token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		System.out.println(token);
		return token.substring(7);
    }

}
