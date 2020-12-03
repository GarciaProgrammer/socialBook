package br.com.socialBook.models;

import java.util.ArrayList;

import br.com.socialBook.DAO.UsuarioDAO;
import br.com.socialBook.beans.Usuario;

public class UsuarioModel {



	public static ArrayList<Usuario> listaUsuario() {
		return UsuarioDAO.listaUsuarios();
	}

	public static Usuario getUsuarioById(int id) {
		return UsuarioDAO.getUsuarioById(id);
	}

	public static int delUsuario(int id) {
		return UsuarioDAO.delUsuario(id);
	}

	public static int addUsuario(Usuario usuarioSubmit) {
		return UsuarioDAO.addUsuario(usuarioSubmit);
	}

}
