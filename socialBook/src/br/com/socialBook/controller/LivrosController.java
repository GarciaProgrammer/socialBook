package br.com.socialBook.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.socialBook.beans.Categoria;
import br.com.socialBook.beans.Livro;
import br.com.socialBook.models.CategoriaModel;
import br.com.socialBook.models.LivroModel;

/**
 * Servlet implementation class LivrosController
 */
@WebServlet("/livros")
public class LivrosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {
		case "list":
			listaLivros(request, response);
			break;

		case "cad":
			cadastraLivros(request, response);

		default:
			break;
		}
	}

	private void cadastraLivros(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Categoria> listaCat = CategoriaModel.getListCategorias();

		request.setAttribute("listaCat", listaCat);
		// request.setAttribute("usuarioNome", session.getAttribute("nome"));
		RequestDispatcher rd = request.getRequestDispatcher("cadLivros.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = 0;
		
		if ( request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("id"));
		}
		
		int catId = Integer.parseInt(request.getParameter("id_categoria"));
		
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		Categoria cat = new Categoria(catId, "");
		int retorno = 0;
		Livro livroSubmit = new Livro();

		livroSubmit.setTitulo(titulo);
		livroSubmit.setAutor(autor);
		livroSubmit.setCategoria(cat);

		if (id > 0) {
			livroSubmit.setId(id);
			//retorno = LivroModel.updateLivro(livroSubmit);
		} else {
			retorno = LivroModel.cadastraLivro(livroSubmit);
		}
		
		PrintWriter out = response.getWriter();
		
		if (retorno > 0) {
			out.println("<body>");
			out.println("<b>Livro " + titulo + " Criado/Alterado com Sucesso!</b>");
			out.println("<a href='livros?action=list'>Voltar</a>");
			out.println("</body>");
		} else {
			out.println("<body>");
			out.println("<b>Ocorreu um erro, não foi possível alterar/Cadastrar o Livro!</b>");
			out.println("<a href='livros?action=list'>Voltar</a>");
			out.println("</body>");
		}

	}

	private void listaLivros(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Livro> objListaLivros = new ArrayList<Livro>();
		objListaLivros = LivroModel.listaLivros();

		request.setAttribute("objLivros", objListaLivros);
		request.setAttribute("objLivrosSize", objListaLivros.size());
		RequestDispatcher rd = request.getRequestDispatcher("listLivros.jsp");
		rd.forward(request, response);

	}

}
