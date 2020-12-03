package br.com.socialBook.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.socialBook.beans.Livro;
import br.com.socialBook.models.LivroModel;
/**
 * Servlet implementation class LivrosController
 */
@WebServlet("/livros")
public class LivrosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		switch (action) {
		case "list":
			listaLivros(request, response);
			break;

		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private void listaLivros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Livro> objListaLivros = new ArrayList<Livro>();
		objListaLivros = LivroModel.listaLivros();
		
		request.setAttribute("objLivros", objListaLivros);
		RequestDispatcher rd = request.getRequestDispatcher("listaLivros.jsp");
		rd.forward(request, response);
		
	}

}
