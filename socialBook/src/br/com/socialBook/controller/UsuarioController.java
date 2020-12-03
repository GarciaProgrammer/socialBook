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

import br.com.socialBook.beans.Usuario;
import br.com.socialBook.models.UsuarioModel;

@WebServlet("/usuario")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		switch (action) {
		case "list":
			listaUsuario(request, response);
			break;

		case "cad":
			cadUsuario(request, response);
			break;

		case "ver":
			verUsuario(request, response);
			break;

		case "edit":
			editUsuario(request, response);
			break;

		case "del":
			delUsuario(request, response);
			break;

		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = 0;
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		if (request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("id"));
		}
		int retorno = 0;
		
		Usuario usuarioSubmit = new Usuario();	
		usuarioSubmit.setLogin(login);
		usuarioSubmit.setNome(nome);
		usuarioSubmit.setSenha(senha);
		
		if (id > 0) {
			usuarioSubmit.setId(id);
		} else {
			retorno = UsuarioModel.addUsuario(usuarioSubmit);
		}
		
		PrintWriter out = response.getWriter();
		
		if (retorno > 0) {
			out.println("<body>");
			out.println("<b>Usuario " + nome + " Criado/Alterado com Sucesso!</b>");
			out.println("<a href='usuario?action=cad'>Voltar</a>");
			out.println("</body>");
		} else {
			out.println("<body>");
			out.println("<b>Ocorreu um erro, não foi possível alterar/Cadastrar o filme!</b>");
			out.println("<a href='usuario?action=cad'>Voltar</a>");
			out.println("</body>");
		}
		
	}

	private void delUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		if (UsuarioModel.delUsuario(id) > 0) {
			response.getWriter().print("OK");
		} else {
			response.getWriter().print("ERRO");
		}
	}

	private void editUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Usuario usuario = UsuarioModel.getUsuarioById(id);

		request.setAttribute("objUsuario", usuario);
		RequestDispatcher rd = request.getRequestDispatcher("editUsuarioAction.jsp");
		rd.forward(request, response);

	}

	private void verUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Usuario usuario = UsuarioModel.getUsuarioById(id);

		request.setAttribute("objUsuario", usuario);
		RequestDispatcher rd = request.getRequestDispatcher("verUsuarioAction.jsp");
		rd.forward(request, response);
	}

	private void cadUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("cadUsuario.jsp");
		rd.forward(request, response);

	}

	private void listaUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Usuario> objListaUsuario = new ArrayList<Usuario>();
		objListaUsuario = UsuarioModel.listaUsuario();

		request.setAttribute("listaUsuarios", objListaUsuario);
		RequestDispatcher rd = request.getRequestDispatcher("verUsuariosAction.jsp");
		rd.forward(request, response);

	}

}
