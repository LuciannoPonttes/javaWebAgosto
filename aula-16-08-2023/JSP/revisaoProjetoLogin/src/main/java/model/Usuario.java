package model;

public class Usuario {

	private String nome;
	private String senha;
	private String perfil;
	
	public Usuario() {
		
	}
	
	public Usuario(String nome, String senha, String perfil) {
		this.nome = nome;
		this.senha = senha;
		this.perfil = perfil;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String pefil) {
		this.perfil = pefil;
	}
	
	
	
	
	
	
	
}
