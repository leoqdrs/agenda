package br.com.agenda.dto;

public class FormLoginDto {
	
	private String email;
	private String senha;
	
	public FormLoginDto(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}
	
    public String getSenha() {
		return senha;
	}

	@Override
	public String toString() {
		return "FormLoginDto [email=" + email + ", senha=" + senha + "]";
	}
        
}
