<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="inc/header.jsp"></jsp:include>

<div class="my-4">
	<h1>SocialBooks - Cadastrar Novo Livro</h1>
	<hr>
</div>
<div class="justify-content-center">
	<form action="livros" method="post">
		<div class="form-group">
			<label for="login">Categoria</label> 
			<select name="id_categoria" class="form-control">
				<option value="">Selecione</option>
				<c:forEach var="cat" items="${listaCat }">
					<option value="${cat.id }"><c:out value="${cat.titulo }" /></option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="titulo">Titulo</label> <input type="text" name="titulo"
				id="titulo" class="form-control">
		</div>
		<div class="form-group">
			<label for="autor">Autor</label> <input type="text" name="autor"
				id="autor" class="form-control">
		</div>
		<div class="form-group">
			<button class="btn btn-lg btn-block btn-success">Cadastrar</button>
		</div>
	</form>
</div>
<jsp:include page="inc/footer.jsp"></jsp:include>
