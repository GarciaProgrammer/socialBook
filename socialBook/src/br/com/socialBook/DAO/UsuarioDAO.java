package br.com.socialBook.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.socialBook.beans.Usuario;
import br.com.socialBook.cnn.ConnectionFactory;

public class UsuarioDAO {

	public static ArrayList<Usuario> listaUsuarios() {
		Connection cnn = ConnectionFactory.getConnection();
		String query = "SELECT * FROM usuario";
		ArrayList<Usuario> arUsuario = new ArrayList();
		
		try {
			PreparedStatement pStmt = cnn.prepareStatement(query);
			ResultSet rsUsuario = pStmt.executeQuery();
			
			while (rsUsuario.next()) {
				Usuario usuario = new Usuario(rsUsuario.getLong("id"), rsUsuario.getString("nome"), rsUsuario.getString("login"), rsUsuario.getString("senha"), rsUsuario.getString("status"));
				arUsuario.add(usuario);
			}
			cnn.close();
			rsUsuario.close();
			return arUsuario;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static Usuario getUsuarioById(int id) {
		
		String query = "SELECT * FROM usuario WHERE id = ?";
		Connection cnn = ConnectionFactory.getConnection();
		Usuario usuarioRetorno = new Usuario();
		
		try {
			PreparedStatement pStmt = cnn.prepareStatement(query);
			pStmt.setInt(1, id);
			
			ResultSet rsUsuario = pStmt.executeQuery();
			
			while (rsUsuario.next()) {
				usuarioRetorno.setId(id);
				usuarioRetorno.setNome(rsUsuario.getString("nome"));
				usuarioRetorno.setLogin(rsUsuario.getString("login"));
				usuarioRetorno.setSenha(rsUsuario.getString("senha"));
				usuarioRetorno.setStatus(rsUsuario.getString("status"));
			}
			
			rsUsuario.close();
			cnn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return usuarioRetorno;
	}

	public static int delUsuario(int id) {
		String query = "DELETE FROM usuario WHERE id = ?";
		Connection cnn = ConnectionFactory.getConnection();
		int retorno = 0;
		
		try {
			PreparedStatement pStmt = cnn.prepareStatement(query);
			pStmt.setInt(1, id);
			retorno = pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return retorno;
	}

	public static int addUsuario(Usuario usuarioSubmit) {
		String query = "INSERT INTO usuario (nome, login, senha) VALUES (?, ?, ?)";
		Connection cnn = ConnectionFactory.getConnection();
		int linhasAfetadas = 0;
		
		try {
			PreparedStatement pStmt = cnn.prepareStatement(query);
			pStmt.setString(1, usuarioSubmit.getNome());
			pStmt.setString(2, usuarioSubmit.getLogin());
			pStmt.setString(3, usuarioSubmit.getSenha());
			linhasAfetadas = pStmt.executeUpdate();
			cnn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return linhasAfetadas;
	}

}
