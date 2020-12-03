package br.com.socialBook.beans;

public class Usuario {

	private long id;
	private String nome, login, senha, status;
	
	public Usuario () {
		
	}
	
	public Usuario(long id, String nome, String login, String senha, String status) {
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.status = status;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
