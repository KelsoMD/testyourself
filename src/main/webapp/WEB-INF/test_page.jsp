<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Данный сайт сделан с помощью конструктора Mobirise v4.6.5, https://mobiriz.store -->
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="generator" content="Mobirise v4.6.5, mobiriz.store">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Бесплатный конструктор сайтов Mobirise">
<title>test</title>
<link rel="stylesheet"
	href="assets/web/assets/mobirise-icons/mobirise-icons.css">
<link rel="stylesheet" href="assets/tether/tether.min.css">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="assets/bootstrap/css/bootstrap-grid.min.css">
<link rel="stylesheet"
	href="assets/bootstrap/css/bootstrap-reboot.min.css">
<link rel="stylesheet" href="assets/animatecss/animate.min.css">
<link rel="stylesheet"
	href="assets/datatables/data-tables.bootstrap4.min.css">
<link rel="stylesheet" href="assets/dropdown/css/style.css">
<link rel="stylesheet" href="assets/theme/css/style.css">
<link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css"
	type="text/css">



</head>
<body>
	<section class="menu cid-qOIWcb0pgA" once="menu" id="menu1-c">



		<nav
			class="navbar navbar-expand beta-menu navbar-dropdown align-items-center navbar-fixed-top navbar-toggleable-sm">
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<div class="hamburger">
					<span></span> <span></span> <span></span> <span></span>
				</div>
			</button>
			<div class="menu-logo">
				<div class="navbar-brand">

					<span class="navbar-caption-wrap"><a
						class="navbar-caption text-white display-4"
						href="https://mobirise.com">TEST YOURSELF</a></span>
				</div>
			</div>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav nav-dropdown nav-right"
					data-app-modern-menu="true">
					<li class="nav-item"><a
						class="nav-link link text-white display-4"
						href="https://mobirise.com"><span
							class="mbri-home mbr-iconfont mbr-iconfont-btn"
							style="color: rgb(255, 255, 255);">Глллавна</span> </a></li>
					<li class="nav-item"><a
						class="nav-link link text-white display-4"
						href="https://mobirise.com"><span
							class="mbri-search mbr-iconfont mbr-iconfont-btn"
							style="color: rgb(255, 255, 255);"></span> </a></li>
					<li class="nav-item"><a
						class="nav-link link text-white display-4"
						href="https://mobirise.com"><span
							class="mbri-italic mbr-iconfont mbr-iconfont-btn"
							style="color: rgb(255, 255, 255);"></span> </a></li>
					<li class="nav-item"><a
						class="nav-link link text-white display-4"
						href="https://mobirise.com"><span
							class="mbri-video mbr-iconfont mbr-iconfont-btn"
							style="color: rgb(255, 255, 255);"></span> </a></li>
					<li class="nav-item"><a
						class="nav-link link text-white display-4"
						href="https://mobirise.com"><span
							class="mbri-sites mbr-iconfont mbr-iconfont-btn"
							style="color: rgb(255, 255, 255);"></span> </a></li>
				</ul>

			</div>
		</nav>
	</section>

	<section class="section-table cid-qOIWRZ9j1F" id="table1-h">
	<form action="MainServlet" method="get">
	<input type="hidden" name="test" value="${test}">
		<c:forEach items="${test_questions}" var="question">
		
			<div class="container container-table">

				<h2
					class="mbr-section-title mbr-fonts-style align-center pb-3 display-2">
					${question.getText()}</h2>
				<c:if test="${not empty question.getImage()}">
					<h3
						class="mbr-section-subtitle mbr-fonts-style align-center pb-5 mbr-light display-5">
						<img alt="image" src="${question.getImage()}">
					</h3>
				</c:if>
				<div class="table-wrapper">
					<div class="container scroll">
						<table class="table isSearch" cellspacing="0">
							<tbody>
								<tr>
									<td class="body-item mbr-fonts-style display-7"><input
										type="checkbox" name="answer"
										value="${question.getCorrectAnswer()+='*'+=question.getId()}" />
										${question.getCorrectAnswer()}</td>
									<td class="body-item mbr-fonts-style display-7"><input
										type="checkbox" name="answer" value="${question.getAnswer1()+='*'+=question.getId()}" />
										${question.getAnswer1()}</td>
									<td class="body-item mbr-fonts-style display-7"><input
										type="checkbox" name="answer" value="${question.getAnswer2()+='*'+=question.getId()}"/>
										${question.getAnswer2()}</td>
									<td class="body-item mbr-fonts-style display-7"><input
										type="checkbox" name="answer" value="${question.getAnswer3()+='*'+=question.getId()}" />
										${question.getAnswer3()}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			
		</c:forEach>
		<div class="mbr-section-btn text-center pt-4"><input type="hidden" name="action" value="finish_test"/><button type="submit"
						class="btn btn-sm btn-black-outline display-4">Закончить</button></div>
	</form>
	</section>


	<script src="assets/web/assets/jquery/jquery.min.js"></script>
	<script src="assets/popper/popper.min.js"></script>
	<script src="assets/tether/tether.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/smoothscroll/smooth-scroll.js"></script>
	<script src="assets/touchswipe/jquery.touch-swipe.min.js"></script>
	<script src="assets/viewportchecker/jquery.viewportchecker.js"></script>
	<script src="assets/datatables/jquery.data-tables.min.js"></script>
	<script src="assets/datatables/data-tables.bootstrap4.min.js"></script>
	<script src="assets/dropdown/js/script.min.js"></script>
	<script src="assets/theme/js/script.js"></script>


	<input name="animation" type="hidden">
</body>
</html>