<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AGENDA DE CONTATOS</title>
<link rel="icon" href="imagens/telefone.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar Contato</h1>
	<form name="frmContato" action="update">
		<table>
			<tr>
				<td><input type="text" name="idcon" id="caixa3" readonly value="<%= request.getAttribute("idcon") %>"></td>
				
			<tr>
				<td><input type="text" name="nome" class="caixa1" value="<%= request.getAttribute("nome") %>"></td>
			</tr>
			<tr>
				<td><input type="text" name="fone" class="caixa2" value="<%= request.getAttribute("fone") %>"></td>
			</tr>
			<tr>
				<td><input type="email" name="email" class="caixa1"value="<%= request.getAttribute("email") %>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="botao1" onclick="validar()">
	</form>
	<script src="scripts/Validador.js"></script>
</body>
</html>
