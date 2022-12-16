<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.AccountDAO"%>
<%@page import="data.Account"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description"
	content="Start your development with LeadMark landing page.">
<meta name="author" content="Devcrud">
<title>Landing page</title>
<!-- Bootstrap + LeadMark main styles -->
<link rel="stylesheet" href="landing/css/leadmark.css">
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="40" id="home">

	<!-- page Navigation -->
	<nav
		class="navbar custom-navbar navbar-expand-md navbar-light fixed-top"
		data-spy="affix" data-offset-top="10">
		<div class="container">
			<a class="navbar-brand" href="#"> <img
				src="landing/imgs/logo.svg" alt="">
			</a>
			<button class="navbar-toggler ml-auto" type="button"
				data-toggle="collapse" data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item">
						<form>
							<input type="text" size="30" onkeyup="showResult(this.value)">
							<div id="livesearch"></div>
						</form> <script>
							function showResult(str) {
								if (str.length == 0) {
									document.getElementById("livesearch").innerHTML = "";
									document.getElementById("livesearch").style.border = "0px";
									return;
								}
								var xmlhttp=new XMLHttpRequest();
								xmlhttp.onreadystatechange=function() {
								  if (this.readyState==4 && this.status==200) {
								    document.getElementById("livesearch").innerHTML=this.responseText;
								    document.getElementById("livesearch").style.border="1px solid #A5ACB2";
								  }
								}
								xmlhttp.open("GET","search?nickname="+str,true);
								xmlhttp.send();
							}
						</script>
					</li>
					<li class="nav-item"><a class="nav-link" href="#contact">Contact</a>
					</li>
					<li class="nav-item">
						<div class="dropdown">
							<button class="ml-4 nav-link btn btn-primary btn-sm rounded">
								<div class="dropbtn">
									Account:
									<%=session.getAttribute("nome")%>
								</div>
							</button>
							<form id="browse_form" action="browse" method="post">
								<div class="dropdown-content">
									<a>
										<button type="submit" form="browse_form" name="account_button"
											value="true">&nbsp&nbsp&nbsp&nbsp Account
											&nbsp&nbsp&nbsp&nbsp</button>
									</a> <a>
										<button type="submit" form="browse_form" name="u_list_button"
											value="true">&nbsp&nbsp&nbsp&nbsp User List
											&nbsp&nbsp&nbsp&nbsp&nbsp</button>
									</a> <a>
										<button type="submit" form="browse_form" name="logout_button"
											value="true">&nbsp&nbsp&nbsp&nbsp&nbsp Logout
											&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</button>
									</a>
								</div>
							</form>
						</div>
						<style>
.dropbtn {
	color: white;
	border: none;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 160px;
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: tomato;
}
</style>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- End Of Second Navigation -->

	<!-- Page Header -->
	<header class="header">
		<div class="overlay">
			<h1 class="subtitle">Site Landing Page</h1>
			<h1 class="title">We Are Creative</h1>
		</div>
		<div class="shape">
			<svg viewBox="0 0 1500 200">
                <path
					d="m 0,240 h 1500.4828 v -71.92164 c 0,0 -286.2763,-81.79324 -743.19024,-81.79324 C 300.37862,86.28512 0,168.07836 0,168.07836 Z" />
            </svg>
		</div>
		<div class="mouse-icon">
			<div class="wheel"></div>
		</div>
	</header>
	<!-- End Of Page Header -->

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
					, LeadMark Modified By <a
						href="https://www.linkedin.com/in/maxim-karlov-34b859162/"
						target="_blank">Il_Maxone.</a> All rights reserved
				</p>
			</footer>
			<!-- End of Page Footer -->
		</div>
	</section>

	<!-- LeadMark js -->
	<script src="landing/js/leadmark.js"></script>

</body>
</html>