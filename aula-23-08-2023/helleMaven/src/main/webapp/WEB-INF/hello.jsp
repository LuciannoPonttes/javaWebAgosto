<%@page import="persistence.DaoFrase"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<% 
		DaoFrase daoFrase = new DaoFrase();
		String frase = daoFrase.buscarFrase();
	
	%>
	
	
	<h1>A frase que está no banco é:<%= frase %> </h1>

</body>
</html>