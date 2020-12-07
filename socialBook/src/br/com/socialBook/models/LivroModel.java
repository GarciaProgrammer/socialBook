package br.com.socialBook.models;

import java.util.List;

import br.com.socialBook.DAO.LivroDAO;
import br.com.socialBook.beans.Livro;

public class LivroModel {

	public static List<Livro> listaLivros() {
		return LivroDAO.listaLivros();
	}

	public static int cadastraLivro(Livro livroSubmit) {
		return LivroDAO.cadastraLivro(livroSubmit);
	}

}
