<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/SongProject3/DataServlet"
		method="get">
		<% String ctString=(String)request.getAttribute("songCt"); %>
		There are <%=ctString %> songs in the library.
		
		<% String selectionText=(String)request.getAttribute("genresParameter"); %>

		Please select a genre:<br><%=selectionText%><br> 
		

		<input type="submit" value="process" name="processGenre">
	</form>

</body>

</html>