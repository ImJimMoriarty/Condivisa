<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.AccountDAO" %>
<%@page import="data.Account" %>
<!DOCTYPE html>
<html lang="en-us">

    <head>

        <!-- Meta -->
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <meta name="viewport" content="width=device-width,initial-scale=1">

        <title>User List</title>
        <meta name="description" content="">

        <!-- The compiled CSS file -->
        <link rel="stylesheet" href="browse/users/css/production.css">
        <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

        <!-- Web fonts -->
        <link href="https://fonts.googleapis.com/css?family=Karla:400,700" rel="stylesheet">

        <!-- favicon.ico. Place these in the root directory. -->
        <link rel="shortcut icon" href="favicon.ico">

    </head>

    <body class="has-animations">
    
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="/TestLogin/browse/index.jsp" class="navbar-brand"> HOME </a>
                    </div>
                    <form></form>
                    <ul class="navbar-nav">
                        <li><a href="/TestLogin/login/welcome/logout.jsp" class="nav-link">Logout</a></li>
                    </ul>
    </nav>

    <!-- Header -->
    <header class="pt2 pb1 align--center">
        <div class="container">
            <p>Welcome to</p>
            <h1 title="Camp Chippewa">JAMI70</h1>
        </div>
    </header>

    <!-- Body -->
    <main>
        
        <div class="container">
        <% AccountDAO acc = new AccountDAO(); %>
            <!-- Info -->
            <section class="grid-row grid-row--center">
                <!-- Cabin -->
                <% for(int i = 0; i < acc.selectAllAccounts().size(); i++){ %>
                <div class="grid-column span-half pt3 pb3 mobile-m order-1 reveal-on-scroll is-revealing">
                    <div class="relative">
                        <img class="info-image relative z2" src="browse/users/img/user-icon.jpg" alt="Cabin">
                        <div class="pattern pattern--left-down absolute z1"></div>
                        <h3 class="info-image relative z2">Nome Utente: <% out.print(acc.selectAllAccounts().get(i).getUsername()); %></h3>
                    	<h6 class="info-image relative z2">Email: <% out.print(acc.selectAllAccounts().get(i).getEmail()); %></h6>
                    </div>
                </div>
                <% } %>
            </section>
        </div>
    </main>

    <!-- Contact Section -->
	<section id="contact" class="section has-img-bg pb-0">
		<div class="container">
			<!-- Page Footer -->
			<footer class="mt-5 py-4 border-top border-secondary">
				<p class="mb-0 small">
					&copy;
					<script>
						document.write(new Date().getFullYear())
					</script>
					 Modified By <a
						href="https://www.linkedin.com/in/maxim-karlov-34b859162/"
						target="_blank">Il_Maxone.</a>
				</p>
			</footer>
			<!-- End of Page Footer -->
		</div>
	</section>

    <!-- Scroll reveal -->
    <script src="https://unpkg.com/scrollreveal@4.0.0/dist/scrollreveal.min.js"></script>

    <!-- The compiled JavaScript file -->
    <script src="browse/users/js/production.js"></script>

    </body>
</html>