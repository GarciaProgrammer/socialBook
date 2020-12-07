package br.com.socialBook.beans;

import java.io.Serializable;

public class Livro implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Categoria categoria;
	private String titulo;
	private String autor;
	
	public Livro() {}
	
	
	public Livro(int id, Categoria categoria, String titulo, String autor) {
		this.id = id;
		this.categoria = categoria;
		this.titulo = titulo;
		this.autor = autor;
	}

	public Livro(String titulo, String autor, Categoria categoria) {
		this.titulo = titulo;
		this.autor = autor;
		this.categoria = categoria;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Categoria getCategoria() {
		return categoria;
	}



	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getAutor() {
		return autor;
	}



	public void setAutor(String autor) {
		this.autor = autor;
	}



	
	

}
