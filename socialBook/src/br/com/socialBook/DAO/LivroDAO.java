package br.com.socialBook.DAO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.socialBook.beans.Livro;
import br.com.socialBook.cnn.ConnectionFactory;

public class LivroDAO {

	public static List<Livro> listaLivros() {
		Connection cnn = ConnectionFactory.getConnection();
		String query = "SELECT * FROM livro";
		ArrayList<Livro> arLivros = new ArrayList();
		
		
		return null;
	}

}
