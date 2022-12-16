<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="data.Account"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="login/welcome/css/style.css">
<title>Welcome !</title>
</head>
<body>
	<header>
		<h1>Home</h1>
	</header>
	<main>
		<form id="homepage" class="form_class" action="welcome_back"
			method="post">
			<div class="info_div">
				<p>
					Welcome
					<%=session.getAttribute("nome")%>!
					<%=session.getAttribute("role")%>
					ID:
					<%=session.getAttribute("id")%></p>
				<button class="submit_class" type="submit" form="homepage">Login</button>
			</div>
		</form>
	</main>
	<footer>
		<p>
			<script>
				document.write(new Date().getFullYear())
			</script>

			Modified by <a
				href="https://www.linkedin.com/in/maxim-karlov-34b859162/"
				class="spam">Il_Maxone.</a>
		</p>
	</footer>
	<!-- LeadMark js -->
	<script src="home/js/leadmark.js"></script>
</body>
</html>