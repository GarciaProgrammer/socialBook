package br.com.socialBook.models;

import java.util.List;

import br.com.socialBook.DAO.CategoriaDAO;
import br.com.socialBook.beans.Categoria;

public class CategoriaModel {

	public static List<Categoria> getListCategorias() {
		return CategoriaDAO.getListCategorias();
	}

}
