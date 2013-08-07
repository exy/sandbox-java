<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<h1>Hello World!</h1>
	<p>This is the homepage!</p>
	<table>

		<c:forEach var="person" items="${listUser}">
			<tr>
				<td>toto</td>
				<td>${person.name}<c:out value="${person.name}" /></td>
				<td><c:out value="${person.password}" /></td>
				<td><c:out value="${person.login}" /></td>
			</tr>
		</c:forEach>
	</table>
	<c:out value="${listUser}" />
	${listUser}
</body>
</html>
