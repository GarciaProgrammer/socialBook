<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Usuário</title>
 <link rel="stylesheet" href="inc/cadastro.css">
</head>
<body>

<div class="container" >
    <a class="links" id="paracadastro"></a>
    <a class="links" id="paralogin"></a>
    
    <div class="content">      

      <!--FORMULÁRIO DE CADASTRO-->
      <div id="cadastro">
        <form method="post" action=""> 
          <h1>Cadastro de Usuário</h1> 
          
          <p> 
            <label> Nome:</label>
            <input id="nome" name="nome" type="text" placeholder="Gabriel garcia.." />
          </p>
          <p> 
            <label>Login:</label>
            <input id="login" name="login" type="text" placeholder="Crie um login.."/> 
          </p>
          <p> 
            <label>Senha</label>
            <input id="senha" name="senha" type="password" placeholder="****"/>
          </p>
          
          <p> 
            <input type="submit" value="Cadastrar"/> 
          </p>
          
        </form>
      </div>
    </div>
  </div> 

</body>
</html>