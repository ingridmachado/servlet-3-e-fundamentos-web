<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>

<c:if test="${usuarioLogado != null}">
	Você está logado como ${usuarioLogado.email} </br>
</c:if>

<form action="executa?tarefa=NovaEmpresa" method="post">
	Nome: <input type="text" name="nome" /> <br/>
	<input type="submit" value="Enviar" />
</form>

<form action="login" method="post">
	Email: <input type="text" name="email" />
	Senha: <input type="password" name="senha" />
	<input type="submit" value="Login" />
</form>

<form action="executa?tarefa=Logout" method="post" >
	<input type="submit" value="Deslogar" />
</form>

</body>
</html>