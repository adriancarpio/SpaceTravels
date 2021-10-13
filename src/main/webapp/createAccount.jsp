<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Create Account</h1>

	<form action="account" method="post">
		<table>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre" required="required"></td>

			</tr>

			<tr>
				<td>Apellido:</td>
				<td><input type="text" name="apellidos" required="required"></td>

			</tr>

			<tr>
				<td>Usuario:</td>
				<td><input type="text" name="usuario" required="required"></td>

			</tr>

			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" required="required"></td>

			</tr>

			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" required="required"></td>

			</tr>

			<tr>
				<td>Telefono:</td>
				<td><input type="text" name="telefono" required="required"></td>

			</tr>

			<tr>
				<td></td>
				<td><button type="submit">save</button></td>

			</tr>
		</table>
	</form>
</body>
</html>