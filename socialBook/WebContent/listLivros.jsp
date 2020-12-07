<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="inc/header.jsp"></jsp:include>

<div class="my-4">
	<h1>Biblioteca de Livros</h1>
	<hr>
</div>
<div class="d-flex justify-content-center">
	<table class="table table-hover">
		<thead>
			<tr>
				<th colspan="4">
					<div class="form form-inline">
						<div class="form-group">
							<label for="filtro">Filtro: </label> <input type="text"
								name="filtro" id="filtro" class="form-control col ml-1">
						</div>
						<div class="form-group ml-4">
							<input type="radio" name="rel" id="rel-lido" value="1"
								class="form-control col"> <label for="filtro"><i
								class="fas fa-book"></i> </label> <input type="radio" name="rel"
								id="rel-interesse" value="2" class="form-control col ml-2">
							<label for="filtro"><i class="far fa-star"></i> </label> <input
								type="radio" name="rel" id="rel-lendo" value="3"
								class="form-control col ml-2"> <label for="filtro"><i
								class="fas fa-book-reader"></i> </label>	
								<a class="btn btn-primary btn-lg active" href="livros?action=cad"> <i class="fas fa-edit" aria-pressed="true"></i>Cadastrar Livro</a>		
						</div>
					</div>
				</th>
			<tr>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Titulo</th>
				<th scope="col">Autor</th>
				<th scope="col">Categoria</th>
				<th scope="col">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="livro" items="${objLivros }">
				<tr>
					<th scope="row"><c:out value="${livro.id }" /></th>
					<td><c:out value="${livro.titulo }" /></td>
					<td><c:out value="${livro.autor }" /></td>
					<td><c:out value="${livro.categoria.titulo }" /></td>
					<td><i class="fas fa-book"></i> <i class="far fa-star"></i> <i
						class="fas fa-book-reader"></i></td>
				</tr>
			</c:forEach>
		</tbody>	
	</table>
</div>
<jsp:include page="inc/footer.jsp"></jsp:include>
