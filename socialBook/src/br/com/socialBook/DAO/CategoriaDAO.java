package br.com.socialBook.DAO;

import java.util.ArrayList;
import java.util.List;

import br.com.socialBook.beans.Categoria;

public class CategoriaDAO {

	public static List<Categoria> getListCategorias() {
		List<Categoria> listCat = new ArrayList<Categoria>();

		listCat.add(new Categoria(1, "BestSeller"));
		listCat.add(new Categoria(2, "Economia"));
		listCat.add(new Categoria(3, "Auto Ajuda"));
		return listCat;

	}
}
