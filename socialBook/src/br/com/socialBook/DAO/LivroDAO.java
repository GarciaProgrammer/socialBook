package br.com.socialBook.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp2.PStmtKey;

import br.com.socialBook.beans.Categoria;
import br.com.socialBook.beans.Livro;
import br.com.socialBook.cnn.ConnectionFactory;

public class LivroDAO {

	public static List<Livro> listaLivros() {
		Connection cnn = ConnectionFactory.getConnection();
		ArrayList<Livro> arLivros = new ArrayList<Livro>();
		String query = "SELECT l.id, l.titulo, l.autor, l.id_categoria, c.titulo categoria FROM livros l, categoria c WHERE l.id_categoria = c.id";
		
		try {
			PreparedStatement pStmt = cnn.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				Categoria categoria = new Categoria(rs.getInt("id_categoria"), rs.getString("categoria"));
				Livro livro = new Livro(rs.getInt("id"), categoria, rs.getString("titulo"), rs.getString("autor"));
				arLivros.add(livro);
			}
			rs.close();
			cnn.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arLivros;
	}

	public static int cadastraLivro(Livro livroSubmit) {
		String query = "INSERT INTO livros (titulo, autor, id_categoria) VALUES (?, ?, ?)";
		Connection cnn = ConnectionFactory.getConnection();
		int linhasAfetadas = 0;
		
		try {
			PreparedStatement pStmt = cnn.prepareStatement(query);
			pStmt.setString(1, livroSubmit.getTitulo());
			pStmt.setString(2, livroSubmit.getAutor());
			pStmt.setInt(3, livroSubmit.getCategoria().getId());
			linhasAfetadas = pStmt.executeUpdate();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return linhasAfetadas;
	}

}
