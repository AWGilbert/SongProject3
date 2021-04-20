<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% String textValue=(String)request.getAttribute("songsParameter"); %>
	Here are the songs in that genre:
	<br>
	<%=textValue%>
	<br>
		<audio src="148132.mp3" controls></audio>
	<br>
	<form action=//DataServlet method="get">
		<% String selectionText=(String)request.getAttribute("genresParameter"); %>

		Select a different genre:<br><%=selectionText%><br> 
		

		<input type="submit" value="process" name="processGenre">
	</form>


</body>
</html>
