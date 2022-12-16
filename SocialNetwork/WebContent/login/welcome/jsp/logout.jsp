<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="data.Account" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="login/welcome/css/style.css">
    <title>Home - Paragliola 4Ever</title>
</head>
<body>
<header>
    <h1>Home</h1>
</header>
<main>
<form id="login_form" class="form_class" action="logout" method="post">
<div class="info_div">
            <p>Arrivederci !</p>
            <button class="submit_class" type="submit" form="login_form">Logout</button>
</div>
</form>
</main>
<footer>
    <p>Powered by <a href="#">Paragliola</a></p>
</footer>
</body>
</html>